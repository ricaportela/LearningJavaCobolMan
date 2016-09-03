package br.com.locadora.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.model.Cliente;
import br.com.locadora.model.Reserva;
import br.com.locadora.model.Titulo;

public class ReservaData extends GenericoData<Reserva> {

	private final static String LISTAR_TODOS = "SELECT id, dataHora, estado, tituloId, clienteId FROM reserva";
	private final static String BUSCAR_ID = "SELECT id, dataHora, estado, tituloId, clienteId FROM reserva WHERE id=?";
	private final static String BUSCAR_TITULO = "SELECT id, dataHora, estado, tituloId, clienteId FROM reserva WHERE tituloId=?";
	private final static String INCLUIR = "INSERT INTO reserva (dataHora, estado, tituloId, clienteId) VALUES (?,?,?,?)";
	private final static String ATUALIZAR = "UPDATE reserva SET  dataHora=?, estado=?, tituloId=?, clienteId=? WHERE id=?";
	private final static String DELETAR = "DELETE FROM reserva WHERE id=?";
	
	public List<Reserva> listarTodos() throws Exception {
		List<Reserva> reservas = new ArrayList<Reserva>();

		ResultSet rs = buscar(LISTAR_TODOS, null); 

		while (rs.next()) {
			Reserva reserva = popular(rs);
			reservas.add(reserva);
		}
		rs.close();
		closeConnection();

		return reservas;
	}
	
	public Reserva buscar(Long id) throws Exception {
		Reserva reserva = null;
		
		List<Object> parametros = new ArrayList<Object>();
		parametros.add(id);
		
		ResultSet rs = buscar(BUSCAR_ID, parametros);

		if (rs.next()) {
			reserva = popular(rs);
		}

		rs.close();
		closeConnection();

		return reserva;
	}
	
	
	public Reserva buscarPorTitulo(Long idTitulo) throws Exception {
		Reserva reserva = null;
		
		List<Object> parametros = new ArrayList<Object>();
		parametros.add(idTitulo);
		
		ResultSet rs = buscar(BUSCAR_TITULO, parametros);

		if (rs.next()) {
			reserva = popular(rs);
		}

		rs.close();
		closeConnection();

		return reserva;
	}
	
	public boolean incluir(Reserva reserva) throws Exception {
		List<Object> objects = parametros(reserva);

		boolean retorno = incluir(INCLUIR, objects);

		commit();
		closeConnection();

		return retorno;
	}


	public boolean atualizar(Reserva reserva) throws Exception {
		List<Object> objects = parametros(reserva);
		objects.add(reserva.getId());
		
		boolean retorno = atualizar(ATUALIZAR, objects);

		commit();
		closeConnection();

		return retorno;
	}
	
	public boolean deletar(Reserva reserva) throws Exception {

		List<Object> objects = new ArrayList<>();
		
		objects.add(reserva.getId());

		boolean retorno = deletar(DELETAR, objects);

		commit();
		closeConnection();

		return retorno;
	}
	
	///////////////////////
	//PRIVATE
	//////////////////////
	
	private List<Object> parametros(Reserva reserva) {

		List<Object> objects = new ArrayList<Object>();
		
		objects.add(reserva.getDataHora());
		objects.add(reserva.getEstado());
		
		return objects;
	}

	private Reserva popular(ResultSet rs) throws SQLException {
		Reserva reserva = new Reserva();
		reserva.setId(rs.getLong("id"));
		reserva.setDataHora(rs.getDate("dataHora"));
		reserva.setEstado(rs.getString("estado"));
		
		Long idTitulo = rs.getLong("idTitulo"); 
		
		if(idTitulo != null){
			Titulo titulo = new Titulo();
			titulo.setId(idTitulo);
			reserva.setTitulo(titulo);
		}
		
		Long idCliente= rs.getLong("idCliente");
		
		
		if(idCliente != null){
			Cliente cliente = new Cliente();
			cliente.setId(idCliente);
			reserva.setCliente(cliente);
		}
		
		return reserva;
	}
}
