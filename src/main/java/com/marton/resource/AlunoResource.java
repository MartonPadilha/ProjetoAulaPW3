package com.marton.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marton.entity.AlunoEntity;
import com.marton.entity.CursoEntity;
import com.marton.service.AlunoService;
import com.marton.service.CursoService;

@RestController
@RequestMapping(value="/alunos")
public class AlunoResource {
	
	@Autowired
	AlunoService service;
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<AlunoEntity> listar() {

		List<AlunoEntity> lista = service.bucar();
		return lista;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<AlunoEntity> buscar(@PathVariable Integer id){
		AlunoEntity objeto = service.buscar(id);
		if (objeto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} 
		return ResponseEntity.ok(objeto);
	}
	
	
	
}
