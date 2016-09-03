package br.com.locadora.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class GenericoData<T> {
	private static final String URL = "jdbc:mysql://";
	private static final String PASSWORD = "Portela2016!";
	private static final String USERNAME = "root";
	private static final String SID = "locadora";
	private static final String PORTA = "3306";
	private static final String IP = "127.0.0.1";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	private Connection connection = null;  
	private PreparedStatement preparedStatement = null;

	private Connection getOpenConnection() throws Exception{
	    
		if(connection == null  || connection.isClosed()){
			Class.forName(DRIVER);  
	      
	        String url = URL + IP + ":" + PORTA + "/" + SID;  
	        
	        connection = DriverManager.getConnection(url, USERNAME, PASSWORD);  
	        connection.setAutoCommit(false);
		}
        
	    return connection;
	}
	
	protected void closeConnection() throws Exception{
		if(!connection.isClosed()){
			connection.close();
			connection = null;
		}
		
		if(!preparedStatement.isClosed()){
			preparedStatement.close();
			preparedStatement = null;
		}
	}
	
	protected void commit() throws Exception{
		connection.commit();
	}
	
	
	protected ResultSet buscar(String sql, List<Object> parametros ) throws Exception{
		preparedStatement = parametros(sql, parametros);
		
		ResultSet rs = preparedStatement.executeQuery();
		return rs;
	}
	
	
	protected boolean incluir(String sql, List<Object> parametros ) throws Exception{
		preparedStatement = parametros(sql, parametros);
		int quantidade = preparedStatement.executeUpdate();
		
		return quantidade > 0 ? true : false;

	}
	
	protected boolean atualizar(String sql, List<Object> parametros ) throws Exception{
		preparedStatement = parametros(sql, parametros);
		
		int quantidade = preparedStatement.executeUpdate();
		
		return quantidade > 0 ? true : false;

	}
	
	protected boolean deletar(String sql, List<Object> parametros ) throws Exception{
		preparedStatement = parametros(sql, parametros);
		
		int quantidade = preparedStatement.executeUpdate();
		
		return quantidade > 0 ? true : false;

	}
	
	
	private PreparedStatement parametros(String sql, List<Object> parametros) throws SQLException, Exception{
		preparedStatement = getOpenConnection().prepareStatement(sql);
		
		if(parametros != null){
			int i =1;
			
			for (Object object : parametros) {
				
				if(object instanceof String){
					preparedStatement.setString(i, (String) object);
				}else if(object instanceof Integer){
					preparedStatement.setInt(i, (Integer) object);
				}else if(object instanceof Long){
					preparedStatement.setLong(i, (Long) object);
				}
				
				i++;
			}
		}
		
		return preparedStatement;
		
	}
	
	
	
	
	
	

}
