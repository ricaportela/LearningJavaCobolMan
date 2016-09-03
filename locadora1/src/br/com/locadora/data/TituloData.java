package br.com.locadora.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.model.Categoria;
import br.com.locadora.model.Classe;
import br.com.locadora.model.Distribuidor;
import br.com.locadora.model.Titulo;

public class TituloData extends GenericoData<Titulo> {

	private final static String LISTAR_TODOS = "SELECT id, nome, nomeOriginal, sinopse, ano, idClasse, idCategoria, idDistribuidor FROM titulo";
	private final static String BUSCAR_ID = "SELECT id, nome, nomeOriginal, sinopse, ano, idClasse, idCategoria, idDistribuidor FROM titulo WHERE id=?";
	private final static String INCLUIR = "INSERT INTO titulo (nome, nomeOriginal, sinopse, ano, idClasse, idCategoria, idDistribuidor) VALUES (?,?,?,?)";
	private final static String ATUALIZAR = "UPDATE titulo SET  nome=?, nomeOriginal=?, sinopse=?, ano=?,  idClasse=?, idCategoria=?, idDistribuidor=? WHERE id=?";
	private final static String DELETAR = "DELETE FROM titulo WHERE id=?";
	
	public List<Titulo> listarTodos() throws Exception {
		List<Titulo> titulos = new ArrayList<Titulo>();

		ResultSet rs = buscar(LISTAR_TODOS, null);

		while (rs.next()) {
			Titulo titulo = popular(rs);
			
			titulos.add(titulo);
		}
		rs.close();
		closeConnection();

		return titulos;
	}
	
	public Titulo buscar(Long id) throws Exception {
		Titulo titulo = null;
		
		List<Object> parametros = new ArrayList<Object>();
		parametros.add(id);
		
		ResultSet rs = buscar(BUSCAR_ID, parametros);

		if (rs.next()) {
			titulo = popular(rs);
		}

		rs.close();
		closeConnection();

		return titulo;
	}
	
	public boolean incluir(Titulo titulo) throws Exception {
		List<Object> objects = parametros(titulo);

		boolean retorno = incluir(INCLUIR, objects);

		commit();
		closeConnection();

		return retorno;
	}



	public boolean atualizar(Titulo titulo) throws Exception {
		List<Object> objects = parametros(titulo);
		objects.add(titulo.getId());
		
		boolean retorno = atualizar(ATUALIZAR, objects);

		commit();
		closeConnection();

		return retorno;
	}
	
	public boolean deletar(Titulo titulo) throws Exception {

		List<Object> objects = new ArrayList<>();
		
		objects.add(titulo.getId());

		boolean retorno = deletar(DELETAR, objects);

		commit();
		closeConnection();

		return retorno;
	}
	
	///////////////////////
	//PRIVATE
	//////////////////////
	
	private List<Object> parametros(Titulo titulo) {

		List<Object> objects = new ArrayList<Object>();
		
		objects.add(titulo.getNome());
		objects.add(titulo.getNomeOriginal());
		objects.add(titulo.getSinopse());
		objects.add(titulo.getAno());
		objects.add(titulo.getClasse().getId());
		objects.add(titulo.getCategoria().getId());
		objects.add(titulo.getDistribuidor().getId());
		
		return objects;
	}

	private Titulo popular(ResultSet rs) throws SQLException {
		Titulo titulo = new Titulo();
		titulo.setId(rs.getLong("id"));
		titulo.setNome(rs.getString("nome"));
		titulo.setNomeOriginal(rs.getString("nomeOriginal"));
		titulo.setSinopse(rs.getString("sinopse"));
		titulo.setAno(rs.getInt("ano"));
				
		Long idClasse = rs.getLong("idClasse");
		
		if(idClasse != null){
			Classe classe = new Classe();
			classe.setId(idClasse);
			titulo.setClasse(classe);
		}
		
		Long idCategoria = rs.getLong("idCategoria");
		
		if(idCategoria != null){
			Categoria categoria = new Categoria();
			categoria.setId(idClasse);
			titulo.setCategoria(categoria);
		}
		
		Long idDistribuidor = rs.getLong("idDistribuidor");
		
		if(idDistribuidor != null){
			Distribuidor distribuidor = new Distribuidor();
			distribuidor.setId(idDistribuidor);
			titulo.setDistribuidor(distribuidor);
		}
		
		return titulo;
	}
}
