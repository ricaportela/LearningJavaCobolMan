package br.com.locadora.model;

import java.util.ArrayList;
import java.util.List;

public class Agencia {
	private Long id;
	
	private Banco banco;
	
	private List<Cheque> cheques = new ArrayList<Cheque>();
 
	
	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Cheque> getCheques() {
		return cheques;
	}

	public void setCheques(List<Cheque> cheques) {
		this.cheques = cheques;
	}
	
	
	

}
