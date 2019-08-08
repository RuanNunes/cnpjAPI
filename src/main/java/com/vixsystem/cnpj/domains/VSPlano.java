package com.vixsystem.cnpj.domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "vs_plano")
public class VSPlano implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@OneToMany(mappedBy = "plano")
	private List<VSItensPlano> itensPlano = new ArrayList<>();
	
	@OneToMany(mappedBy = "plano" )
	private List<VSCliente> cliente = new ArrayList<>();
	
	@OneToMany(mappedBy = "plano" )
	private List<VSPagamento> pagamentos = new ArrayList<>();
	
	public VSPlano() {
		
	}
	
	public VSPlano(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<VSItensPlano> getItensPlano() {
		return itensPlano;
	}
	public void setItensPlano(List<VSItensPlano> itensPlano) {
		this.itensPlano = itensPlano;
	}

	public List<VSPagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<VSPagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VSPlano other = (VSPlano) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
