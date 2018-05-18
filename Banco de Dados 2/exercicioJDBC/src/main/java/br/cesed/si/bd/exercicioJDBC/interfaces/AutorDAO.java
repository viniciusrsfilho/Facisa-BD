package br.cesed.si.bd.exercicioJDBC.interfaces;

import java.sql.SQLException;
import java.util.List;

import br.cesed.si.bd.exercicioJDBC.domain.Autor;

public interface AutorDAO {
	
	void cadastrar(Autor autor) throws ClassNotFoundException, SQLException;
	
	void deletar(Autor autor) throws ClassNotFoundException, SQLException;
	
	void atualizar(Autor autor) throws ClassNotFoundException, SQLException;
	
	List<Autor> listarTodos() throws ClassNotFoundException, SQLException;
	
	List<Autor> listarPorNome(String nome) throws ClassNotFoundException, SQLException;

}
