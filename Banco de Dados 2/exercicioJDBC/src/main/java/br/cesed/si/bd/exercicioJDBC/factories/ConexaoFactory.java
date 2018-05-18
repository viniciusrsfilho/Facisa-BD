package br.cesed.si.bd.exercicioJDBC.factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	
	public static Connection getConexao() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		
		String url = "jdbc:postgresql://localhost/Biblioteca";
		String user = "postgres";
		String senha = "091198";
		return DriverManager.getConnection(url, user, senha);
	}

}
