package com.vixsystem.cnpj.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vixsystem.cnpj.domains.CnpjDadosCadastraisPj;
import com.vixsystem.cnpj.projections.CnpjDadosCadastraisPjProjection;
import com.vixsystem.cnpj.repositories.CnpjDadosCadastraisPjRepository;
import com.vixsystem.cnpj.services.exceptions.ObjectNotFoundException;

@Service
public class CnpjDadosCadastraisPjService {
	@Autowired
	private CnpjDadosCadastraisPjRepository cadastraisPjRepository;
	public CnpjDadosCadastraisPj find(Integer id) {
		Optional<CnpjDadosCadastraisPj> obj = cadastraisPjRepository.findById(id);
		//orElseThrow recebe função que instancia uma exception customizada utilizando uma expressão lambda
		return obj.orElseThrow(() -> new ObjectNotFoundException(    "Objeto não encontrado! Id: " 
									+ id + ", Tipo: " + CnpjDadosCadastraisPj.class.getName())); 
	}
	
	public void updateMigrados() {
		List<CnpjDadosCadastraisPjProjection> ids = cadastraisPjRepository.updateMigrados(1707);
		for (CnpjDadosCadastraisPjProjection x : ids) {
			CnpjDadosCadastraisPj obj = find(x.getId());
			obj.setMigrado(null);
			cadastraisPjRepository.save(obj);
		}
		
	}
}
