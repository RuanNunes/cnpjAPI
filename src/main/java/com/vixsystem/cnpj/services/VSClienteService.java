package com.vixsystem.cnpj.services;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.vixsystem.cnpj.domains.VSCliente;
import com.vixsystem.cnpj.repositories.VSClienteRepository;

@Service
public class VSClienteService {
	private VSClienteRepository clienteRepository;
	
	public String geraToken(String nome, String senha) {
		VSCliente obj = clienteRepository.findByNomeAndSenha(nome, senha);
		if(obj != null) {
			
		}
		return null;
	}
	
}
