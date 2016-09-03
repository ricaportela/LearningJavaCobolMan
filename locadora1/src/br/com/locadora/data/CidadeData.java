package br.com.locadora.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.model.Cidade;

public class CidadeData extends GenericoData<Cidade> {
	private final static String LISTAR_TODOS = "SELECT id, agencia, pagamento FROM cidade";
	private final static String BUSCAR_ID = "SELECT id FROM cidade WHERE id = ?";
	private final static String INCLUIR = "INSERT INTO cidade (id, agencia, pagamento) VALUES (?,?,?)";
	private final static String ATUALIZAR = "UPDATE cidade SET agencia=? WHERE id=?";
	private final static String DELETAR = "DELETE FROM cidade WHERE id=?";

	/*
	 * Listar Descrição: Listar os objetos numa Lista, utilizando o List.util do
	 * Java
	 */
	public List<Cidade> listarTodos() throws Exception {
		List<Cidade> cidades = new ArrayList<Cidade>();

		ResultSet rs = buscar(LISTAR_TODOS, null);
		while (rs.next()) {
			Cidade cidade = popular(rs);
			cidades.add(cidade);
		}

		rs.close();
		closeConnection();

		return cidades;

	}

	/*
	 * Buscar
	 */

	public Cidade buscar(Long id) throws Exception {

		Cidade cidade = null;

		List<Object> parametros = new ArrayList<Object>();
		parametros.add(id);

		ResultSet rs = buscar(BUSCAR_ID, parametros);

		if (rs.next()) {
			cidade = popular(rs);
		}

		rs.close();
		closeConnection();

		return cidade;

	}

	/*
	 * Incluir
	 */
	public boolean incluir(Cidade cidade) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(cidade.getId());

		boolean retorno = incluir(INCLUIR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Atualizar	
	 */
	public boolean atualizar(Cidade cidade) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(cidade.getId());

		boolean retorno = atualizar(ATUALIZAR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Deletar
	 */
	public boolean deletar(Cidade cidade) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(cidade.getId());

		boolean retorno = deletar(DELETAR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Popular
	 */

	private Cidade popular(ResultSet rs) throws SQLException {
		Cidade cidade = new Cidade();
		cidade.setId(rs.getLong("id"));
		//cidade.setEstado(rs.getEstado("estado"));
		cidade.setNome(rs.getString("nome"));
		return cidade;
	}

}
