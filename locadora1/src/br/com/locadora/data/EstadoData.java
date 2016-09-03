package br.com.locadora.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.model.Estado;

public class EstadoData extends GenericoData<Estado> {
	private final static String LISTAR_TODOS = "SELECT id, nome, sigla, pais FROM estado";
	private final static String BUSCAR_ID = "SELECT id FROM estado WHERE id = ?";
	private final static String INCLUIR = "INSERT INTO estado (id, nome, sigla, pais ) VALUES (?,?,?,?)";
	private final static String ATUALIZAR = "UPDATE estado SET agencia=? WHERE id=?";
	private final static String DELETAR = "DELETE FROM estado WHERE id=?";


	
	/*
	 * Listar Descrição: Listar os objetos numa Lista, utilizando o List.util do
	 * Java
	 */
	public List<Estado> listarTodos() throws Exception {
		List<Estado> estados = new ArrayList<Estado>();

		ResultSet rs = buscar(LISTAR_TODOS, null);
		while (rs.next()) {
			Estado estado = popular(rs);
			estados.add(estado);
		}

		rs.close();
		closeConnection();

		return estados;

	}

	/*
	 * Buscar
	 */

	public Estado buscar(Long id) throws Exception {

		Estado estado = null;

		List<Object> parametros = new ArrayList<Object>();
		parametros.add(id);

		ResultSet rs = buscar(BUSCAR_ID, parametros);

		if (rs.next()) {
			estado = popular(rs);
		}

		rs.close();
		closeConnection();

		return estado;

	}

	/*
	 * Incluir
	 */
	public boolean incluir(Estado estado) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(estado.getId());

		boolean retorno = incluir(INCLUIR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Atualizar	
	 */
	public boolean atualizar(Estado estado) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(estado.getId());

		boolean retorno = atualizar(ATUALIZAR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Deletar
	 */
	public boolean deletar(Estado estado) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(estado.getId());

		boolean retorno = deletar(DELETAR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Popular
	 */

	private Estado popular(ResultSet rs) throws SQLException {
		Estado estado = new Estado();
		estado.setId(rs.getLong("id"));
		estado.setNome(rs.getString("nome"));
		estado.setSigla(rs.getString("sigla"));
//		estado.setPais(rs.getString("pais"));
		
//		private Long id;
//		private String nome;
//		private String sigla;
//		private Pais pais;
		
		return estado;
	}

}


