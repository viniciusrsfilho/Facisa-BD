package br.cesed.si.bd.exercicioJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.AfterClass;
import org.junit.Test;

import br.cesed.si.bd.exercicioJDBC.domain.Autor;
import br.cesed.si.bd.exercicioJDBC.domain.Editora;
import br.cesed.si.bd.exercicioJDBC.domain.Endereco;
import br.cesed.si.bd.exercicioJDBC.domain.Livro;
import br.cesed.si.bd.exercicioJDBC.factories.ConexaoFactory;
import br.cesed.si.bd.exercicioJDBC.jdbc.AutorJDBC;
import br.cesed.si.bd.exercicioJDBC.jdbc.AutorLivroJDBC;
import br.cesed.si.bd.exercicioJDBC.jdbc.EditoraJDBC;
import br.cesed.si.bd.exercicioJDBC.jdbc.EnderecoJDBC;
import br.cesed.si.bd.exercicioJDBC.jdbc.LivroJDBC;

public class AutoresLivrosJDBCTeste {
	
	@Test
	public void testCadastrar() throws ClassNotFoundException, SQLException {
		Autor autor1 = new Autor(1, "Vinicius", "124123", "vini@gmail.com");
		Autor autor2 = new Autor(2, "Adriano", "121223", "adriano@gmail.com");
		
		AutorJDBC autorjdbc = new AutorJDBC();
		autorjdbc.cadastrar(autor1);
		autorjdbc.cadastrar(autor2);
		
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
		
		AutorLivroJDBC al = new AutorLivroJDBC();
		al.cadastrar(1, 1);
	}
	
	@Test
	public void testDeletar() throws ClassNotFoundException, SQLException {
		AutorLivroJDBC al = new AutorLivroJDBC();
		
		al.deletar(1, 1);
	}
	
	@AfterClass
	public static void deletAllAfter() throws ClassNotFoundException, SQLException {
		Connection con = ConexaoFactory.getConexao();
		Statement s = con.createStatement();
		s.executeUpdate("delete from livros where id_livro >= 1");
		s.executeUpdate("delete from editoras where id_editora >= 1");
		s.executeUpdate("delete from enderecos where id_endereco >= 1");
		s.executeUpdate("delete from autores where id_autor >= 1");
	}
}
