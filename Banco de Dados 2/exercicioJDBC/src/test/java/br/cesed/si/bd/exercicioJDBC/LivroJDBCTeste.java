package br.cesed.si.bd.exercicioJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import br.cesed.si.bd.exercicioJDBC.domain.Editora;
import br.cesed.si.bd.exercicioJDBC.domain.Endereco;
import br.cesed.si.bd.exercicioJDBC.domain.Livro;
import br.cesed.si.bd.exercicioJDBC.factories.ConexaoFactory;
import br.cesed.si.bd.exercicioJDBC.jdbc.EditoraJDBC;
import br.cesed.si.bd.exercicioJDBC.jdbc.EnderecoJDBC;
import br.cesed.si.bd.exercicioJDBC.jdbc.LivroJDBC;

public class LivroJDBCTeste {

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
		
			Livro livro1 = new Livro(1, "BD2", "Livro de BD2", editora1);
			Livro livro2 = new Livro(2, "Prog", "Livro de Prog", editora2);
			
			LivroJDBC livrojdbc = new LivroJDBC();
			
			livrojdbc.cadastrar(livro1);
			livrojdbc.cadastrar(livro2);
			
			Connection con = ConexaoFactory.getConexao();
			Statement s = con.createStatement();
			s.executeUpdate("delete from livros where id_livro >= 1");
			s.executeUpdate("delete from editoras where id_editora >= 1");
			s.executeUpdate("delete from enderecos where id_endereco >= 1");
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
	
			Livro livro1 = new Livro(1, "BD2", "Livro de BD2", editora1);
			Livro livro2 = new Livro(2, "Prog", "Livro de Prog", editora2);
			
			LivroJDBC livrojdbc = new LivroJDBC();
			
			livrojdbc.cadastrar(livro1);
			livrojdbc.cadastrar(livro2);
			
			livrojdbc.deletar(livro1);
			livrojdbc.deletar(livro2);
			
			Connection con = ConexaoFactory.getConexao();
			Statement s = con.createStatement();
			s.executeUpdate("delete from livros where id_livro >= 1");
			s.executeUpdate("delete from editoras where id_editora >= 1");
			s.executeUpdate("delete from enderecos where id_endereco >= 1");

	}

	@Test
	public void testAtualizar() throws ClassNotFoundException, SQLException {
			Endereco endereco = new Endereco(1, "58400", "PB", "Campina Grande", "Centro", "Maciel Pinheiro", 100);
			EnderecoJDBC enderecojdbc = new EnderecoJDBC();
			enderecojdbc.cadastrar(endereco);
		
			Editora editora1 = new Editora(1, endereco, "editora1", "123.123");
			Editora editora2 = new Editora(2, endereco, "editora2", "112.133");
			EditoraJDBC editorajdbc = new EditoraJDBC();
			editorajdbc.cadastrar(editora1);
			editorajdbc.cadastrar(editora2);
	
			Livro livro1 = new Livro(1, "BD2", "Livro de BD2", editora1);
			Livro livro2 = new Livro(2, "P", "Livro de Prog", editora2);
			
			LivroJDBC livrojdbc = new LivroJDBC();
			
			livrojdbc.cadastrar(livro1);
			livrojdbc.cadastrar(livro2);
			
			livro2.setTitulo("programação");
			
			livrojdbc.atualizar(livro2);
			
			Connection con = ConexaoFactory.getConexao();
			Statement s = con.createStatement();
			s.executeUpdate("delete from livros where id_livro >= 1");
			s.executeUpdate("delete from editoras where id_editora >= 1");
			s.executeUpdate("delete from enderecos where id_endereco >= 1");
	
	}
	
	@Test
	public void testListarTodos() throws ClassNotFoundException, SQLException {

			Endereco endereco = new Endereco(1, "58400", "PB", "Campina Grande", "Centro", "Maciel Pinheiro", 100);
			EnderecoJDBC enderecojdbc = new EnderecoJDBC();
			enderecojdbc.cadastrar(endereco);
		
			Editora editora1 = new Editora(1, endereco, "editora1", "123.123");
			Editora editora2 = new Editora(2, endereco, "editora2", "112.133");
			EditoraJDBC editorajdbc = new EditoraJDBC();
			editorajdbc.cadastrar(editora1);
			editorajdbc.cadastrar(editora2);
		
			Livro livro1 = new Livro(1, "BD2", "Livro de BD2", editora1);
			Livro livro2 = new Livro(2, "Prog", "Livro de Prog", editora2);
			
			LivroJDBC livrojdbc = new LivroJDBC();
			
			livrojdbc.cadastrar(livro1);
			livrojdbc.cadastrar(livro2);
			
			livrojdbc.listarTodos();
			
			Connection con = ConexaoFactory.getConexao();
			Statement s = con.createStatement();
			s.executeUpdate("delete from livros where id_livro >= 1");
			s.executeUpdate("delete from editoras where id_editora >= 1");
			s.executeUpdate("delete from enderecos where id_endereco >= 1");
	}
	
	@Test
	public void testListarPorTitulo() throws ClassNotFoundException, SQLException {
		Endereco endereco = new Endereco(1, "58400", "PB", "Campina Grande", "Centro", "Maciel Pinheiro", 100);
		EnderecoJDBC enderecojdbc = new EnderecoJDBC();
		enderecojdbc.cadastrar(endereco);
	
		Editora editora1 = new Editora(1, endereco, "editora1", "123.123");
		Editora editora2 = new Editora(2, endereco, "editora2", "112.133");
		EditoraJDBC editorajdbc = new EditoraJDBC();
		editorajdbc.cadastrar(editora1);
		editorajdbc.cadastrar(editora2);
	
		Livro livro1 = new Livro(1, "BD2", "Livro de BD2", editora1);
		Livro livro2 = new Livro(2, "Programaçãp", "Livro de Prog", editora2);
		Livro livro3 = new Livro(3, "Tecnologia", "Livro de tec", editora2);
		
		LivroJDBC livrojdbc = new LivroJDBC();
		
		livrojdbc.cadastrar(livro1);
		livrojdbc.cadastrar(livro2);
		livrojdbc.cadastrar(livro3);
		
		livrojdbc.listarPorTitulo("Programação");
		livrojdbc.listarPorTitulo("BD2");
		
		Connection con = ConexaoFactory.getConexao();
		Statement s = con.createStatement();
		s.executeUpdate("delete from livros where id_livro >= 1");
		s.executeUpdate("delete from editoras where id_editora >= 1");
		s.executeUpdate("delete from enderecos where id_endereco >= 1");
	}

}
