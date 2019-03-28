package com.marton.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marton.DTO.ServidorDTO;
import com.marton.DTO.ServidorDTO;
import com.marton.entity.ServidorEntity;
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
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody ServidorEntity obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.atualizar(obj);
		return ResponseEntity.noContent().build();//retorna 204 no servidor
	}
	
	
	@RequestMapping(value = "/paginacao", method = RequestMethod.GET)
	public ResponseEntity<Page<ServidorDTO>> listarPaginas(
			@RequestParam(value = "pagina", defaultValue = "0") Integer pagina, 
			@RequestParam(value = "qtd", defaultValue = "15") Integer qtdLinhas, 
			@RequestParam(value = "ordem", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "dir", defaultValue = "DESC") String dir){
		
		Page<ServidorEntity> listaCursos = 
				service.buscarPorPagina(pagina, qtdLinhas, orderBy, dir);
		
		Page<ServidorDTO> listaDTO = listaCursos.map(obj -> new ServidorDTO(obj));
		
		return ResponseEntity.ok().body(listaDTO);
	}
	
	
	
}
