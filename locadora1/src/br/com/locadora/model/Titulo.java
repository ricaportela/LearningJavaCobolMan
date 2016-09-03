package br.com.locadora.model;

import java.util.ArrayList;
import java.util.List;

public class Titulo {
	
	private Long id;
	private String nome;
	private String nomeOriginal;
	private String sinopse;
	private Integer ano;
		
	private Classe classe;
	private Categoria categoria;
	private Distribuidor distribuidor;
	
	private List<Reserva> reservas = new ArrayList<Reserva>();
	private List<Fita> fitas = new ArrayList<Fita>();
	private List<TituloAtor> tituloAtors = new ArrayList<TituloAtor>();
	private List<TituloNacionalidade> tituloNacionalidades = new ArrayList<TituloNacionalidade>();
	private List<TituloDiretor> tituloDiretors = new ArrayList<TituloDiretor>();
	
		
	public List<Fita> getFitas() {
		return fitas;
	}

	public void setFitas(List<Fita> fitas) {
		this.fitas = fitas;
	}

	public List<TituloAtor> getTituloAtors() {
		return tituloAtors;
	}

	public void setTituloAtors(List<TituloAtor> tituloAtors) {
		this.tituloAtors = tituloAtors;
	}

	public List<TituloNacionalidade> getTituloNacionalidades() {
		return tituloNacionalidades;
	}

	public void setTituloNacionalidades(
			List<TituloNacionalidade> tituloNacionalidades) {
		this.tituloNacionalidades = tituloNacionalidades;
	}

	public List<TituloDiretor> getTituloDiretors() {
		return tituloDiretors;
	}

	public void setTituloDiretors(List<TituloDiretor> tituloDiretors) {
		this.tituloDiretors = tituloDiretors;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Distribuidor getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(Distribuidor distribuidor) {
		this.distribuidor = distribuidor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeOriginal() {
		return nomeOriginal;
	}

	public void setNomeOriginal(String nomeOriginal) {
		this.nomeOriginal = nomeOriginal;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	

}
