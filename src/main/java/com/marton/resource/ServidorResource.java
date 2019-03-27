package com.marton.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marton.DTO.ServidorDTO;
import com.marton.entity.ServidorEntity;
import com.marton.service.ServidorService;

@RestController
@RequestMapping(value="/servidores")
public class ServidorResource {
	
	@Autowired
	ServidorService service;
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<ServidorDTO> listar() {
		List<ServidorEntity> listaEntity = service.buscar();
		
		List<ServidorDTO> listaDTO = listaEntity.stream().map(obj -> new ServidorDTO(obj)).collect(Collectors.toList());
		return listaDTO;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<ServidorEntity> buscar(@PathVariable Integer id){
		ServidorEntity objeto = service.buscar(id);
		return ResponseEntity.ok(objeto);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody ServidorDTO objDTO){
		
		ServidorEntity obj = new ServidorEntity(null, objDTO.getNome(), objDTO.getEmail(), null);
	
		obj = service.salvar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	
	
}
