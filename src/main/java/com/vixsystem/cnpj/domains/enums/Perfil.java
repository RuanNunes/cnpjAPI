package com.vixsystem.cnpj.domains.enums;
/** Enum perfil criado para definir futuramente os tipo de plano que o cliente escolher
 * @author Ruan Nunes
 */
public enum Perfil {
	//ROLE É EXIGENCIA DO SPRING SECURITY
	ADMIN(1,"ROLE_ADMIN"),
	CLIENTE(2,"ROLE_CLIENTE");
	
	private int cod;
	private String descricao;
	
	private Perfil(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Perfil toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for (Perfil picanha : Perfil.values()) {
			if(cod.equals(picanha.getCod())) {
				return picanha;
			}
		}
		throw new IllegalArgumentException("id invalido: " + cod);
	}
}
