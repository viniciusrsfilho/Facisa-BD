package br.cesed.si.bd.exercicioJDBC.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cesed.si.bd.exercicioJDBC.domain.Editora;
import br.cesed.si.bd.exercicioJDBC.domain.Endereco;
import br.cesed.si.bd.exercicioJDBC.domain.Livro;
import br.cesed.si.bd.exercicioJDBC.factories.ConexaoFactory;
import br.cesed.si.bd.exercicioJDBC.interfaces.LivroDAO;

public class LivroJDBC implements LivroDAO {

	public void cadastrar(Livro livro) throws ClassNotFoundException, SQLException {
		Connection con = ConexaoFactory.getConexao();
		
	    String sql = "INSERT INTO LIVROS VALUES (?, ?, ?, ?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, livro.getIdLivro());
		pst.setString(2, livro.getTitulo());
		pst.setString(3, livro.getDescricao());
		pst.setInt(4, livro.getEditora().getIdEditora());

		pst.executeUpdate();
		pst.close();
	}

	public void deletar(Livro livro) throws ClassNotFoundException, SQLException {
		Connection con = ConexaoFactory.getConexao();
		
		String sql = "delete from livros where id_livro=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, livro.getIdLivro());
		pst.executeUpdate();
		pst.close();
	}

	public void atualizar(Livro livro) throws ClassNotFoundException, SQLException {
		Connection con = ConexaoFactory.getConexao();
		
		String sql = "update livros set titulo = ?, descricao = ?, id_editora = ? where id_livro = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, livro.getTitulo());
		pst.setString(2, livro.getDescricao());
		pst.setInt(3, livro.getEditora().getIdEditora());
		pst.setInt(4, livro.getIdLivro());
		pst.executeUpdate();
		pst.close();
	}

	public List<Livro> listarTodos() throws ClassNotFoundException, SQLException {
		Connection con = ConexaoFactory.getConexao();
		
		ArrayList<Livro> livros = new ArrayList<Livro>();
		
		String sql = "select * from livros";
		PreparedStatement pst = con.prepareStatement(sql);
		
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			int id_livro = rs.getInt("id_livro");
			String titulo = rs.getString("titulo");
			String descricao = rs.getString("descricao");
			int id_editora = rs.getInt("id_editora");
			List<Editora> editoras = getEditoras();
			Editora editora = null;
			for (Editora e : editoras) {
				if(e.getIdEditora() == id_editora) {
					editora = e;
				}
			}
			Livro livro = new Livro(id_livro, titulo, descricao, editora);
			livros.add(livro);
		}
		rs.close();
		pst.close();
		
		return livros;
	}
	
	public List<Endereco> getEnderecos() throws ClassNotFoundException, SQLException{
		Connection con = ConexaoFactory.getConexao();
		
		ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
		
		String sql = "select * from enderecos";
		PreparedStatement pst1 = con.prepareStatement(sql);
		
		ResultSet rs1 = pst1.executeQuery();
		while(rs1.next()) {
			int id_endereco = rs1.getInt("id_endereco");
			String cep = rs1.getString("cep");
			String estado = rs1.getString("estado");
			String cidade = rs1.getString("cidade");
			String bairro = rs1.getString("bairro");
			String rua = rs1.getString("rua");
			int numero = rs1.getInt("numero");
			Endereco endereco = new Endereco(id_endereco, cep, estado, cidade, bairro, rua, numero);
			enderecos.add(endereco);
		}
		pst1.close();
		rs1.close();
		return enderecos;
	}
	
	public List<Editora> getEditoras() throws SQLException, ClassNotFoundException {
		Connection con = ConexaoFactory.getConexao();
		
		ArrayList<Editora> editoras = new ArrayList<Editora>();
		
		String sql1 = "select * from editoras";
		PreparedStatement pst1 = con.prepareStatement(sql1);
		
		ResultSet rs1 = pst1.executeQuery();
		while(rs1.next()) {
			int id_editora = rs1.getInt("id_editora");
			int id_endereco = rs1.getInt("id_endereco");
			List<Endereco> enderecos = getEnderecos();
			Endereco endereco = null;
			for (Endereco e : enderecos) {
				if(e.getIdEndereco() == id_endereco) {
					endereco = e;
					break;
				}
			}
			String nome = rs1.getString("nome");
			String cnpj = rs1.getString("cnpj");
			Editora editora = new Editora(id_editora, endereco, nome, cnpj);
			editoras.add(editora);
		}
		pst1.close();
		rs1.close();
		return editoras;
	}

	public List<Livro> listarPorTitulo(String titulo) throws ClassNotFoundException, SQLException {
		List<Livro> livros = listarTodos();
		List<Livro> achados = new ArrayList<Livro>();
		
		for (Livro l : livros) {
			if(l.getTitulo().equals(titulo)) {
				achados.add(l);
			}
		}

		return achados;
	}
}
