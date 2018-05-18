package br.cesed.si.bd.exercicioJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.cesed.si.bd.exercicioJDBC.domain.Endereco;
import br.cesed.si.bd.exercicioJDBC.factories.ConexaoFactory;
import br.cesed.si.bd.exercicioJDBC.jdbc.EnderecoJDBC;

public class EnderecoJDBCTeste {

	@Before
	public void deletarObjetos() throws ClassNotFoundException, SQLException {
		Connection con = ConexaoFactory.getConexao();
		Statement s = con.createStatement();
		s.executeUpdate("delete from enderecos where id_endereco >= 1");
	}
	
	@Test
	public void testCadastrar() throws ClassNotFoundException, SQLException {
		Endereco endereco1 = new Endereco(1, "58400", "PB", "Campina Grande", "Centro", "Maciel Pinheiro", 100);
		Endereco endereco2 = new Endereco(2, "58450", "PE", "Recife", "Centro", "Rua 01", 200);
		
		EnderecoJDBC enderecojdbc = new EnderecoJDBC();
		
		enderecojdbc.cadastrar(endereco1);
		enderecojdbc.cadastrar(endereco2);
	}
	
	@Test
	public void testDeletar() throws ClassNotFoundException, SQLException {
		Endereco endereco1 = new Endereco(1, "58400", "PB", "Campina Grande", "Centro", "Maciel Pinheiro", 100);
		Endereco endereco2 = new Endereco(2, "58450", "PE", "Recife", "Centro", "Rua 01", 200);
		
		EnderecoJDBC enderecojdbc = new EnderecoJDBC();
		
		enderecojdbc.cadastrar(endereco1);
		enderecojdbc.cadastrar(endereco2);
		
		enderecojdbc.deletar(endereco1);
		enderecojdbc.deletar(endereco2);
	
	}
	
	
	@Test
	public void testAtualizar() throws ClassNotFoundException, SQLException {
		Endereco endereco1 = new Endereco(1, "58400", "PB", "CG", "Centro", "Maciel Pinheiro", 100);
		Endereco endereco2 = new Endereco(2, "58450", "Pernambuco", "Recife", "Centro", "Rua 01", 200);
		
		EnderecoJDBC enderecojdbc = new EnderecoJDBC();
		
		enderecojdbc.cadastrar(endereco1);
		enderecojdbc.cadastrar(endereco2);
		
		endereco1.setCidade("Campina Grande");
		endereco2.setEstado("PE");
		enderecojdbc.atualizar(endereco1);
		enderecojdbc.atualizar(endereco2);
	
	}
	
	@Test
	public void testListarTodos() throws ClassNotFoundException, SQLException {
		Endereco endereco1 = new Endereco(1, "58400", "PB", "CG", "Centro", "Maciel Pinheiro", 100);
		Endereco endereco2 = new Endereco(2, "58450", "Pernambuco", "Recife", "Centro", "Rua 01", 200);
		
		EnderecoJDBC enderecojdbc = new EnderecoJDBC();
		
		enderecojdbc.cadastrar(endereco1);
		enderecojdbc.cadastrar(endereco2);
		
		enderecojdbc.listarTodos();
	}
	
	@After
	public void deletarObjetosAfter() throws ClassNotFoundException, SQLException {
		Connection con = ConexaoFactory.getConexao();
		Statement s = con.createStatement();
		s.executeUpdate("delete from enderecos where id_endereco >= 1");
	}

}
