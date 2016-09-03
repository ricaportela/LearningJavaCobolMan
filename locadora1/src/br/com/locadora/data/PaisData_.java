package br.com.locadora.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.model.Classe;

public class PaisData_ extends GenericoData<Classe> {
	private final static String LISTAR_TODOS = "SELECT id, agencia, pagamento FROM classe";
	private final static String BUSCAR_ID = "SELECT id FROM classe WHERE id = ?";
	private final static String INCLUIR = "INSERT INTO classe (id, agencia, pagamento) VALUES (?,?,?)";
	private final static String ATUALIZAR = "UPDATE classe SET agencia=? WHERE id=?";
	private final static String DELETAR = "DELETE FROM classe WHERE id=?";

	/*
	 * Listar Descrição: Listar os objetos numa Lista, utilizando o List.util do
	 * Java
	 */
	public List<Classe> listarTodos() throws Exception {
		List<Classe> classes = new ArrayList<Classe>();

		ResultSet rs = buscar(LISTAR_TODOS, null);
		while (rs.next()) {
			Classe classe = popular(rs);
			classes.add(classe);
		}

		rs.close();
		closeConnection();

		return classes;

	}

	/*
	 * Buscar
	 */

	public Classe buscar(Long id) throws Exception {

		Classe classe = null;

		List<Object> parametros = new ArrayList<Object>();
		parametros.add(id);

		ResultSet rs = buscar(BUSCAR_ID, parametros);

		if (rs.next()) {
			classe = popular(rs);
		}

		rs.close();
		closeConnection();

		return classe;

	}

	/*
	 * Incluir
	 */
	public boolean incluir(Classe classe) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(classe.getId());

		boolean retorno = incluir(INCLUIR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Atualizar	
	 */
	public boolean atualizar(Classe classe) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(classe.getId());

		boolean retorno = atualizar(ATUALIZAR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Deletar
	 */
	public boolean deletar(Classe classe) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(classe.getId());

		boolean retorno = deletar(DELETAR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Popular
	 */

	private Classe popular(ResultSet rs) throws SQLException {
		Classe classe = new Classe();
		classe.setId(rs.getLong("id"));
		classe.setDescricao(rs.getString("descricao"));
		classe.setPreco(rs.getBigDecimal("preco"));
		classe.setPrazo(rs.getInt("prazo"));
		
		return classe;
	}

}


