package com.marton.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marton.dao.AlunoDAO;
import com.marton.dao.CursoDAO;
import com.marton.entity.AlunoEntity;
import com.marton.entity.CursoEntity;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoDAO dao;
	
	public List<AlunoEntity> bucar() {
		return dao.findAll();
	}
	
	public AlunoEntity buscar(Integer id) {
		Optional<AlunoEntity> objeto = dao.findById(id);
		return objeto.orElse(null);
	}
	
}
