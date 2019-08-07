package com.vixsystem.cnpj.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vixsystem.cnpj.domains.VSCliente;
import com.vixsystem.cnpj.services.VSClienteService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/v2/cnpjFile/clientes")
public class VSClienteResource {
	
	@Autowired
	private VSClienteService service;
	
	@ApiOperation(value="Busca por cliente") 
	@ApiResponses(value = {
//			@ApiResponse(code = 400, message = "Não é possível excluir uma categoria que possui produtos"),
			@ApiResponse(code = 404, message = "cliente não encontrado") }) 
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		return ResponseEntity.ok().body(service.find(id));
	}
	
	@ApiOperation(value="Inclusão de cliente")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody VSCliente objDTO){
//		VSCliente obj = service.insert(service.fromDTO(objDTO));
		VSCliente obj = service.insert(objDTO);
		//retorna url com novo registro inserido
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//	public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO objDTO, @PathVariable Integer id){
//		VSCliente obj = service.fromDTO(objDTO);
//		obj.setId(id);
//		obj = service.update(obj);
//		return ResponseEntity.noContent().build();
//	}
	
	@ApiOperation(value="Delete de Cliente")
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
//	@PreAuthorize("hasAnyRole('ADMIN')")
//	@RequestMapping( method = RequestMethod.GET)
//	public ResponseEntity<List<ClienteDTO>> findAll() {
//		List<ClienteDTO> listDTO = service.findAll().stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
//		return ResponseEntity.ok().body(listDTO);
//	}
	
//	@PreAuthorize("hasAnyRole('ADMIN')")
//	@RequestMapping(value = "/page", method = RequestMethod.GET)
//	public ResponseEntity<Page<ClienteDTO>> findPage(
//			@RequestParam(value = "page", defaultValue = "0") Integer page,
//			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
//			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
//			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy)
//	{
//		Page<ClienteDTO> listDTO = service.findPage(page,linesPerPage,direction,orderBy).map(obj -> new ClienteDTO(obj));
//		return ResponseEntity.ok().body(listDTO);
//	}
}
