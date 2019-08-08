package com.vixsystem.cnpj.domains;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



import com.vixsystem.cnpj.domains.enums.FormaPagamento;
import com.vixsystem.cnpj.domains.enums.TipoPagamento;

@Entity
@Table(name = "vs_pagamento")
public class VSPagamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "plano_id")
	private VSPlano plano;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private VSCliente cliente;
	
	@NotNull
	private Integer tipo;
	
	@NotNull
	private Integer formaPagamento;
	
	@NotNull
	private Date dataPagamento; 
	private Date dataEmicaoBoleto;
	private Date dataVencimentoBoleto;
	private Integer numeroBoleto;
	
	@NotNull
	private String token; 

	@NotNull
	private String resposta;
	
	public VSPagamento() {
		
	}

	public VSPagamento(Integer id, VSPlano plano, VSCliente cliente, TipoPagamento tipo, FormaPagamento formaPagamento,
			Date dataPagamento, Date dataEmicaoBoleto, Date dataVencimentoBoleto, Integer numeroBoleto, String token,
			String resposta) {
		super();
		this.id = id;
		this.plano = plano;
		this.cliente = cliente;
		this.tipo = tipo.getCod();
		this.formaPagamento = formaPagamento.getCod();
		this.dataPagamento = dataPagamento;
		this.dataEmicaoBoleto = dataEmicaoBoleto;
		this.dataVencimentoBoleto = dataVencimentoBoleto;
		this.numeroBoleto = numeroBoleto;
		this.token = token;
		this.resposta = resposta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public VSPlano getPlano() {
		return plano;
	}

	public void setPlano(VSPlano plano) {
		this.plano = plano;
	}

	public VSCliente getCliente() {
		return cliente;
	}

	public void setCliente(VSCliente cliente) {
		this.cliente = cliente;
	}

	public TipoPagamento getTipo() {
		return TipoPagamento.toEnum(tipo);
	}

	public void setTipo(TipoPagamento tipo) {
		this.tipo = tipo.getCod();
	}

	public FormaPagamento getFormaPagamento() {
		return FormaPagamento.toEnum(formaPagamento);
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento.getCod();
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Date getDataEmicaoBoleto() {
		return dataEmicaoBoleto;
	}

	public void setDataEmicaoBoleto(Date dataEmicaoBoleto) {
		this.dataEmicaoBoleto = dataEmicaoBoleto;
	}

	public Date getDataVencimentoBoleto() {
		return dataVencimentoBoleto;
	}

	public void setDataVencimentoBoleto(Date dataVencimentoBoleto) {
		this.dataVencimentoBoleto = dataVencimentoBoleto;
	}

	public Integer getNumeroBoleto() {
		return numeroBoleto;
	}

	public void setNumeroBoleto(Integer numeroBoleto) {
		this.numeroBoleto = numeroBoleto;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
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
		VSPagamento other = (VSPagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
