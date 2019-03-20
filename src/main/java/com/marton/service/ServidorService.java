package com.marton.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marton.dao.ServidorDAO;
import com.marton.entity.ServidorEntity;
import com.marton.exceptions.ObjNaoEncontradoException;

@Service
public class ServidorService {
	
	@Autowired
	private ServidorDAO dao;
	
	public List<ServidorEntity> buscar() {
		return dao.findAll();
	}
	
	public ServidorEntity buscar(Integer id) {
		Optional<ServidorEntity> curso = dao.findById(id);
//		return curso.orElse(null);
		return curso.orElseThrow(()-> new ObjNaoEncontradoException("Curso não encontrado!"));
	}
	
	public ServidorEntity salvar(ServidorEntity obj) {
		obj.setId(null);
		return dao.save(obj);
	}
	
}
