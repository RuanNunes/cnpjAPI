package com.vixsystem.cnpj.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vixsystem.cnpj.domains.CnpjDadosCadastraisPj;
import com.vixsystem.cnpj.domains.VSDadosCnpj;
import com.vixsystem.cnpj.projections.VCDadosCnpjProjection;
import com.vixsystem.cnpj.repositories.CnpjDadosCadastraisPjRepository;
import com.vixsystem.cnpj.repositories.VSDadosCnpjRepository;
import com.vixsystem.cnpj.services.exceptions.ObjectNotFoundException;
import com.vixsystem.cnpj.services.validation.utils.BR;

@Service
public class VSDadosCnpjService {
	@Autowired
	private VSDadosCnpjRepository cnpjRepository;
	@Autowired
	private CnpjDadosCadastraisPjRepository cadastraisPjRepository;
	@Autowired
	private CnpjDadosCadastraisPjService cadastraisPjService;
	@Autowired
	private VSEstadoService estadoService;
	private long inicioSelect;
	private long fimSelect;
	private long divisao;
	private String n;
	public void migration (Integer limit, int interacoes, String uf, boolean cont){
		//Utilizando Framework SpringDataJpa
		uf = uf.toUpperCase();
		List<String> msLog = new ArrayList<>();
		List<Long> timeLog = new ArrayList<>();
		boolean isExibirLog = true;
		Integer contadorDeRegistrosMigrados = 0;
		for (int i = 0; i < interacoes; i++) {
			inicioSelect = System.currentTimeMillis();
			List<VCDadosCnpjProjection> projection = cnpjRepository.selectMigration(limit,uf);
			if(projection.get(0) == null) {
				System.out.println("TODOS OS REGISTROS DE " + uf.toUpperCase() + " FORAM MIGRADOS");
				if(i >= 1) {
					exibeLog(msLog, timeLog, isExibirLog, limit, i, contadorDeRegistrosMigrados);
				}
				isExibirLog = false;
				break;
			}
			
			for (VCDadosCnpjProjection x : projection) {
				if(x.getMigrado() == null) {
					//Salva registro em layout novo
					VSDadosCnpj cnpj = new VSDadosCnpj(null, x.getRazao_social(), x.getNome_fantasia(),
							x.getUF(), x.getMunicipio(), x.getBairro(), x.getCep(), x.getCnae_fiscal(), x.getCnpj());
					cnpjRepository.save(cnpj);
					
					//Altera tabela antiga para saber que registro foi migrado
					CnpjDadosCadastraisPj dadosCadastraisPj = cadastraisPjService.find(x.getId());
					dadosCadastraisPj.setMigrado("S");
					cadastraisPjRepository.save(dadosCadastraisPj);
					contadorDeRegistrosMigrados ++;
				}
			}
			fimSelect = System.currentTimeMillis();
			msLog.add(timeMille(" TEMPO PARA FAZER MIGRAÇÃO DA " + i + " INTERAÇÃO ",0));
			timeLog.add(segundos());
		}
		exibeLog(msLog, timeLog, isExibirLog, limit, interacoes, contadorDeRegistrosMigrados);
		if(cont)
			cont(uf);
	}
	
	private void exibeLog(List<String> msLog, List<Long> timeLog, boolean isExibirLog, Integer limit, int interacoes, Integer registrosMigrados) {
		if(isExibirLog) {
			for (String string : msLog) {
				System.out.println(string);
			}
			long tempoTotal = 0;
			for (Long long1 : timeLog) {
				tempoTotal = tempoTotal + long1;
			}
			System.out.println(timeMille(" TEMPO PARA FAZER MIGRAÇÃO DE TODAS INTERAÇÕES ", tempoTotal));
			System.out.println(" TOTAL DE REGISTROS MIGRADOS " + registrosMigrados);
		}
	}
	
	private String timeMille(String variavel, long segundos) {
		if(segundos == 0) {
			divisao = segundos();
		}else {
			divisao = segundos;
		}
		
		n = " Segundos";
		if(divisao > 60) {
			n = " Minutos";
			divisao = divisao / 60;
		}
		
		return variavel + divisao + n;
	}
	private long segundos() {
		return (fimSelect - inicioSelect) / 1000;
	}
	
	
	public VSDadosCnpj findCnpj(String cnpj) {
		
		if(!BR.isValidCNPJ(cnpj))
			throw new ObjectNotFoundException("Cnpj Invalido.");
		
		VSDadosCnpj obj = cnpjRepository.findByCnpj(cnpj);
		if(obj == null)
			throw new ObjectNotFoundException("Cnpj não encontrado, provavelmente foi gerado por uma ferramenta.");
		
		return obj;
	}
	
	//Utilizando EntityManager JPA nativo
		@PersistenceContext
		private EntityManager entityManager;
		
		private void cont( String uf) {
			inicioSelect = System.currentTimeMillis();
			String queryStr = "select count (0) from cnpj_dados_cadastrais_pj where migrado isnull and uf = '" + uf + "'";
			try {
				Query query = entityManager.createNativeQuery(queryStr);
				BigInteger cont = (BigInteger) query.getResultList().get(0);
				fimSelect = System.currentTimeMillis();
				System.out.println(timeMille("TEMPO PARA FAZER CONTAGEM DE REGISTROS QUE FALTAM SER MIGRADOS: ", segundos()));
				System.out.println("FALTAM " + cont  + " REGISTROS DO ESTADO DE " + estadoService.getNomePorUF(uf) + " PARA SER MIGRADOS");
				
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
		
//		private List<VSDadosCnpj> select (){
//			String queryStr = "select " + 
//					"	a.razao_social," + 
//					"	a.nome_fantasia," + 
//					"	a.uf," + 
//					"	a.municipio," + 
//					"	a.bairro," + 
//					"	a.cnae_fiscal," + 
//					"	a.cnpj " + 
//					"from cnpj_dados_cadastrais_pj a "
//					+ "limit 10";
//			try {
//				Query query = entityManager.createNativeQuery(queryStr);
//				List<Object[]> authors = query.getResultList();
//				List<VSDadosCnpj> listCnpj = new ArrayList<>();
//				for (Object[] objects : authors) {
//					listCnpj.add(new VSDadosCnpj(objects));
//				}
//				return listCnpj;
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw e;
//			}
//		}
	
}
