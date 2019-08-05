package com.vixsystem.cnpj.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vixsystem.cnpj.domains.VSDadosCnpj;
import com.vixsystem.cnpj.projections.VCDadosCnpjProjection;
@Repository
public interface VSDadosCnpjRepository extends JpaRepository<VSDadosCnpj, Integer>{
	
	/**
	 * @autor Ruan Nunes
	 * @param limit
	 * CNAE DE FARMACIA
	 * 4771-7/01 	Comércio varejista de produtos farmacêuticos, sem manipulação de fórmulas
	 * 4771-7/02	Comércio varejista de produtos farmacêuticos, com manipulação de fórmulas
	 * 4771-7/03	Comércio varejista de produtos farmacêuticos homeopáticos
	 * 
	 */
	@Transactional(readOnly = true)
	@Query(value ="select " + 
			"	razao_social," + 
			"	nome_fantasia," + 
			"	uf," + 
			"	municipio," + 
			"	bairro," +
			"	cep," +
			"	cnae_fiscal," + 
			"	cnpj, " +
			"	id, " +
			"	migrado " +
			" from cnpj_dados_cadastrais_pj " +
			" where migrado isnull and uf = :uf " +
//			+ "and cnae_fiscal in ('4771701','4771702','4771703')" + 
			" limit :limit "
			,nativeQuery  = true)
	List<VCDadosCnpjProjection> selectMigration(@Param("limit") Integer limit, @Param("uf") String uf);
	
	@Transactional(readOnly = true)
	VSDadosCnpj findByCnpj(String cnpj);
	
}
