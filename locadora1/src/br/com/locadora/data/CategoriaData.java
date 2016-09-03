package br.com.locadora.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.model.Categoria;

public class CategoriaData extends GenericoData<Categoria> {
	private final static String LISTAR_TODOS = "SELECT id FROM categoria";
	private final static String BUSCAR_ID = "SELECT id FROM categoria WHERE id = ?";
	private final static String INCLUIR = "INSERT INTO categoria (id) VALUES (?)";
	private final static String ATUALIZAR = "UPDATE categoria SET nome=? WHERE id=?";
	private final static String DELETAR = "DELETE FROM categoria WHERE id=?";

	/*
	 * Listar Descrição: Listar os objetos numa Lista, utilizando o List.util do
	 * Java
	 */
	public List<Categoria> listarTodos() throws Exception {
		List<Categoria> categorias = new ArrayList<Categoria>();

		ResultSet rs = buscar(LISTAR_TODOS, null);
		while (rs.next()) {
			Categoria categoria = popular(rs);
			categorias.add(categoria);
		}

		rs.close();
		closeConnection();

		return categorias;

	}

	/*
	 * Buscar
	 */

	public Categoria buscar(Long id) throws Exception {

		Categoria categoria = null;

		List<Object> parametros = new ArrayList<Object>();
		parametros.add(id);

		ResultSet rs = buscar(BUSCAR_ID, parametros);

		if (rs.next()) {
			categoria = popular(rs);
		}

		rs.close();
		closeConnection();

		return categoria;

	}

	/*
	 * Incluir
	 */
	public boolean incluir(Categoria categoria) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(categoria.getId());

		boolean retorno = incluir(INCLUIR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Atualizar	
	 */
	public boolean atualizar(Categoria categoria) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(categoria.getId());

		boolean retorno = atualizar(ATUALIZAR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Deletar
	 */
	public boolean deletar(Categoria categoria) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(categoria.getId());

		boolean retorno = deletar(DELETAR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Popular
	 */

	private Categoria popular(ResultSet rs) throws SQLException {
		Categoria categoria = new Categoria();
		categoria.setId(rs.getLong("id"));
		return categoria;
	}

}
