package com.vixsystem.cnpj.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vixsystem.cnpj.domains.CnpjDadosCadastraisPj;
import com.vixsystem.cnpj.projections.CnpjDadosCadastraisPjProjection;
@Repository
public interface CnpjDadosCadastraisPjRepository extends JpaRepository<CnpjDadosCadastraisPj, Integer>{
	@Transactional(readOnly = true)
	@Query(value ="select " + 
			"	id " +
			" from cnpj_dados_cadastrais_pj " +
			" where migrado = 'S' and cnae_fiscal in ('4771701','4771702','4771703')" + 
			" limit :limit "
			,nativeQuery  = true)
	List<CnpjDadosCadastraisPjProjection> updateMigrados(@Param("limit") Integer limit);
}
