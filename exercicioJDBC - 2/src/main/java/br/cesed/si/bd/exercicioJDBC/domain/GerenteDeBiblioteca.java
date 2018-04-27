package br.cesed.si.bd.exercicioJDBC.domain;

import java.sql.SQLException;
import java.util.List;

import br.cesed.si.bd.exercicioJDBC.interfaces.LivroDAO;
import br.cesed.si.bd.exercicioJDBC.jdbc.LivroJDBC;

public class GerenteDeBiblioteca {
	
	private LivroDAO livrojdbc = new LivroJDBC();
	
	public void cadastrar(Livro livro) throws ClassNotFoundException, SQLException {
		livrojdbc.cadastrar(livro);
	}
	
	public void atualizar(Livro livro) throws ClassNotFoundException, SQLException {
		livrojdbc.atualizar(livro);
	}
	
	public void deletar(Livro livro) throws ClassNotFoundException, SQLException {
		livrojdbc.deletar(livro);
	}
	
	public List<Livro> listarTodos() throws ClassNotFoundException, SQLException {
		return livrojdbc.listarTodos();
	}

}
