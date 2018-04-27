package br.cesed.si.bd.exercicioJDBC.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cesed.si.bd.exercicioJDBC.domain.Editora;
import br.cesed.si.bd.exercicioJDBC.domain.Endereco;
import br.cesed.si.bd.exercicioJDBC.factories.ConexaoFactory;
import br.cesed.si.bd.exercicioJDBC.interfaces.EditoraDAO;

public class EditoraJDBC implements EditoraDAO {

	public void cadastrar(Editora editora) throws ClassNotFoundException, SQLException {
		Connection con = ConexaoFactory.getConexao();
		
		String sql = "insert into editoras values (?, ?, ?, ?)";		
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, editora.getIdEditora());
		pst.setInt(2, editora.getEndereco().getIdEndereco());
		pst.setString(3, editora.getNome());
		pst.setString(4, editora.getCnpj());
		
		pst.executeUpdate();
		pst.close();
	}

	public void deletar(Editora editora) throws ClassNotFoundException, SQLException {
		Connection con = ConexaoFactory.getConexao();
		
		String sql = "delete from editoras where id_editora = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, editora.getIdEditora());
		
		pst.executeUpdate();
		pst.close();
	}

	public void atualizar(Editora editora) throws ClassNotFoundException, SQLException {
		Connection con = ConexaoFactory.getConexao();
		
		String sql = "update editoras set id_endereco = ?, nome = ?, cnpj = ? where id_editora = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, editora.getEndereco().getIdEndereco());
		pst.setString(2, editora.getNome());
		pst.setString(3, editora.getCnpj());
		pst.setInt(4, editora.getIdEditora());
		
		pst.executeUpdate();
		pst.close();
	}

	public List<Editora> listarTodos() throws ClassNotFoundException, SQLException {
		Connection con = ConexaoFactory.getConexao();
		
		List<Endereco> enderecos = getEnderecos();
		
		ArrayList<Editora> editoras = new ArrayList<Editora>();
		
		String sql = "select * from editoras";
		PreparedStatement pst = con.prepareStatement(sql);
		
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			int idEditora = rs.getInt("id_editora");
			int idEndereco = rs.getInt("id_endereco");
			Endereco endereco = null;
			for (Endereco e : enderecos) {
				if(e.getIdEndereco() == idEndereco) {
					endereco = e;
					break;
				}
			}
			String nome = rs.getString("nome");
			String cnpj = rs.getString("cnpj");
			Editora editora = new Editora(idEditora, endereco, nome, cnpj);
			editoras.add(editora);
		}
		pst.close();
		rs.close();
		return editoras;
	}
	
	public List<Endereco> getEnderecos() throws ClassNotFoundException, SQLException{
		Connection con = ConexaoFactory.getConexao();
		
		ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
		
		String sql = "select * from enderecos";
		PreparedStatement pst = con.prepareStatement(sql);
		
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			int id_endereco = rs.getInt("id_endereco");
			String cep = rs.getString("cep");
			String estado = rs.getString("estado");
			String cidade = rs.getString("cidade");
			String bairro = rs.getString("bairro");
			String rua = rs.getString("rua");
			int numero = rs.getInt("numero");
			Endereco endereco = new Endereco(id_endereco, cep, estado, cidade, bairro, rua, numero);
			enderecos.add(endereco);
		}
		
		pst.close();
		rs.close();
		return enderecos;
	}

	public List<Editora> listarPorNome(String nome) throws ClassNotFoundException, SQLException {
		List<Editora> editoras = listarTodos();
		List<Editora> achados = new ArrayList<Editora>();
		
		for (Editora e : editoras) {
			if(e.getNome().equals(nome)) {
				achados.add(e);
			}
		}
		return achados;
	}

	public Editora getPorCnpj(String cnpj) throws ClassNotFoundException, SQLException {
		List<Editora> editoras = listarTodos();
		Editora editora = null;
		for (Editora e : editoras) {
			if(e.getCnpj().equals(cnpj)) {
				editora = e;
			}
		}
		return editora;
	}

}
