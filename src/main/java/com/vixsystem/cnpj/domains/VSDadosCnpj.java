package com.vixsystem.cnpj.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "vs_dados_cnpj")
public class VSDadosCnpj implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeRazaoSocial;
	private String nomeFantasia;
	private String estado;
	private String municipio;
	private String bairro;
	private String cep;
	private Integer cnae;
	@Column(precision = 14)
	private String cnpj;
	
	public VSDadosCnpj() {
		
	}
	
	public VSDadosCnpj(Object[] columns) {
        this.nomeRazaoSocial = (String)columns[0];
        this.nomeFantasia = (String) columns[1];
        this.estado = (String)columns[2];
        this.municipio = (String)columns[3];
        this.bairro = (String)columns[4];
        this.cnae = Integer.valueOf((String)columns[5]);
        this.cnpj = (String)columns[6];
        
    }
	
	public VSDadosCnpj(Integer id, String nomeRazaoSocial, String nomeFantasia, String estado, String municipio,
			String bairro,String cep, Integer cnae, String cnpj) {
		super();
		this.id = id;
		this.nomeRazaoSocial = nomeRazaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.estado = estado;
		this.municipio = municipio;
		this.bairro = bairro;
		this.cep = cep;
		this.cnae = cnae;
		this.cnpj = cnpj;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeRazaoSocial() {
		return nomeRazaoSocial;
	}

	public void setNomeRazaoSocial(String nomeRazaoSocial) {
		this.nomeRazaoSocial = nomeRazaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Integer getCnae() {
		return cnae;
	}

	public void setCnae(Integer cnae) {
		this.cnae = cnae;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
		VSDadosCnpj other = (VSDadosCnpj) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
}
