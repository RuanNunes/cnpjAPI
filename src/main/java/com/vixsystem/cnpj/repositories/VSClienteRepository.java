package com.vixsystem.cnpj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vixsystem.cnpj.domains.VSCliente;
@Repository
public interface VSClienteRepository extends JpaRepository<VSCliente, Integer>{
	VSCliente findByNomeAndSenha(String nome, String senha);
}
