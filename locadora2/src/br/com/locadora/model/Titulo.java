package br.com.locadora.model;

import java.util.ArrayList;
import java.util.List;

public class Titulo {
	
	private Long id;
	
	private List<Reserva> reservas = new ArrayList<Reserva>();
	
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
