package com.vixsystem.cnpj.domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.vixsystem.cnpj.domains.enums.Perfil;
import com.vixsystem.cnpj.domains.enums.TipoCliente;
@Entity
@Table(name = "vs_cliente")
public class VSCliente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true, length = 100, precision = 100)
	@NotNull
	private String email;
	
	@NotNull
	private String senha;
	
	@Column(unique = true, length = 100, precision = 100)
	@NotNull
	private String nome;
	
	@Column(unique = true, length = 100, precision = 100)
	private String nomeEmpresa;
	
	//mapeia o TipoCliente como codigo no banco de dados
	private Integer tipo;
	
	//faz com que sempre que carregar um cliente vai carregar o perfil junto
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "vs_perfis")
	private Set<Integer> perfis = new HashSet<>();

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<VSEndereco> enderecos = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name = "vs_telefone")
	private Set<String> telefones = new HashSet<>();
	
	@Column(unique = true, length = 45, precision = 45)
	@NotNull
	private String CnpjOuCpf;
	
	@NotNull
	private Date dataCriacao;
	
	@NotNull
	private String ipCriacao;
	
	private Integer statusAtivo;
	
	@NotNull
	private Date dataVencimento;
	
	private String token;
	
	public VSCliente() {
		addPerfil(Perfil.CLIENTE);
	}

	public VSCliente(String email, String senha,TipoCliente tipo) {
		super();
		this.email = email;
		this.senha = senha;
		this.tipo = (tipo == null ) ? null : tipo.getCod();
		addPerfil(Perfil.CLIENTE);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String nome) {
		this.email = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Set<Perfil> getPerfis(){
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getCnpjOuCpf() {
		return CnpjOuCpf;
	}

	public void setCnpjOuCpf(String cnpjOuCpf) {
		CnpjOuCpf = cnpjOuCpf;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getIpCriacao() {
		return ipCriacao;
	}

	public void setIpCriacao(String ipCriacao) {
		this.ipCriacao = ipCriacao;
	}

	public Integer getStatusAtivo() {
		return statusAtivo;
	}

	public void setStatusAtivo(Integer statusAtivo) {
		this.statusAtivo = statusAtivo;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setPerfis(Set<Integer> perfis) {
		this.perfis = perfis;
	}
	//Utiliza metodo customizado para retornar o TipoCliente a partir do codigo
	public TipoCliente getTipo() {
		return TipoCliente.toEnum(tipo);
	}
	
	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getCod();
	}
	
	public List<VSEndereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<VSEndereco> enderecos) {
		this.enderecos = enderecos;
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
		VSCliente other = (VSCliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
