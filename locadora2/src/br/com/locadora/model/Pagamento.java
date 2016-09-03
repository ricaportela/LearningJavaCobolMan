package br.com.locadora.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Pagamento {
	private Long id;
	private Timestamp data;
	private BigDecimal valor;
	
	private List<Cheque> cheques =  new ArrayList<Cheque>();
	
	private List<Locacao> locacaos = new ArrayList<Locacao>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Timestamp getData() {
		return data;
	}
	public void setData(Timestamp data) {
		this.data = data;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public List<Cheque> getCheques() {
		return cheques;
	}
	public void setCheques(List<Cheque> cheques) {
		this.cheques = cheques;
	}
	public List<Locacao> getLocacaos() {
		return locacaos;
	}
	public void setLocacaos(List<Locacao> locacaos) {
		this.locacaos = locacaos;
	}
	
	
	

}
