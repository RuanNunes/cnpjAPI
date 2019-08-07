package com.vixsystem.cnpj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vixsystem.cnpj.domains.VSEndereco;
@Repository
public interface VSEnderecoRepository extends JpaRepository<VSEndereco, Integer>{
	
}
