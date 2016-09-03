package br.com.locadora.model;

import java.util.ArrayList;
import java.util.List;

public class Diretor {
	private Long id;
	private String nome;
	
	private List<TituloDiretor> tituloDiretors = new ArrayList<TituloDiretor>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<TituloDiretor> getTituloDiretors() {
		return tituloDiretors;
	}
	public void setTituloDiretors(List<TituloDiretor> tituloDiretors) {
		this.tituloDiretors = tituloDiretors;
	}
	
	
}

