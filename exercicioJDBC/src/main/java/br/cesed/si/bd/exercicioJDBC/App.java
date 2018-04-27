package br.cesed.si.bd.exercicioJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import br.cesed.si.bd.exercicioJDBC.factories.ConexaoFactory;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = ConexaoFactory.getConexao();
		
		
		PreparedStatement stm = con.prepareStatement("insert into enderecos (id_endereco, cep) values (?, ?)");
		stm.setInt(1, 3);
		stm.setString(2, "12345");
		
		stm.executeUpdate();
	}
}
