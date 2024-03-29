package com.vixsystem.cnpj.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vixsystem.cnpj.services.VSDadosCnpjService;

@RestController
@RequestMapping(value = "/v1/cnpjFile")
public class VSDadosCnpjResource {
	
	@Autowired
	private VSDadosCnpjService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String id) {
		return ResponseEntity.ok().body(service.findCnpj(id));
	}
}
