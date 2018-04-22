package br.cesed.si.bd.exercicioJDBC;

import java.sql.SQLException;

import org.junit.Test;

import br.cesed.si.bd.exercicioJDBC.domain.Livro;
import br.cesed.si.bd.exercicioJDBC.domain.LivroJDBC;

public class LivroJDBCTeste {

	@Test
	public void testCadastrar() throws ClassNotFoundException, SQLException {
		
			Livro livro1 = new Livro(1, "BD2", "Vinicius Ramos", "Livro de BD2");
			Livro livro2 = new Livro(2, "Prog", "Vinicius", "Livro de Prog");
			
			LivroJDBC livrojdbc = new LivroJDBC();
			
			livrojdbc.cadastrar(livro1);
			livrojdbc.cadastrar(livro2);
	}
	
	@Test
	public void testDeletar() throws ClassNotFoundException, SQLException {
			Livro livro1 = new Livro(1, "BD2", "Vinicius Ramos", "Livro de BD2");
			Livro livro2 = new Livro(2, "Prog", "Vinicius", "Livro de Prog");
			
			LivroJDBC livrojdbc = new LivroJDBC();
			
			livrojdbc.cadastrar(livro1);
			livrojdbc.cadastrar(livro2);
			
			livrojdbc.deletar(livro1);
			livrojdbc.deletar(livro2);

	}
	
	@Test
	public void testAtualizar() throws ClassNotFoundException, SQLException {
			Livro livro1 = new Livro(1, "BD2", "Vinicius Ramos", "Livro de BD2");
			Livro livro2 = new Livro(2, "Prog", "Vinicius", "Livro de Prog");
			
			LivroJDBC livrojdbc = new LivroJDBC();
			
			livrojdbc.cadastrar(livro1);
			livrojdbc.cadastrar(livro2);
			
			livro2.setAutor("Vinicius Ramos");
			
			livrojdbc.atualizar(livro2);
	
	}
	
	@Test
	public void testListarTodos() throws ClassNotFoundException, SQLException {

			Livro livro1 = new Livro(1, "BD2", "Vinicius Ramos", "Livro de BD2");
			Livro livro2 = new Livro(2, "Prog", "Vinicius", "Livro de Prog");
			
			LivroJDBC livrojdbc = new LivroJDBC();
			
			livrojdbc.cadastrar(livro1);
			livrojdbc.cadastrar(livro2);
			
			livrojdbc.listarTodos();
	}

}
