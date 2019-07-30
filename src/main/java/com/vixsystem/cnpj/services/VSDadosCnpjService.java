package com.vixsystem.cnpj.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.vixsystem.cnpj.domains.CnpjDadosCadastraisPj;
import com.vixsystem.cnpj.domains.VSDadosCnpj;
import com.vixsystem.cnpj.projections.VCDadosCnpjProjection;
import com.vixsystem.cnpj.repositories.CnpjDadosCadastraisPjRepository;
import com.vixsystem.cnpj.repositories.VSDadosCnpjRepository;

@Service
public class VSDadosCnpjService {
	@Autowired
	private VSDadosCnpjRepository cnpjRepository;
	@Autowired
	private CnpjDadosCadastraisPjRepository cadastraisPjRepository;
	@Autowired
	private CnpjDadosCadastraisPjService cadastraisPjService;
	private long inicioSelect;
	private long fimSelect;
	private long divisao;
	private String n;
	public void migration (){
		//Utilizando Framework SpringDataJpa
		List<String> msLog = new ArrayList<>();
		List<Long> timeLog = new ArrayList<>();
		
		Integer limit = 10;
		int interacoes = 10;
		for (int i = 0; i < interacoes; i++) {
			inicioSelect = System.currentTimeMillis();
			List<VCDadosCnpjProjection> projection = cnpjRepository.selectMigration(limit);
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
				}
			}
			fimSelect = System.currentTimeMillis();
			msLog.add(timeMille(" TEMPO PARA FAZER MIGRAÇÃO DA " + i + " INTERAÇÃO ",0));
			timeLog.add(segundos());
		}
		for (String string : msLog) {
			System.out.println(string);
		}
		long tempoTotal = 0;
		for (Long long1 : timeLog) {
			tempoTotal = tempoTotal + long1;
		}
		System.out.println(timeMille(" TEMPO PARA FAZER MIGRAÇÃO DE TODAS INTERAÇÕES ", tempoTotal));
		System.out.println(" TOTAL DE REGISTROS MIGRADOS " + (limit * interacoes));
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
		return cnpjRepository.findByCnpj(cnpj);
	}
	
	//Utilizando EntityManager JPA nativo
//		@PersistenceContext
//		private EntityManager entityManager;
//		
//		private long cont() {
//			inicioSelect = System.currentTimeMillis();
//			String queryStr = "select count (id) from cnpj_dados_cadastrais_pj ";
//			try {
//				Query query = entityManager.createNativeQuery(queryStr);
//				long cont = (long) query.getResultList().get(0);
//				fimSelect = System.currentTimeMillis();
//				timeMille(" CONTADOR ");
//				return cont;
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw e;
//			}
//		}
		
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
