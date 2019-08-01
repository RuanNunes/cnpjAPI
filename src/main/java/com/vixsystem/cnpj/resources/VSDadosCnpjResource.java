package com.vixsystem.cnpj.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vixsystem.cnpj.DTOS.VSClienteDTO;
import com.vixsystem.cnpj.services.VSDadosCnpjService;

@RestController
@RequestMapping(value = "/v1/cnpjVS")
public class VSDadosCnpjResource {
	
	@Autowired
	private VSDadosCnpjService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String id) {
		return ResponseEntity.ok().body(service.findCnpj(id));
	}
	
//	@RequestMapping(value = "/login" , method = RequestMethod.POST)
//	public ResponseEntity<Void> insert( @RequestBody VSClienteDTO objDTO){
////		VSClienteDTO obj = service.insert(service.fromDTO(objDTO));
//		//retorna url com novo registro inserido
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//				.path("/{id}").buildAndExpand(obj.getId()).toUri();
//		return ResponseEntity.created(uri).build();
//	}

}
