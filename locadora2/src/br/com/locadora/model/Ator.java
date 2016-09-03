package br.com.locadora.model;

import java.util.ArrayList;
import java.util.List;

public class Ator {
	
	private Long id;
	
	private List<TituloAtor> tituloAtors = new ArrayList<TituloAtor>();
	
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<TituloAtor> getTituloAtors() {
		return tituloAtors;
	}

	public void setTituloAtors(List<TituloAtor> tituloAtors) {
		this.tituloAtors = tituloAtors;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
