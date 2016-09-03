package br.com.locadora.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	private Long id;
	
	private List<Agencia>  agencias = new ArrayList<Agencia>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Agencia> getAgencias() {
		return agencias;
	}

	public void setAgencias(List<Agencia> agencias) {
		this.agencias = agencias;
	}
	
	

}
