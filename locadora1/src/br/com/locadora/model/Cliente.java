package br.com.locadora.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente {
	private Long id;
	private Socio socio;
	private Long inscricao; 
	private String nome;
	private Date nascimento;
	private String sexo;
	
	private List<Locacao> locacaos = new ArrayList<Locacao>();
	
	private List<Reserva> reservas = new ArrayList<Reserva>();
	
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getInscricao() {
		return inscricao;
	}
	public void setInscricao(Long inscricao) {
		this.inscricao = inscricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Socio getSocio() {
		return socio;
	}
	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	public List<Locacao> getLocacaos() {
		return locacaos;
	}
	public void setLocacaos(List<Locacao> locacaos) {
		this.locacaos = locacaos;
	}
	public List<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	
	
}
