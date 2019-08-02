package com.vixsystem.cnpj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vixsystem.cnpj.domains.VSEstado;
@Repository
public interface VSEstadoRepository extends JpaRepository<VSEstado, Integer>{
	
}
