package br.com.locadora.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.model.Cheque;

public class ChequeData extends GenericoData<Cheque> {
	private final static String LISTAR_TODOS = "SELECT id, agencia, pagamento FROM cheque";
	private final static String BUSCAR_ID = "SELECT id FROM cheque WHERE id = ?";
	private final static String INCLUIR = "INSERT INTO cheque (id, agencia, pagamento) VALUES (?,?,?)";
	private final static String ATUALIZAR = "UPDATE cheque SET agencia=? WHERE id=?";
	private final static String DELETAR = "DELETE FROM cheque WHERE id=?";

	/*
	 * Listar Descrição: Listar os objetos numa Lista, utilizando o List.util do
	 * Java
	 */
	public List<Cheque> listarTodos() throws Exception {
		List<Cheque> cheques = new ArrayList<Cheque>();

		ResultSet rs = buscar(LISTAR_TODOS, null);
		while (rs.next()) {
			Cheque cheque = popular(rs);
			cheques.add(cheque);
		}

		rs.close();
		closeConnection();

		return cheques;

	}

	/*
	 * Buscar
	 */

	public Cheque buscar(Long id) throws Exception {

		Cheque cheque = null;

		List<Object> parametros = new ArrayList<Object>();
		parametros.add(id);

		ResultSet rs = buscar(BUSCAR_ID, parametros);

		if (rs.next()) {
			cheque = popular(rs);
		}

		rs.close();
		closeConnection();

		return cheque;

	}

	/*
	 * Incluir
	 */
	public boolean incluir(Cheque cheque) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(cheque.getId());

		boolean retorno = incluir(INCLUIR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Atualizar	
	 */
	public boolean atualizar(Cheque cheque) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(cheque.getId());

		boolean retorno = atualizar(ATUALIZAR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Deletar
	 */
	public boolean deletar(Cheque cheque) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(cheque.getId());

		boolean retorno = deletar(DELETAR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Popular
	 */

	private Cheque popular(ResultSet rs) throws SQLException {
		Cheque cheque = new Cheque();
		cheque.setId(rs.getLong("id"));
		return cheque;
	}

}
