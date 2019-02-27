package com.marton.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marton.entity.CursoEntity;
import com.marton.service.CursoService;

@RestController
@RequestMapping(value="/cursos")
public class CursoResource {
	
	@Autowired
	CursoService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<CursoEntity> listar() {
		CursoEntity curso1 = new CursoEntity(1, "TSI", "Superior", "Noturno");
		CursoEntity curso2 = new CursoEntity(2, "Biologia", "Superior", "Diurno");
				
		List<CursoEntity> listaCursos = new ArrayList<>();
		
		listaCursos.add(curso1);
		listaCursos.add(curso2);
		
		return listaCursos;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<CursoEntity> buscar(@PathVariable Integer id){
		CursoEntity curso = service.buscar(id);
		return ResponseEntity.ok(curso);
	}
	
	
	
}
