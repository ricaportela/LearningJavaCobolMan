package br.com.locadora.model;

import java.util.ArrayList;
import java.util.List;

public class Ator {
	
	private Long id;
	private String nome;
	
	private List<TituloAtor> tituloAtors = new ArrayList<TituloAtor>();
	
	public Ator() {}
	
	public Ator(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}



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
