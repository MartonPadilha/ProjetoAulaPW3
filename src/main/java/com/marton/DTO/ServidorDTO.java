package com.marton.DTO;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.marton.entity.CursoEntity;
import com.marton.entity.ServidorEntity;

public class ServidorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento Obrigatório!")
	@Length(min=1, max=100, message="O nome deve conter entre 1 e 100 caracteres!")
	private String nome; 
	private String email;

	
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
