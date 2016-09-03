package br.com.locadora.model;

import java.util.ArrayList;
import java.util.List;

public class Fita {
	private Long id;
	
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
	
	
}
