package br.com.locadora.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.model.Locacao;

public class LocacaoData_ extends GenericoData<Locacao> {
	private final static String LISTAR_TODOS = "SELECT id, agencia, pagamento FROM locacao";
	private final static String BUSCAR_ID = "SELECT id FROM locacao WHERE id = ?";
	private final static String INCLUIR = "INSERT INTO locacao (id, agencia, pagamento) VALUES (?,?,?)";
	private final static String ATUALIZAR = "UPDATE locacao SET agencia=? WHERE id=?";
	private final static String DELETAR = "DELETE FROM locacao WHERE id=?";

	/*
	 * Listar Descrição: Listar os objetos numa Lista, utilizando o List.util do
	 * Java
	 */
	public List<Locacao> listarTodos() throws Exception {
		List<Locacao> locacaos = new ArrayList<Locacao>();

		ResultSet rs = buscar(LISTAR_TODOS, null);
		while (rs.next()) {
			Locacao locacao = popular(rs);
			locacaos.add(locacao);
		}

		rs.close();
		closeConnection();

		return locacaos;

	}

	/*
	 * Buscar
	 */

	public Locacao buscar(Long id) throws Exception {

		Locacao locacao = null;

		List<Object> parametros = new ArrayList<Object>();
		parametros.add(id);

		ResultSet rs = buscar(BUSCAR_ID, parametros);

		if (rs.next()) {
			locacao = popular(rs);
		}

		rs.close();
		closeConnection();

		return locacao;

	}

	/*
	 * Incluir
	 */
	public boolean incluir(Locacao locacao) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(locacao.getId());

		boolean retorno = incluir(INCLUIR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Atualizar	
	 */
	public boolean atualizar(Locacao locacao) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(locacao.getId());

		boolean retorno = atualizar(ATUALIZAR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Deletar
	 */
	public boolean deletar(Locacao locacao) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(locacao.getId());

		boolean retorno = deletar(DELETAR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Popular
	 */

	private Locacao popular(ResultSet rs) throws SQLException {
		Locacao locacao = new Locacao();
		locacao.setId(rs.getLong("id"));
//		locacao.setLong(rs.getLong("pagamentodevolucao"));
		
//		private Long id;
//		private Pagamento pagamentoLocacao;
//		private Pagamento pagamentoDevolucao;
//		private Cliente cliente;
//		private Fita fita;
//		private Timestamp dataLocacao;
//		private Timestamp dataDevolucaoPrevista;
//		private Timestamp dataDevolucaoEfetiva;
//		private BigDecimal valorCobrado;
//		private String estado;

		
		return locacao;
	}

}


