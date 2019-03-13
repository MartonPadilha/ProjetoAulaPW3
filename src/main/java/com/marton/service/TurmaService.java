package com.marton.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marton.dao.CursoDAO;
import com.marton.dao.TurmaDAO;
import com.marton.entity.CursoEntity;
import com.marton.entity.TurmaEntity;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaDAO dao;
	
	public List<TurmaEntity> bucar() {
		return dao.findAll();
	}
	
	public TurmaEntity buscar(Integer id) {
		Optional<TurmaEntity> objeto = dao.findById(id);
		return objeto.orElse(null);
	}
	
}
