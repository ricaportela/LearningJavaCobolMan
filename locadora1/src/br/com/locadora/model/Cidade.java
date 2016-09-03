package br.com.locadora.model;

import java.util.ArrayList;
import java.util.List;

public class Cidade {
	private Long id;
	
	private Estado estado;
	
	private String nome;
	
	private List<Bairro> bairros = new ArrayList<Bairro>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}
	

	
	
	
}
