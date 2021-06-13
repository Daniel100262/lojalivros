package com.daniel.lojalivros.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.daniel.lojalivros.domain.Categoria;

public class CategoriaDTO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Nome obrigatorio!") //restricao de not null no nome com mensagem
	@Length(min = 3, max = 100, message = "O campo nome deve ter entre 3 e 100 caracteres")
	private String nome;
	
	@NotEmpty(message = "Descricao obrigatoria!") //restricao de not null no nome com mensagem
	@Length(min = 3, max = 200, message = "O campo descricao deve ter entre 3 e 200 caracteres") //restricao de not null na descricao com mensagem
	private String descricao;
	
	public CategoriaDTO(Categoria obj) {
		
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	
	}

	public CategoriaDTO(Integer id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
