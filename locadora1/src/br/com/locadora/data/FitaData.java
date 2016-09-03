package br.com.locadora.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.model.Fita;
import br.com.locadora.model.Locacao;
import br.com.locadora.model.Titulo;

public class FitaData extends GenericoData<Fita> {
	private final static String LISTAR_TODOS = "SELECT id, agencia, pagamento FROM fita";
	private final static String BUSCAR_ID = "SELECT id FROM fita WHERE id = ?";
	private final static String INCLUIR = "INSERT INTO fita (id, agencia, pagamento) VALUES (?,?,?)";
	private final static String ATUALIZAR = "UPDATE fita SET agencia=? WHERE id=?";
	private final static String DELETAR = "DELETE FROM fita WHERE id=?";

	/*
	 * Listar Descrição: Listar os objetos numa Lista, utilizando o List.util do
	 * Java
	 */
	public List<Fita> listarTodos() throws Exception {
		List<Fita> fitas = new ArrayList<Fita>();

		ResultSet rs = buscar(LISTAR_TODOS, null);
		while (rs.next()) {
			Fita fita = popular(rs);
			fitas.add(fita);
		}

		rs.close();
		closeConnection();

		return fitas;

	}

	/*
	 * Buscar
	 */

	public Fita buscar(Long id) throws Exception {

		Fita fita = null;

		List<Object> parametros = new ArrayList<Object>();
		parametros.add(id);

		ResultSet rs = buscar(BUSCAR_ID, parametros);

		if (rs.next()) {
			fita = popular(rs);
		}

		rs.close();
		closeConnection();

		return fita;

	}

	/*
	 * Incluir
	 */
	public boolean incluir(Fita fita) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(fita.getId());

		boolean retorno = incluir(INCLUIR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Atualizar
	 */
	public boolean atualizar(Fita fita) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(fita.getId());

		boolean retorno = atualizar(ATUALIZAR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Deletar
	 */
	public boolean deletar(Fita fita) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(fita.getId());

		boolean retorno = deletar(DELETAR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Popular
	 */

	private Fita popular(ResultSet rs) throws SQLException {
		Fita fita = new Fita();
		fita.setId(rs.getLong("id"));
        //fita.setTitulo(rs.getString("titulo"));
		fita.setSerie(rs.getLong("serie"));
		fita.setAquisicao(rs.getTimestamp("aquisicao"));
		fita.setEstado(rs.getString("estado"));
        //fita.setLocacaos(rs.getLocacao("locacao"));
		
		
		
		return fita;
	}

}
