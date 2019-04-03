package com.marton.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.marton.entity.CursoEntity;

@Repository
public interface CursoDAO extends JpaRepository<CursoEntity, Integer>{
	
	@Query("select curso from CursoEntity curso where curso.nome LIKE %:nome%")
	Page<CursoEntity> search(@Param("nome") String nome, Pageable pageable);
}
