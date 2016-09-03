package br.com.locadora.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.model.Bairro;

public class BairroData extends GenericoData<Bairro> {

	private final static String LISTAR_TODOS = "SELECT id, nome FROM bairro";
	private final static String BUSCAR_ID = "SELECT id, nome FROM bairro WHERE id = ?";
	private final static String INCLUIR = "INSERT INTO bairro (id, nome) VALUES (?,?)";
	private final static String ATUALIZAR = "UPDATE bairro SET nome=? WHERE id=?";
	private final static String DELETAR = "DELETE FROM bairro WHERE id=?";

	public List<Bairro> listarTodos() throws Exception {
		List<Bairro> bairros = new ArrayList<Bairro>();

		ResultSet rs = buscar(LISTAR_TODOS, null);

		while (rs.next()) {
			Bairro bairro = popular(rs);
			bairros.add(bairro);
		}

		rs.close();
		closeConnection();

		return bairros;
	}

	public Bairro buscar(Long id) throws Exception {
		Bairro bairro = null;

		List<Object> parametros = new ArrayList<Object>();
		parametros.add(id);

		ResultSet rs = buscar(BUSCAR_ID, parametros);

		if (rs.next()) {
			bairro = popular(rs);
		}

		rs.close();
		closeConnection();

		return bairro;
	}

	public boolean incluir(Bairro bairro) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(bairro.getId());
		objects.add(bairro.getNome());

		boolean retorno = incluir(INCLUIR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	public boolean atualizar(Bairro bairro) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(bairro.getNome());
		objects.add(bairro.getId());

		boolean retorno = atualizar(ATUALIZAR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	public boolean deletar(Bairro bairro) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(bairro.getId());

		boolean retorno = deletar(DELETAR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/* 
	 * Popular
	 */

	private Bairro popular(ResultSet rs) throws SQLException {
		Bairro bairro = new Bairro();
		bairro.setId(rs.getLong("id"));
		bairro.setNome(rs.getString("nome"));
		return bairro;
	}

	/*
	 * este classe serve para testar 
	 *  
	 * public static void main(String[] args) { try { Bairro bairro = new
	 * Bairro(); bairro.setId(1L);
	 * 
	 * 
	 * BairroData bairroData = new BairroData(); boolean retorno =
	 * bairroData.deletar(bairro);
	 * 
	 * if (retorno) { System.out.println("EXCLUIDO COM SUCESSO");
	 * 
	 * List<Bairro> bairros = bairroData.listarTodos();
	 * 
	 * for (Bairro bairroAux : bairros) { System.out.println("id :" +
	 * bairroAux.getId() + " name  : " + bairroAux.getNome());
	 * 
	 * }
	 * 
	 * } else { System.out.println("ERRO");
	 * 
	 * }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } }
	 */

}
