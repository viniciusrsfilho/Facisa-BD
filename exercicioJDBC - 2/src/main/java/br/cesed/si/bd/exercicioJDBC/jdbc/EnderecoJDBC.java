package br.cesed.si.bd.exercicioJDBC.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cesed.si.bd.exercicioJDBC.domain.Endereco;
import br.cesed.si.bd.exercicioJDBC.factories.ConexaoFactory;
import br.cesed.si.bd.exercicioJDBC.interfaces.EnderecoDAO;

public class EnderecoJDBC implements EnderecoDAO {

	public void cadastrar(Endereco endereco) throws ClassNotFoundException, SQLException {
		Connection con = ConexaoFactory.getConexao();
		
		String sql = "insert into enderecos values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, endereco.getIdEndereco());
		pst.setString(2, endereco.getCep());
		pst.setString(3, endereco.getEstado());
		pst.setString(4, endereco.getCidade());
		pst.setString(5, endereco.getBairro());
		pst.setString(6, endereco.getRua());
		pst.setInt(7, endereco.getNumero());
		
		pst.executeUpdate();
		pst.close();
	}

	public void deletar(Endereco endereco) throws ClassNotFoundException, SQLException {
		Connection con = ConexaoFactory.getConexao();
		
		String sql = "delete from enderecos where id_endereco = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, endereco.getIdEndereco());
		
		pst.executeUpdate();
		pst.close();
	}

	public void atualizar(Endereco endereco) throws ClassNotFoundException, SQLException {
		Connection con = ConexaoFactory.getConexao();
		
		String sql = "update enderecos set cep = ?, estado = ?, cidade = ?, bairro = ?, "
				+ "rua = ?, numero = ? where id_endereco = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, endereco.getCep());
		pst.setString(2, endereco.getEstado());
		pst.setString(3, endereco.getCidade());
		pst.setString(4, endereco.getBairro());
		pst.setString(5, endereco.getRua());
		pst.setInt(6, endereco.getNumero());
		pst.setInt(7, endereco.getIdEndereco());
		
		pst.executeUpdate();
		pst.close();
				
	}

	public List<Endereco> listarTodos() throws ClassNotFoundException, SQLException {
		Connection con = ConexaoFactory.getConexao();
		
		ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
		
		String sql = "select * from enderecos";
		PreparedStatement pst = con.prepareStatement(sql);
		
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			int idEndereco = rs.getInt("id_endereco");
			String cep = rs.getString("cep");
			String estado = rs.getString("estado");
			String cidade = rs.getString("cidade");
			String bairro = rs.getString("bairro");
			String rua = rs.getString("rua");
			int numero = rs.getInt("numero");
			
			Endereco endereco = new Endereco(idEndereco, cep, estado, cidade, bairro, rua, numero);
			enderecos.add(endereco);
		}
		pst.close();
		rs.close();
		return enderecos;
	}
	

}
