package com.marton.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marton.DTO.CursoDTO;
import com.marton.entity.CursoEntity;
import com.marton.service.CursoService;

@RestController
@RequestMapping(value="/cursos")
public class CursoResource {
	
	@Autowired
	CursoService service;
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<CursoDTO> listar() {
		List<CursoEntity> listaEntity = service.buscar();
		
		List<CursoDTO> listaDTO = listaEntity.stream().map(obj -> new CursoDTO(obj)).collect(Collectors.toList());
		return listaDTO;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<CursoEntity> buscar(@PathVariable Integer id){
		CursoEntity objeto = service.buscar(id);
		return ResponseEntity.ok(objeto);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody CursoEntity obj){
		obj = service.salvar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	
	
}
