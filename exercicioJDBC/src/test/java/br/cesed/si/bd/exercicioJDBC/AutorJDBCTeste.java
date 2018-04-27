package br.cesed.si.bd.exercicioJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.cesed.si.bd.exercicioJDBC.domain.Autor;
import br.cesed.si.bd.exercicioJDBC.factories.ConexaoFactory;
import br.cesed.si.bd.exercicioJDBC.jdbc.AutorJDBC;

public class AutorJDBCTeste {
	
	@Before
	public void deletarObjetos() throws ClassNotFoundException, SQLException {
		Connection con = ConexaoFactory.getConexao();
		
		Statement st = con.createStatement();
		st.executeUpdate("delete from autores where id_autor >= 1");
	}

	@Test
	public void testCadastrar() throws ClassNotFoundException, SQLException {
		Autor autor1 = new Autor(1, "Vinicius", "124123", "vini@gmail.com");
		Autor autor2 = new Autor(2, "Adriano", "121223", "adriano@gmail.com");
		
		AutorJDBC autorjdbc = new AutorJDBC();
		autorjdbc.cadastrar(autor1);
		autorjdbc.cadastrar(autor2);
	}
	
	@Test
	public void testDeletar() throws ClassNotFoundException, SQLException {
		Autor autor1 = new Autor(1, "Vinicius", "124123", "vini@gmail.com");
		Autor autor2 = new Autor(2, "Adriano", "121223", "adriano@gmail.com");
		
		AutorJDBC autorjdbc = new AutorJDBC();
		autorjdbc.cadastrar(autor1);
		autorjdbc.cadastrar(autor2);
		
		autorjdbc.deletar(autor1);
		autorjdbc.deletar(autor2);
	}
	
	@Test
	public void testAtualizar() throws ClassNotFoundException, SQLException {
		Autor autor1 = new Autor(1, "Vini", "124123", "vini@gmail.com");
		Autor autor2 = new Autor(2, "Adriano", "121223", "adri@gmail.com");
		
		AutorJDBC autorjdbc = new AutorJDBC();
		autorjdbc.cadastrar(autor1);
		autorjdbc.cadastrar(autor2);

		autor1.setNome("Vinicius");
		autor2.setEmail("adriano@gmail.com");
		
		autorjdbc.atualizar(autor1);
		autorjdbc.atualizar(autor2);
	}
	
	@Test
	public void testListarTodos() throws ClassNotFoundException, SQLException {
		Autor autor1 = new Autor(1, "Vini", "124123", "vini@gmail.com");
		Autor autor2 = new Autor(2, "Adriano", "121223", "adri@gmail.com");
		
		AutorJDBC autorjdbc = new AutorJDBC();
		autorjdbc.cadastrar(autor1);
		autorjdbc.cadastrar(autor2);
		
		autorjdbc.listarTodos();
	}
	
	@Test
	public void testListarPorNome() throws ClassNotFoundException, SQLException {
		Autor autor1 = new Autor(1, "Vini", "124123", "vini@gmail.com");
		Autor autor2 = new Autor(2, "Adriano", "121223", "adri@gmail.com");
		
		AutorJDBC autorjdbc = new AutorJDBC();
		autorjdbc.cadastrar(autor1);
		autorjdbc.cadastrar(autor2);
		
		autorjdbc.listarPorNome("Vini");
		autorjdbc.listarPorNome("Adriano");
	}
	
	@After
	public void deletarObjetosAfter() throws ClassNotFoundException, SQLException {
		Connection con = ConexaoFactory.getConexao();
		
		Statement st = con.createStatement();
		st.executeUpdate("delete from autores where id_autor >= 1");
	}

}
