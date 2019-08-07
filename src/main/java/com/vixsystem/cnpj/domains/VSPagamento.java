package com.vixsystem.cnpj.domains;

import java.util.Date;

public class VSPagamento {
	private Integer id;
	private VSPlano plano; //notNull
//	private TipoPagamento tipo; // notnull
	private Date dataPagamento; // notnull
	private VSCliente cliente; // notnull
	private String token; // notnull
	private Integer numeroBoleto; // null
	private String resposta; //notnull
//	private VSFormaPagamento formaPagamento;

}
