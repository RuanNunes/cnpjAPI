package com.vixsystem.cnpj.domains.enums;

public enum TipoPagamento {

	PAGAMENTOCOMBOLETO(1,"Pagamento com Boleto"),
	PAGAMENTOCOMCARTAO(2,"Pagamento com Cartão");
	
	private int cod;
	private String descricao;
	
	private TipoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoPagamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for (TipoPagamento picanha : TipoPagamento.values()) {
			if(cod.equals(picanha.getCod())) {
				return picanha;
			}
		}
		throw new IllegalArgumentException("id invalido: " + cod);
	}
}
