package com.vixsystem.cnpj.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vixsystem.cnpj.projections.VCDadosCnpjProjection;

@Entity
@Table(name = "cnpj_dados_cadastrais_pj")
public class CnpjDadosCadastraisPj implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String tipo_de_registro;
	private String indicador ;
	private String tipo_atualizacao;
	private String cnpj ;
	private String identificador_matriz_filial ;
	private String razao_social ;
	private String nome_fantasia ;
	private String situacao_cadastral ;
	private String data_situacao_cadastral ;
	private String motivo_situacao_cadastral ;
	private String nm_cidade_exterior ;
	private String cod_pais ;
	private String nm_pais ;
	private String codigo_natureza_juridica ;
	private String data_inicio_atividade ;
	private String cnae_fiscal ;
	private String descricao_tipo_logradouro ;
	private String logradouro ;
	private String numero ;
	private String complemento ;
	private String  bairro ;
	private String cep ;
	private String uf ;
	private String codigo_municipio ;
	private String municipio ;
	private String ddd_telefone_1 ;
	private String ddd_telefone_2 ;
	private String ddd_fax ;
	private String correio_eletronico ;
	private String qualificacao_responsavel ;
	private String capital_social_empresa ;
	private String porte_empresa ;
	private String opcao_pelo_simples ;
	private String data_opcao_pelo_simples ;
	private String data_exclusao_simples ;
	private String opcao_pelo_mei ;
	private String situacao_especial ;
	private String data_situacao_especial ;
	private String filler ;
	private String fim_registro ;
	private String migrado;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	public CnpjDadosCadastraisPj() {
		
	}
	
	public CnpjDadosCadastraisPj(VCDadosCnpjProjection projection) {
		id = projection.getId();
		migrado = "S";
	}

	public String getTipo_de_registro() {
		return tipo_de_registro;
	}

	public void setTipo_de_registro(String tipo_de_registro) {
		this.tipo_de_registro = tipo_de_registro;
	}

	public String getIndicador() {
		return indicador;
	}

	public void setIndicador(String indicador) {
		this.indicador = indicador;
	}

	public String getTipo_atualizacao() {
		return tipo_atualizacao;
	}

	public void setTipo_atualizacao(String tipo_atualizacao) {
		this.tipo_atualizacao = tipo_atualizacao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getIdentificador_matriz_filial() {
		return identificador_matriz_filial;
	}

	public void setIdentificador_matriz_filial(String identificador_matriz_filial) {
		this.identificador_matriz_filial = identificador_matriz_filial;
	}

	public String getRazao_social() {
		return razao_social;
	}

	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}

	public String getNome_fantasia() {
		return nome_fantasia;
	}

	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}

	public String getSituacao_cadastral() {
		return situacao_cadastral;
	}

	public void setSituacao_cadastral(String situacao_cadastral) {
		this.situacao_cadastral = situacao_cadastral;
	}

	public String getData_situacao_cadastral() {
		return data_situacao_cadastral;
	}

	public void setData_situacao_cadastral(String data_situacao_cadastral) {
		this.data_situacao_cadastral = data_situacao_cadastral;
	}

	public String getMotivo_situacao_cadastral() {
		return motivo_situacao_cadastral;
	}

	public void setMotivo_situacao_cadastral(String motivo_situacao_cadastral) {
		this.motivo_situacao_cadastral = motivo_situacao_cadastral;
	}

	public String getNm_cidade_exterior() {
		return nm_cidade_exterior;
	}

	public void setNm_cidade_exterior(String nm_cidade_exterior) {
		this.nm_cidade_exterior = nm_cidade_exterior;
	}

	public String getCod_pais() {
		return cod_pais;
	}

	public void setCod_pais(String cod_pais) {
		this.cod_pais = cod_pais;
	}

	public String getNm_pais() {
		return nm_pais;
	}

	public void setNm_pais(String nm_pais) {
		this.nm_pais = nm_pais;
	}

	public String getCodigo_natureza_juridica() {
		return codigo_natureza_juridica;
	}

	public void setCodigo_natureza_juridica(String codigo_natureza_juridica) {
		this.codigo_natureza_juridica = codigo_natureza_juridica;
	}

	public String getData_inicio_atividade() {
		return data_inicio_atividade;
	}

	public void setData_inicio_atividade(String data_inicio_atividade) {
		this.data_inicio_atividade = data_inicio_atividade;
	}

	public String getCnae_fiscal() {
		return cnae_fiscal;
	}

	public void setCnae_fiscal(String cnae_fiscal) {
		this.cnae_fiscal = cnae_fiscal;
	}

	public String getDescricao_tipo_logradouro() {
		return descricao_tipo_logradouro;
	}

	public void setDescricao_tipo_logradouro(String descricao_tipo_logradouro) {
		this.descricao_tipo_logradouro = descricao_tipo_logradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCodigo_municipio() {
		return codigo_municipio;
	}

	public void setCodigo_municipio(String codigo_municipio) {
		this.codigo_municipio = codigo_municipio;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getDdd_telefone_1() {
		return ddd_telefone_1;
	}

	public void setDdd_telefone_1(String ddd_telefone_1) {
		this.ddd_telefone_1 = ddd_telefone_1;
	}

	public String getDdd_telefone_2() {
		return ddd_telefone_2;
	}

	public void setDdd_telefone_2(String ddd_telefone_2) {
		this.ddd_telefone_2 = ddd_telefone_2;
	}

	public String getDdd_fax() {
		return ddd_fax;
	}

	public void setDdd_fax(String ddd_fax) {
		this.ddd_fax = ddd_fax;
	}

	public String getCorreio_eletronico() {
		return correio_eletronico;
	}

	public void setCorreio_eletronico(String correio_eletronico) {
		this.correio_eletronico = correio_eletronico;
	}

	public String getQualificacao_responsavel() {
		return qualificacao_responsavel;
	}

	public void setQualificacao_responsavel(String qualificacao_responsavel) {
		this.qualificacao_responsavel = qualificacao_responsavel;
	}

	public String getCapital_social_empresa() {
		return capital_social_empresa;
	}

	public void setCapital_social_empresa(String capital_social_empresa) {
		this.capital_social_empresa = capital_social_empresa;
	}

	public String getPorte_empresa() {
		return porte_empresa;
	}

	public void setPorte_empresa(String porte_empresa) {
		this.porte_empresa = porte_empresa;
	}

	public String getOpcao_pelo_simples() {
		return opcao_pelo_simples;
	}

	public void setOpcao_pelo_simples(String opcao_pelo_simples) {
		this.opcao_pelo_simples = opcao_pelo_simples;
	}

	public String getData_opcao_pelo_simples() {
		return data_opcao_pelo_simples;
	}

	public void setData_opcao_pelo_simples(String data_opcao_pelo_simples) {
		this.data_opcao_pelo_simples = data_opcao_pelo_simples;
	}

	public String getData_exclusao_simples() {
		return data_exclusao_simples;
	}

	public void setData_exclusao_simples(String data_exclusao_simples) {
		this.data_exclusao_simples = data_exclusao_simples;
	}

	public String getOpcao_pelo_mei() {
		return opcao_pelo_mei;
	}

	public void setOpcao_pelo_mei(String opcao_pelo_mei) {
		this.opcao_pelo_mei = opcao_pelo_mei;
	}

	public String getSituacao_especial() {
		return situacao_especial;
	}

	public void setSituacao_especial(String situacao_especial) {
		this.situacao_especial = situacao_especial;
	}

	public String getData_situacao_especial() {
		return data_situacao_especial;
	}

	public void setData_situacao_especial(String data_situacao_especial) {
		this.data_situacao_especial = data_situacao_especial;
	}

	public String getFiller() {
		return filler;
	}

	public void setFiller(String filler) {
		this.filler = filler;
	}

	public String getFim_registro() {
		return fim_registro;
	}

	public void setFim_registro(String fim_registro) {
		this.fim_registro = fim_registro;
	}

	public String getMigrado() {
		return migrado;
	}

	public void setMigrado(String migrado) {
		this.migrado = migrado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		CnpjDadosCadastraisPj other = (CnpjDadosCadastraisPj) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
