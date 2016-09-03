package br.com.locadora.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.model.Banco;

public class BancoData extends GenericoData<Banco> {
	private final static String LISTAR_TODOS = "SELECT id FROM banco";
	private final static String BUSCAR_ID = "SELECT id FROM banco WHERE id = ?";
	private final static String INCLUIR = "INSERT INTO banco (id) VALUES (?)";
	private final static String ATUALIZAR = "UPDATE banco SET nome=? WHERE id=?";
	private final static String DELETAR = "DELETE FROM banco WHERE id=?";

	/*
	 * Listar Descrição: Listar os objetos numa Lista, utilizando o List.util do
	 * Java
	 */
	public List<Banco> listarTodos() throws Exception {
		List<Banco> bancos = new ArrayList<Banco>();

		ResultSet rs = buscar(LISTAR_TODOS, null);
		while (rs.next()) {
			Banco banco = popular(rs);
			bancos.add(banco);
		}

		rs.close();
		closeConnection();

		return bancos;

	}

	/*
	 * Buscar
	 */

	public Banco buscar(Long id) throws Exception {

		Banco banco = null;

		List<Object> parametros = new ArrayList<Object>();
		parametros.add(id);

		ResultSet rs = buscar(BUSCAR_ID, parametros);

		if (rs.next()) {
			banco = popular(rs);
		}

		rs.close();
		closeConnection();

		return banco;

	}

	/*
	 * Incluir
	 */
	public boolean incluir(Banco banco) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(banco.getId());

		boolean retorno = incluir(INCLUIR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Atualizar	
	 */
	public boolean atualizar(Banco banco) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(banco.getId());

		boolean retorno = atualizar(ATUALIZAR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Deletar
	 */
	public boolean deletar(Banco banco) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(banco.getId());

		boolean retorno = deletar(DELETAR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Popular
	 */

	private Banco popular(ResultSet rs) throws SQLException {
		Banco banco = new Banco();
		banco.setId(rs.getLong("id"));
		return banco;
	}

}
