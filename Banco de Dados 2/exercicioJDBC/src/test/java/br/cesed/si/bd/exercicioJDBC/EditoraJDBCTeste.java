package br.cesed.si.bd.exercicioJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.cesed.si.bd.exercicioJDBC.domain.Editora;
import br.cesed.si.bd.exercicioJDBC.domain.Endereco;
import br.cesed.si.bd.exercicioJDBC.factories.ConexaoFactory;
import br.cesed.si.bd.exercicioJDBC.jdbc.EditoraJDBC;
import br.cesed.si.bd.exercicioJDBC.jdbc.EnderecoJDBC;

public class EditoraJDBCTeste {
	
	@Before
	public void deletarObjetos() throws ClassNotFoundException, SQLException {
		Connection con = ConexaoFactory.getConexao();
		
		Statement st = con.createStatement();
		st.executeUpdate("delete from editoras where id_editora >= 1");
		st.executeUpdate("delete from enderecos where id_endereco >= 1");
	}
	
	@Test
	public void testCadastrar() throws ClassNotFoundException, SQLException {
		Endereco endereco = new Endereco(1, "58400", "PB", "Campina Grande", "Centro", "Maciel Pinheiro", 100);
		EnderecoJDBC enderecojdbc = new EnderecoJDBC();
		enderecojdbc.cadastrar(endereco);
		
		Editora editora1 = new Editora(1, endereco, "editora1", "123.123");
		Editora editora2 = new Editora(2, endereco, "editora2", "112.133");
		
		EditoraJDBC editorajdbc = new EditoraJDBC();
		editorajdbc.cadastrar(editora1);
		editorajdbc.cadastrar(editora2);
	}
	
	@Test
	public void testDeletar() throws ClassNotFoundException, SQLException {
		Endereco endereco = new Endereco(1, "58400", "PB", "Campina Grande", "Centro", "Maciel Pinheiro", 100);
		EnderecoJDBC enderecojdbc = new EnderecoJDBC();
		enderecojdbc.cadastrar(endereco);
		
		Editora editora1 = new Editora(1, endereco, "editora1", "123.123");
		Editora editora2 = new Editora(2, endereco, "editora2", "112.133");
		
		EditoraJDBC editorajdbc = new EditoraJDBC();
		editorajdbc.cadastrar(editora1);
		editorajdbc.cadastrar(editora2);
		
		editorajdbc.deletar(editora1);
		editorajdbc.deletar(editora2);
	}
	
	@Test
	public void testAtualizar() throws ClassNotFoundException, SQLException {
		Endereco endereco = new Endereco(1, "58400", "PB", "Campina Grande", "Centro", "Maciel Pinheiro", 100);
		EnderecoJDBC enderecojdbc = new EnderecoJDBC();
		enderecojdbc.cadastrar(endereco);
		
		Editora editora1 = new Editora(1, endereco, "editora1", "123.123");
		Editora editora2 = new Editora(2, endereco, "edit2", "112.133");
		
		EditoraJDBC editorajdbc = new EditoraJDBC();
		editorajdbc.cadastrar(editora1);
		editorajdbc.cadastrar(editora2);
		
		editora2.setNome("editora2");
		editorajdbc.atualizar(editora2);
		
		editora1.setCnpj("123.125");
		editorajdbc.atualizar(editora1);
	}

	@Test
	public void testListarTodos() throws ClassNotFoundException, SQLException {
		Endereco endereco = new Endereco(1, "58400", "PB", "Campina Grande", "Centro", "Maciel Pinheiro", 100);
		EnderecoJDBC enderecojdbc = new EnderecoJDBC();
		enderecojdbc.cadastrar(endereco);
		
		Editora editora1 = new Editora(1, endereco, "editora1", "123.123");
		Editora editora2 = new Editora(2, endereco, "edit2", "112.133");
		
		EditoraJDBC editorajdbc = new EditoraJDBC();
		editorajdbc.cadastrar(editora1);
		editorajdbc.cadastrar(editora2);

		editorajdbc.listarTodos();
	}
	
	@Test
	public void testListarPorNome() throws ClassNotFoundException, SQLException {
		Endereco endereco = new Endereco(1, "58400", "PB", "Campina Grande", "Centro", "Maciel Pinheiro", 100);
		EnderecoJDBC enderecojdbc = new EnderecoJDBC();
		enderecojdbc.cadastrar(endereco);
		
		Editora editora1 = new Editora(1, endereco, "editora1", "123.123");
		Editora editora2 = new Editora(2, endereco, "edit2", "112.133");
		
		EditoraJDBC editorajdbc = new EditoraJDBC();
		editorajdbc.cadastrar(editora1);
		editorajdbc.cadastrar(editora2);
		
		editorajdbc.listarPorNome("editora1");
		editorajdbc.listarPorNome("edit2");
	}
	
	@Test
	public void testGetPorCnpj() throws ClassNotFoundException, SQLException {
		Endereco endereco = new Endereco(1, "58400", "PB", "Campina Grande", "Centro", "Maciel Pinheiro", 100);
		EnderecoJDBC enderecojdbc = new EnderecoJDBC();
		enderecojdbc.cadastrar(endereco);
		
		Editora editora1 = new Editora(1, endereco, "editora1", "123.123");
		Editora editora2 = new Editora(2, endereco, "edit2", "112.133");
		
		EditoraJDBC editorajdbc = new EditoraJDBC();
		editorajdbc.cadastrar(editora1);
		editorajdbc.cadastrar(editora2);
		
		editorajdbc.getPorCnpj("112.133");
		editorajdbc.getPorCnpj("123.123");
	}
	
	@After
	public void deletarObjetosAfter() throws ClassNotFoundException, SQLException {
		Connection con = ConexaoFactory.getConexao();
		
		Statement st = con.createStatement();
		st.executeUpdate("delete from editoras where id_editora >= 1");
		st.executeUpdate("delete from enderecos where id_endereco >= 1");
	}

}
