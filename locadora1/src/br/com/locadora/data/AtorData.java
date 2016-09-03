package br.com.locadora.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.model.Ator;

public class AtorData extends GenericoData<Ator> {

	private final static String LISTAR_TODOS = "SELECT id, nome FROM ator";
	private final static String BUSCAR_ID = "SELECT id, nome FROM ator WHERE id = ?";
	private final static String INCLUIR = "INSERT INTO ator (id, nome) VALUES (?,?)";
	private final static String ATUALIZAR = "UPDATE ator SET nome=? WHERE id=?";
	private final static String DELETAR = "DELETE FROM ator WHERE id=?";

	public List<Ator> listarTodos() throws Exception {
		List<Ator> ators = new ArrayList<Ator>();

		ResultSet rs = buscar(LISTAR_TODOS, null);

		while (rs.next()) {
			Ator ator = popular(rs);
			ators.add(ator);
		}

		rs.close();
		closeConnection();

		return ators;
	}

	public Ator buscar(Long id) throws Exception {
		Ator ator = null;

		List<Object> parametros = new ArrayList<Object>();
		parametros.add(id);

		ResultSet rs = buscar(BUSCAR_ID, parametros);

		if (rs.next()) {
			ator = popular(rs);
		}

		rs.close();
		closeConnection();

		return ator;
	}

	public boolean incluir(Ator ator) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(ator.getId());
		objects.add(ator.getNome());

		boolean retorno = incluir(INCLUIR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	public boolean atualizar(Ator ator) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(ator.getNome());
		objects.add(ator.getId());

		boolean retorno = atualizar(ATUALIZAR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	public boolean deletar(Ator ator) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(ator.getId());

		boolean retorno = deletar(DELETAR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Popular
	 */

	private Ator popular(ResultSet rs) throws SQLException {
		Ator ator = new Ator();
		ator.setId(rs.getLong("id"));
		ator.setNome(rs.getString("nome"));
		return ator;
	}

	public static Ator buscarPorTitulo(Long idTitulo) {
		// TODO Auto-generated method stub
		return null;
	}

	
}


/*
 Incluir 

 public static void main(String[] args) {
 try {
 Ator ator = new Ator();
 ator.setId(6L);
 ator.setNome("Portela002");

 AtorData atorData = new AtorData();
 boolean retorno = atorData.incluir(ator);

 if(retorno){
 System.out.println("SUCESSO");

 List<Ator> ators = atorData.listarTodos();

 for (Ator atorAux : ators) {
 System.out.println("id :" + atorAux.getId() + " name  : " +
 atorAux.getNome());

 }

 }else{
 System.out.println("ERRO");

 }


 } catch (Exception e) {
 e.printStackTrace();
 }

 }



// Alterar
 public static void main(String[] args) {
 try {
 Ator ator = new Ator();
 ator.setId(1L);
 ator.setNome("Nicolas Cage");

 AtorData atorData = new AtorData();
 boolean retorno = atorData.atualizar(ator);

 if (retorno) {
 System.out.println("SUCESSO");

 List<Ator> ators = atorData.listarTodos();

 for (Ator atorAux : ators) {
 System.out.println("id :" + atorAux.getId() + " name  : "
 + atorAux.getNome());

 }

 } else {
 System.out.println("ERRO");

 }

 } catch (Exception e) {
 e.printStackTrace();
 }
 }

// Excluir


 * public static void main(String[] args) { try { Ator ator = new Ator();
 * ator.setId(1L);
 * 
 * 
 * AtorData atorData = new AtorData(); boolean retorno = atorData.deletar(ator);
 * 
 * if (retorno) { System.out.println("EXCLUIDO COM SUCESSO");
 * 
 * List<Ator> ators = atorData.listarTodos();
 * 
 * for (Ator atorAux : ators) { System.out.println("id :" + atorAux.getId() +
 * " name  : " + atorAux.getNome());
 * 
 * }
 * 
 * } else { System.out.println("ERRO");
 * 
 * }
 * 
 * } catch (Exception e) { e.printStackTrace(); } }
 * 
 * }
 */
