package com.vixsystem.cnpj.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vixsystem.cnpj.services.VSDadosCnpjService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/v2/cnpjFile")
public class VSDadosCnpjResource {
	
	@Autowired
	private VSDadosCnpjService service;
	
	@Autowired
	private VSDadosCnpjService cnpjService;
	
	@ApiOperation(value="Busca por cnpj") 
	@ApiResponses(value = {
//			@ApiResponse(code = 400, message = "Não é possível excluir uma categoria que possui produtos"),
			@ApiResponse(code = 404, message = "Cnpj Invalido ou não encontrado") }) 
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String id) {
		return ResponseEntity.ok().body(service.findCnpj(id));
	}
	
	@RequestMapping(value = "/migration", method = RequestMethod.POST)
	public ResponseEntity<?> migration(
			@RequestParam(value = "limit", defaultValue = "1000" ) Integer limit,
			@RequestParam(value = "interacoes", defaultValue = "10" ) int interacoes,
			@RequestParam(value = "UF", defaultValue = "") String UF,
			@RequestParam(value = "cont", defaultValue = "false") boolean cont)
	{
//		Integer limit = 222073;
//		int interacoes = 1;
//		String UF = "es";
//		boolean cont = false;
//		cnpjService.migration(limit, interacoes, UF, cont);
		return ResponseEntity.ok().body(cnpjService.migration(limit, interacoes, UF, cont));
	}
	
}
