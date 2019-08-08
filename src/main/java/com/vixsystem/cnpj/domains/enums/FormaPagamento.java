package com.vixsystem.cnpj.domains.enums;

public enum FormaPagamento {
	MENSAL(1,"Mensal"),
	BIMESTRAL(2, "Bimestral"),
	TRIMESTRAL(3, "Trimestral"),
	SEMESTRAL(4, "Semestral"),
	ANUAL(5, "Anual");
	
	
	private int cod;
	private String descricao;
	
	private FormaPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static FormaPagamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for (FormaPagamento x : FormaPagamento.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("id invalido: " + cod);
	}
}
