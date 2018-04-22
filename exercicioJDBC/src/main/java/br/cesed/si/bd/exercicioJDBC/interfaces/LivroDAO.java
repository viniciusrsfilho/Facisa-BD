package br.cesed.si.bd.exercicioJDBC.interfaces;

import java.sql.SQLException;
import java.util.List;

import br.cesed.si.bd.exercicioJDBC.domain.Livro;

public interface LivroDAO {
	
	void cadastrar(Livro livro) throws ClassNotFoundException, SQLException;
	
	void deletar(Livro livro) throws ClassNotFoundException, SQLException;
	
	void atualizar(Livro livro) throws ClassNotFoundException, SQLException;
	
	List<Livro> listarTodos() throws ClassNotFoundException, SQLException;

}
