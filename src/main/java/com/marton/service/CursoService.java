package com.marton.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marton.dao.CursoDAO;
import com.marton.entity.CursoEntity;
import com.marton.exceptions.ObjNaoEncontradoException;

@Service
public class CursoService {
	
	@Autowired
	private CursoDAO dao;
	
	public List<CursoEntity> buscar() {
		return dao.findAll();
	}
	
	public CursoEntity buscar(Integer id) {
		Optional<CursoEntity> curso = dao.findById(id);
//		return curso.orElse(null);
		return curso.orElseThrow(()-> new ObjNaoEncontradoException("Curso não encontrado!"));
	}
	
	public CursoEntity salvar(CursoEntity obj) {
		obj.setId(null);
		return dao.save(obj);
	}
	
}
