package br.com.locadora.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Fita {
	private Long id;
	
	private Titulo titulo;
	
	private Long serie;
	
	private Timestamp aquisicao;
	
	private String estado;
	
	private List<Locacao> locacaos = new ArrayList<Locacao>();

	public List<Locacao> getLocacaos() {
		return locacaos;
	}

	public void setLocacaos(List<Locacao> locacaos) {
		this.locacaos = locacaos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	public Long getSerie() {
		return serie;
	}

	public void setSerie(Long serie) {
		this.serie = serie;
	}

	public Timestamp getAquisicao() {
		return aquisicao;
	}

	public void setAquisicao(Timestamp aquisicao) {
		this.aquisicao = aquisicao;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
