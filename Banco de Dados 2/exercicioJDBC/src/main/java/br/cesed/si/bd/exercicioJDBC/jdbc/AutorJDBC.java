package br.cesed.si.bd.exercicioJDBC.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.cesed.si.bd.exercicioJDBC.domain.Autor;
import br.cesed.si.bd.exercicioJDBC.factories.ConexaoFactory;
import br.cesed.si.bd.exercicioJDBC.interfaces.AutorDAO;

public class AutorJDBC implements AutorDAO {

	public void cadastrar(Autor autor) throws ClassNotFoundException, SQLException {
		Connection con = ConexaoFactory.getConexao();

		PreparedStatement pst = con.prepareStatement("insert into autores values (?, ?, ?, ?)");
		pst.setInt(1, autor.getId_autor());
		pst.setString(2, autor.getNome());
		pst.setString(3, autor.getCpf());
		pst.setString(4, autor.getEmail());
		
		pst.executeUpdate();
		pst.close();
	}

	public void deletar(Autor autor) throws ClassNotFoundException, SQLException {
		Connection con = ConexaoFactory.getConexao();
		
		PreparedStatement pst = con.prepareStatement("delete from autores where id_autor = ?");
		pst.setInt(1, autor.getId_autor());
		
		pst.executeUpdate();
		pst.close();
	}

	public void atualizar(Autor autor) throws ClassNotFoundException, SQLException {
		Connection con = ConexaoFactory.getConexao();

		String sql = "update autores set nome = ?, cpf = ?, email = ? where id_autor = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, autor.getNome());
		pst.setString(2, autor.getCpf());
		pst.setString(3, autor.getEmail());
		pst.setInt(4, autor.getId_autor());
		
		pst.executeUpdate();
		pst.close();
	}

	public List<Autor> listarTodos() throws ClassNotFoundException, SQLException {
		Connection con = ConexaoFactory.getConexao();
		
		ArrayList<Autor> autores = new ArrayList<Autor>();

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from autores");
		while(rs.next()) {
			int idAutor = rs.getInt("id_autor");
			String nome = rs.getString("nome");
			String cpf = rs.getString("cpf");
			String email = rs.getString("email");
			Autor autor = new Autor(idAutor, nome, cpf, email);
			autores.add(autor);
		}
		st.close();
		rs.close();
		return autores;
	}
	
	public List<Autor> listarPorNome(String nome) throws ClassNotFoundException, SQLException {
		
		List<Autor> autores = listarTodos();
		List<Autor> achados = new ArrayList<Autor>();
		
		for (Autor a : autores) {
			if(a.getNome().equals(nome)) {
				achados.add(a);
			}
		}
		
		return achados;
	}

}
