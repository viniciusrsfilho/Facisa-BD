package br.cesed.si.bd.exercicioJDBC.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cesed.si.bd.exercicioJDBC.interfaces.LivroDAO;

public class LivroJDBC implements LivroDAO {

	public Connection getConexao() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		
		String url = "jdbc:postgresql://localhost/Biblioteca";
		String user = "postgres";
		String senha = "091198";
		return DriverManager.getConnection(url, user, senha);
	}

	public void cadastrar(Livro livro) throws ClassNotFoundException, SQLException {
		Connection con = getConexao();
		
	    String sql = "INSERT INTO LIVROS VALUES (?, ?, ?, ?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, livro.getId());
		pst.setString(2, livro.getTitulo());
		pst.setString(3, livro.getAutor());
		pst.setString(4, livro.getDescricao());

		pst.executeUpdate();
		pst.close();
	}

	public void deletar(Livro livro) throws ClassNotFoundException, SQLException {
		Connection con = getConexao();
		
		String sql = "delete from livros where id=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, livro.getId());
		pst.executeUpdate();
		pst.close();
	}

	public void atualizar(Livro livro) throws ClassNotFoundException, SQLException {
		Connection con = getConexao();
		
		String sql = "update livros set autor = ?, titulo = ?, descricao = ? where id = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, livro.getAutor());
		pst.setString(2, livro.getTitulo());
		pst.setString(3, livro.getDescricao());
		pst.setInt(4, livro.getId());
		pst.executeUpdate();
		pst.close();
	}

	public List<Livro> listarTodos() throws ClassNotFoundException, SQLException {
		Connection con = getConexao();
		
		ArrayList<Livro> livros = new ArrayList<Livro>();
		
		String sql = "select * from livros";
		PreparedStatement pst = con.prepareStatement(sql);
		
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			String titulo = rs.getString("titulo");
			String autor = rs.getString("autor");
			String descricao = rs.getString("descricao");
			Livro livro = new Livro(id, titulo, autor, descricao);
			livros.add(livro);
		}
		rs.close();
		pst.close();
		
		return livros;
	}
}
