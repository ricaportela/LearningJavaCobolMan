package br.com.locadora.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.model.Cliente;

public class ClienteData extends GenericoData<Cliente> {
	private final static String LISTAR_TODOS = "SELECT id, agencia, pagamento FROM cliente";
	private final static String BUSCAR_ID = "SELECT id FROM cliente WHERE id = ?";
	private final static String INCLUIR = "INSERT INTO cliente (id, agencia, pagamento) VALUES (?,?,?)";
	private final static String ATUALIZAR = "UPDATE cliente SET agencia=? WHERE id=?";
	private final static String DELETAR = "DELETE FROM cliente WHERE id=?";
	


	/*
	 * Listar Descrição: Listar os objetos numa Lista, utilizando o List.util do
	 * Java
	 */
	public List<Cliente> listarTodos() throws Exception {
		List<Cliente> clientes = new ArrayList<Cliente>();

		ResultSet rs = buscar(LISTAR_TODOS, null);
		while (rs.next()) {
			Cliente cliente = popular(rs);
			clientes.add(cliente);
		}

		rs.close();
		closeConnection();

		return clientes;

	}

	/*
	 * Buscar
	 */

	public Cliente buscar(Long id) throws Exception {

		Cliente cliente = null;

		List<Object> parametros = new ArrayList<Object>();
		parametros.add(id);

		ResultSet rs = buscar(BUSCAR_ID, parametros);

		if (rs.next()) {
			cliente = popular(rs);
		}

		rs.close();
		closeConnection();

		return cliente;

	}

	/*
	 * Incluir
	 */
	public boolean incluir(Cliente cliente) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(cliente.getId());
		//objects.add(cliente.getSocio();
		objects.add(cliente.getNome());
		objects.add(cliente.getNascimento());
		objects.add(cliente.getSexo());
		boolean retorno = incluir(INCLUIR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Atualizar	
	 */
	public boolean atualizar(Cliente cliente) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(cliente.getId());
		//objects.add(cliente.getSocio();
		objects.add(cliente.getNome());
		objects.add(cliente.getNascimento());
		objects.add(cliente.getSexo());

		boolean retorno = atualizar(ATUALIZAR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Deletar
	 */
	public boolean deletar(Cliente cliente) throws Exception {

		List<Object> objects = new ArrayList<>();

		objects.add(cliente.getId());

		boolean retorno = deletar(DELETAR, objects);

		commit();
		closeConnection();

		return retorno;
	}

	/*
	 * Popular
	 */

	private Cliente popular(ResultSet rs) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setId(rs.getLong("id"));
		//cliente.setSocio(rs.getLong("socio"));
		cliente.setNome(rs.getString("nome"));
		cliente.setNascimento(rs.getDate("nascimento"));
		cliente.setSexo(rs.getString("sexo"));
		
		return cliente;
	}

}


