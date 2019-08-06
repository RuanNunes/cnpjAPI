package com.vixsystem.cnpj.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vixsystem.cnpj.services.VSDadosCnpjService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/v1/cnpjFile")
public class VSDadosCnpjResource {
	
	@Autowired
	private VSDadosCnpjService service;
	
	@ApiOperation(value="Busca por cnpj") 
	@ApiResponses(value = {
//			@ApiResponse(code = 400, message = "Não é possível excluir uma categoria que possui produtos"),
			@ApiResponse(code = 404, message = "Cnpj Invalido") }) 
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String id) {
		return ResponseEntity.ok().body(service.findCnpj(id));
	}
}
