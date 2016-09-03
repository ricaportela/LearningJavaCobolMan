package br.com.locadora.model;

import java.util.ArrayList;
import java.util.List;

public class Distribuidor {
	private Long id;
	private String razaoSocial;
	private Long cnpj;
	private String pessoaContato;
	private String rua;
	private String logradouro;
	private String complemento;
	private Integer cep;
	
	private Bairro Bairro; 
	
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
	public Bairro getBairro() {
		return Bairro;
	}
	public void setBairro(Bairro bairro) {
		Bairro = bairro;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public Long getCnpj() {
		return cnpj;
	}
	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	public String getPessoaContato() {
		return pessoaContato;
	}
	public void setPessoaContato(String pessoaContato) {
		this.pessoaContato = pessoaContato;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public Integer getCep() {
		return cep;
	}
	public void setCep(Integer cep) {
		this.cep = cep;
	}
	

}
