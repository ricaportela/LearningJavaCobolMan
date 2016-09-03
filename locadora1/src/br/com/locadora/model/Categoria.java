package br.com.locadora.model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	private Long id;
	private String nome;
	
	private List<Titulo> titulos = new ArrayList<Titulo>();
	
	public List<Titulo> getTitulos() {
		return titulos;
	}
	public void setTitulos(List<Titulo> titulos) {
		this.titulos = titulos;
	}
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
	
	

}
