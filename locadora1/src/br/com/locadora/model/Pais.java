package br.com.locadora.model;

import java.util.ArrayList;
import java.util.List;

public class Pais {
	
	private Long id;
	private String nome;
    private String sigla;
    
    private List<TituloNacionalidade> tituloNacionalidades = new ArrayList<TituloNacionalidade>();
    
    private List<Estado> estados = new ArrayList<Estado>();
        
	public List<Estado> getEstados() {
		return estados;
	}
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	public List<TituloNacionalidade> getTituloNacionalidades() {
		return tituloNacionalidades;
	}
	public void setTituloNacionalidades(
			List<TituloNacionalidade> tituloNacionalidades) {
		this.tituloNacionalidades = tituloNacionalidades;
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
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
    
    

}
