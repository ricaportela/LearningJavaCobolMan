package br.com.locadora.model;

import java.util.ArrayList;
import java.util.List;

public class Bairro {
	private Long id;
	
	private List<Socio> socios = new ArrayList<Socio>();
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Socio> getSocios() {
		return socios;
	}

	public void setSocios(List<Socio> socios) {
		this.socios = socios;
	}
	

}
