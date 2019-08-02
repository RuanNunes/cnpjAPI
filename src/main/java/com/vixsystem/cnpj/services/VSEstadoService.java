package com.vixsystem.cnpj.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vixsystem.cnpj.domains.VSEstado;
import com.vixsystem.cnpj.repositories.CnpjDadosCadastraisPjRepository;
import com.vixsystem.cnpj.repositories.VSEstadoRepository;

@Service
public class VSEstadoService {
	@Autowired
	private VSEstadoRepository estadoRepository;
	@Autowired 
	private CnpjDadosCadastraisPjRepository cnpjDadosCadastraisPjRepository;
	public void insertEstadoPadrao() {
		if(estadoRepository.findAll().isEmpty()) {
			List<String> listEstados = cnpjDadosCadastraisPjRepository.selectEstados();
			for (String string : listEstados) {
				estadoRepository.save(new VSEstado(null, string));
			}
		}
	}
	
	
	private String getNomePorUF(String string) {
		if(string.equals("AC"))
			return "Acre";
		if(string.equals("AL"))
			return "Alagoas";
		if(string.equals("AP"))
			return "Amapá";
		if(string.equals("AM"))
			return "Amazonas";
		if(string.equals("BA"))
			return "Bahia";
		if(string.equals("CE"))
			return "Ceará";
		if(string.equals("DF"))
			return "Distrito Federal";
		if(string.equals("ES"))
			return "Espírito Santo";
		if(string.equals("GO"))
			return "Goiás";
		if(string.equals("MA"))
			return "Maranhão";
		if(string.equals("MT"))
			return "Mato Grosso";
		if(string.equals("MS"))
			return "Mato Grosso do Sul";
		if(string.equals("MG"))
			return "Minas Gerais";
		if(string.equals("PA"))
			return "Pará";
		if(string.equals("PB"))
			return "Paraíba";
		if(string.equals("PR"))
			return "Paraná";
		if(string.equals("PE"))
			return "Pernambuco";
		if(string.equals("PI"))
			return "Piauí";
		if(string.equals("RJ"))
			return "Rio de Janeiro";
		if(string.equals("RN"))
			return "Rio Grande do Norte";
		if(string.equals("RS"))
			return "Rio Grande do Sul";
		if(string.equals("RO"))
			return "Rondônia";
		if(string.equals("RR"))
			return "Roraima";
		if(string.equals("SC"))
			return "Santa Catarina";
		if(string.equals("SP"))
			return "São Paulo";
		if(string.equals("SE"))
			return "Sergipe";
		if(string.equals("TO"))
			return "Tocantins";
		
		return null;
	}
	
}
