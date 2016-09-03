package br.com.locadora.bo;



import java.util.List;

import br.com.locadora.data.ReservaData;
import br.com.locadora.model.Reserva;

public class ReservaBO {
	
	private ReservaData reservaData = new ReservaData();
	
	public List<Reserva> listarTodos() throws Exception{
		return reservaData.listarTodos();
	}
	
	public Reserva buscar(Long id) throws Exception{
		return reservaData.buscar(id);
	}	
	
	public Reserva buscarPorTitulo(Long idTitulo) throws Exception{
		return reservaData.buscarPorTitulo(idTitulo);
	}
	
	
}
