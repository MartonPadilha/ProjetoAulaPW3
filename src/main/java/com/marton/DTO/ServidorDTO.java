package com.marton.DTO;

import java.io.Serializable;

import com.marton.entity.CursoEntity;
import com.marton.entity.ServidorEntity;

public class ServidorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome, email;
	
	public ServidorDTO() {
		super();
	}

	public ServidorDTO(ServidorEntity obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
