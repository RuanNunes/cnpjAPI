package com.vixsystem.cnpj.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vixsystem.cnpj.domains.VSCliente;
import com.vixsystem.cnpj.repositories.VSClienteRepository;
import com.vixsystem.cnpj.repositories.VSEnderecoRepository;
import com.vixsystem.cnpj.services.exceptions.DataIntegrityException;
import com.vixsystem.cnpj.services.exceptions.ObjectNotFoundException;

@Service
public class VSClienteService {
	
	@Autowired
	private VSClienteRepository clienteRepository;
	
	@Autowired
	private VSEnderecoRepository enderecoRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void insertClientePadrao() {
//		VSCliente cliente = new VSCliente("teste@gmail.com", encoder.encode("123"));
//		clienteRepository.save(cliente);
	}
	
	public VSCliente find(Integer id) {
//		UserSS user = UserService.authenticated();
//		
//		if(user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
//			throw new AuthorizationException("Acesso negado.");
//		}
		
		Optional<VSCliente> obj = clienteRepository.findById(id);
		//orElseThrow recebe função que instancia uma exception customizada utilizando uma expressão lambda
		return obj.orElseThrow(() -> new ObjectNotFoundException(    "Objeto não encontrado! Id: " 
									+ id + ", Tipo: " + VSCliente.class.getName())); 
	}
	
	public VSCliente insert(VSCliente obj) {
		obj.setId(null);
		obj = clienteRepository.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}
	
	public VSCliente update (VSCliente obj) {
		VSCliente newObj = find(obj.getId());
		updateDate(newObj, obj);
		return clienteRepository.save(newObj);
	}
	
	public void deleteById(Integer id) {
		find(id);
		
		try {
			clienteRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}
	
	public List<VSCliente> findAll(){
		return clienteRepository.findAll();
	}
	
	public Page<VSCliente> findPage(Integer page, Integer linesPerPage, String direction, String orderBy){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return clienteRepository.findAll(pageRequest);
	}
	
	private void updateDate(VSCliente newObj, VSCliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
	
}
