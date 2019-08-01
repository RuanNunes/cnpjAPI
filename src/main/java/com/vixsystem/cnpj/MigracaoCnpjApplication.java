package com.vixsystem.cnpj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vixsystem.cnpj.repositories.VSClienteRepository;
import com.vixsystem.cnpj.services.CnpjDadosCadastraisPjService;
import com.vixsystem.cnpj.services.VSClienteService;
import com.vixsystem.cnpj.services.VSDadosCnpjService;

@SpringBootApplication
public class MigracaoCnpjApplication implements CommandLineRunner{
	@Autowired
	private VSDadosCnpjService cnpjService;
	@Autowired
	private CnpjDadosCadastraisPjService cadastraisPjService;
	@Autowired
	private VSClienteService clienteService;
	public static void main(String[] args) {
		SpringApplication.run(MigracaoCnpjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		cnpjService.migration();
//		cadastraisPjService.updateMigrados();
		clienteService.insertClientePadrão();
	}

}
