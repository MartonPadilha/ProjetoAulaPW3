package com.marton.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marton.entity.AlunoEntity;
import com.marton.entity.CursoEntity;

@Repository
public interface AlunoDAO extends JpaRepository<AlunoEntity, Integer>{
	
}
