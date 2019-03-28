package com.marton.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.marton.dao.ServidorDAO;
import com.marton.entity.CursoEntity;
import com.marton.entity.ServidorEntity;
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
	
	public ServidorEntity atualizar(ServidorEntity obj) {
		ServidorEntity servidor_banco = buscar(obj.getId());
		if (obj.getNome() == null) {
			obj.setNome(servidor_banco.getNome());
		}
		if (obj.getEmail() == null) {
			obj.setEmail(servidor_banco.getEmail());
		}
		if (obj.getSenha() == null) {
			obj.setSenha(servidor_banco.getSenha());
		}
		
		return dao.save(obj);
		
	}
	
	public Page<ServidorEntity> buscarPorPagina(Integer pagina, Integer qtdLinhas, String orderBy, String dir){
		PageRequest pageRequest = PageRequest.of(pagina, qtdLinhas, Direction.valueOf(dir), orderBy);
		
		return dao.findAll(pageRequest);
	}
	
}
