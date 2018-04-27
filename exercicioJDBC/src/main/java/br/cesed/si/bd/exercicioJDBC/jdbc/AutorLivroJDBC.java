package br.cesed.si.bd.exercicioJDBC.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.cesed.si.bd.exercicioJDBC.factories.ConexaoFactory;

public class AutorLivroJDBC {
	
	public void cadastrar(int idAutor, int idLivro) throws ClassNotFoundException, SQLException {
		Connection con = ConexaoFactory.getConexao();
		
		String sql = "insert into autores_livros values (?, ?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, idAutor);
		pst.setInt(2, idLivro);
		
		pst.executeUpdate();
		pst.close();
	}
	
	public void deletar(int idAutor, int idLivro) throws ClassNotFoundException, SQLException {
		Connection con = ConexaoFactory.getConexao();
		
		String sql = "delete from autores_livros where id_autor = ? and id_livro = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, idAutor);
		pst.setInt(2, idLivro);
		
		pst.executeUpdate();
		pst.close();
	}
}
