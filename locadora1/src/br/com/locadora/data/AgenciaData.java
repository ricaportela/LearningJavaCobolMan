package br.com.locadora.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.model.Agencia;
import br.com.locadora.model.Banco;

public class AgenciaData extends GenericoData<Agencia> {

	private final static String LISTAR_TODOS = "SELECT id, nome FROM agencia";
	private final static String BUSCAR_ID = "SELECT id, nome FROM agencia WHERE id=?";
	private final static String INCLUIR = "INSERT INTO agencia (id, nome) VALUES (?,?)";
	private final static String ATUALIZAR = "UPDATE agencia SET nome=? WHERE id=?";
	private final static String DELETAR = "DELETE FROM agencia WHERE id=?";

	public List<Agencia> listarTodos() throws Exception {
		List<Agencia> agencias = new ArrayList<Agencia>();

		ResultSet rs = buscar(LISTAR_TODOS, null);

		while (rs.next()) {
			Agencia agencia = popular(rs);
			
			agencias.add(agencia);
		}
		rs.close();
		closeConnection();

		return agencias;
	}


	
	public Agencia buscar(Long id) throws Exception {
		Agencia agencia = null;
		
		List<Object> parametros = new ArrayList<Object>();
		parametros.add(id);
		
		ResultSet rs = buscar(BUSCAR_ID, parametros);

		if (rs.next()) {
			agencia = popular(rs);
		}

		rs.close();
		closeConnection();

		return agencia;
	}
	
	public boolean incluir(Agencia agencia) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(agencia.getId());
		objects.add(agencia.getBanco().getId());

		boolean retorno = incluir(INCLUIR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	public boolean atualizar(Agencia agencia) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(agencia.getBanco().getId());
		objects.add(agencia.getId());
		
		boolean retorno = atualizar(ATUALIZAR, objects);

		commit();
		closeConnection();

		return retorno;
	}
	
	public boolean deletar(Agencia agencia) throws Exception {

		List<Object> objects = new ArrayList<>();
		
		objects.add(agencia.getId());

		boolean retorno = deletar(DELETAR, objects);

		commit();
		closeConnection();

		return retorno;
	}
	
	///////////////////////
	//PRIVATE
	//////////////////////


	private Agencia popular(ResultSet rs) throws SQLException {
		Agencia agencia = new Agencia();
		agencia.setId(rs.getLong("id"));
		
		Long idBanco = rs.getLong("idBanco");
		
		if(idBanco != null){
			Banco banco = new Banco();
			banco.setId(idBanco);
			agencia.setBanco(banco);
		}
		
		return agencia;
	}
	
	
}
