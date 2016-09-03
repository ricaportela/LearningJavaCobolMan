package br.com.locadora.bo;



import java.util.List;

import br.com.locadora.data.TituloData;
import br.com.locadora.model.Titulo;

public class TituloBO {
	
	private TituloData tituloData = new TituloData();
	
	private ReservaBO reservaBO = new ReservaBO();
	
	public List<Titulo> listarTodos() throws Exception{
		return tituloData.listarTodos();
	}
	
	public Titulo buscar(Long id) throws Exception{
		return tituloData.buscar(id);
	}
	
	
	
	
}
