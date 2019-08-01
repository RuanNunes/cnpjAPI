package com.vixsystem.cnpj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vixsystem.cnpj.domains.VSCliente;
import com.vixsystem.cnpj.repositories.VSClienteRepository;
import com.vixsystem.cnpj.security.UserSS;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private VSClienteRepository clienteRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		VSCliente cli = clienteRepository.findByEmail(email);
		if(cli == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(cli.getId(), cli.getEmail(), cli.getSenha(), cli.getPerfis());
	}

}
