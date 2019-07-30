package com.vixsystem.cnpj.DTOS;

import java.io.Serializable;

public class VSClienteDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String senha;
	
	public VSClienteDTO() {
		
	}

	public VSClienteDTO(String nome, String senha) {
		super();
		this.nome = nome;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
