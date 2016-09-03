package br.com.locadora.model;

import java.util.ArrayList;
import java.util.List;

public class Bairro {
	private Long id;
	private String nome;
	
	private Cidade cidade;
	
	private List<Socio> socios = new ArrayList<Socio>();
	private List<Distribuidor> distribuidores = new ArrayList<Distribuidor>();
	
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Socio> getSocios() {
		return socios;
	}

	public void setSocios(List<Socio> socios) {
		this.socios = socios;
	}

	public List<Distribuidor> getDistribuidores() {
		return distribuidores;
	}

	public void setDistribuidores(List<Distribuidor> distribuidores) {
		this.distribuidores = distribuidores;
	}
	

	
}
