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

import com.marton.entity.CursoEntity;
import com.marton.entity.TurmaEntity;
import com.marton.service.CursoService;
import com.marton.service.TurmaService;

@RestController
@RequestMapping(value="/turmas")
public class TurmaResource {
	
	@Autowired
	TurmaService service;
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<TurmaEntity> listar() {

		List<TurmaEntity> lista = service.bucar();
		return lista;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<TurmaEntity> buscar(@PathVariable Integer id){
		TurmaEntity objeto = service.buscar(id);
		if (objeto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} 
		return ResponseEntity.ok(objeto);
	}
	
	
	
}
