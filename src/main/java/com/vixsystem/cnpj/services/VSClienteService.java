package com.vixsystem.cnpj.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vixsystem.cnpj.domains.VSCliente;
import com.vixsystem.cnpj.repositories.VSClienteRepository;

@Service
public class VSClienteService {
	
	@Autowired
	private VSClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void insertClientePadrão() {
//		VSCliente cliente = new VSCliente("teste@gmail.com", encoder.encode("123"));
//		clienteRepository.save(cliente);
	}
	
}
