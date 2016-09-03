package br.com.locadora.bo;


import java.util.List;

import br.com.locadora.data.AtorData;
import br.com.locadora.model.Ator;


public class AtorBO {

	private AtorData atorData = new AtorData();
	
	public List<Ator> listarTodos() throws Exception{
		return atorData.listarTodos();
	}
	
	public Ator buscar(Long id) throws Exception{
		return atorData.buscar(id);
	}	
	
	public Ator buscarPorTitulo(Long id) throws Exception{
		return atorData.buscarPorTitulo(id);
	}
	
	
}
