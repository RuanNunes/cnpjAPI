package com.vixsystem.cnpj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vixsystem.cnpj.services.CnpjDadosCadastraisPjService;
import com.vixsystem.cnpj.services.VSClienteService;
import com.vixsystem.cnpj.services.VSDadosCnpjService;
import com.vixsystem.cnpj.services.VSEstadoService;

@SpringBootApplication
public class CnpjFileApplication implements CommandLineRunner{
	@Autowired
	private VSDadosCnpjService cnpjService;
	@Autowired
	private CnpjDadosCadastraisPjService cadastraisPjService;
	@Autowired
	private VSClienteService clienteService;
	@Autowired
	private VSEstadoService estadoService;
	public static void main(String[] args) {
		SpringApplication.run(CnpjFileApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		/**
		 * Metodo responsavel por fazer migração dos dados da receita para o layout da vixSystem
		 * @author Ruan Nunes
		 * @param limit -> responsavel por limitar a quantidade de registros no select da tabela da receita federal
		 * @param interações -> responsavel por definir quantas vezes o select sera executado
		 * @param UF -> responsavel por dizer de qual estado sera migrado  
		 * @param cont -> Responsavel por mostrar ao final da migração quantos registroa ainda falta para ser migrados do estado selecionado
		 * obs.: parametro como true executa consulta demorada
		 * Estados já migrados:
		 * --------------------> BA
		 * 
		 */
		Integer limit = 10000;
		int interacoes = 40;
		String UF = "es";
		boolean cont = false;
//		cnpjService.migration(limit, interacoes, UF, cont);
//		cadastraisPjService.updateMigrados();
//		clienteService.insertClientePadrão();
//		estadoService.insertEstadoPadrao();
	}
}
