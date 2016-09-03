package br.com.locadora.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Locacao {
	private Long id;
	
	private Pagamento pagamentoLocacao;
	private Pagamento pagamentoDevolucao;
	
	
	private Cliente cliente;
	
	private Fita fita;
	

	private Timestamp dataLocacao;
	private Timestamp dataDevolucaoPrevista;
	private Timestamp dataDevolucaoEfetiva;
	private BigDecimal valorCobrado;
	private String estado;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	

	
	public Pagamento getPagamentoLocacao() {
		return pagamentoLocacao;
	}

	public void setPagamentoLocacao(Pagamento pagamentoLocacao) {
		this.pagamentoLocacao = pagamentoLocacao;
	}

	public Pagamento getPagamentoDevolucao() {
		return pagamentoDevolucao;
	}

	public void setPagamentoDevolucao(Pagamento pagamentoDevolucao) {
		this.pagamentoDevolucao = pagamentoDevolucao;
	}

	public Timestamp getDataLocacao() {
		return dataLocacao;
	}
	
	public void setDataLocacao(Timestamp dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	
	public Timestamp getDataDevolucaoPrevista() {
		return dataDevolucaoPrevista;
	}
	
	public void setDataDevolucaoPrevista(Timestamp dataDevolucaoPrevista) {
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
	}
	
	public Timestamp getDataDevolucaoEfetiva() {
		return dataDevolucaoEfetiva;
	}
	
	public void setDataDevolucaoEfetiva(Timestamp dataDevolucaoEfetiva) {
		this.dataDevolucaoEfetiva = dataDevolucaoEfetiva;
	}
	
	public BigDecimal getValorCobrado() {
		return valorCobrado;
	}
	
	public void setValorCobrado(BigDecimal valorCobrado) {
		this.valorCobrado = valorCobrado;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Fita getFita() {
		return fita;
	}

	public void setFita(Fita fita) {
		this.fita = fita;
	}
	
	
	

}
