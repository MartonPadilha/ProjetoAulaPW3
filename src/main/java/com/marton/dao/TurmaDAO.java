package com.marton.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marton.entity.TurmaEntity;

@Repository
public interface TurmaDAO extends JpaRepository<TurmaEntity, Integer>{
	
}
