package br.cesed.si.bd.exercicioJDBC.interfaces;

import java.sql.SQLException;
import java.util.List;

import br.cesed.si.bd.exercicioJDBC.domain.Editora;

public interface EditoraDAO {

	void cadastrar(Editora editora) throws ClassNotFoundException, SQLException;
	
	void deletar(Editora editora) throws ClassNotFoundException, SQLException;
	
	void atualizar(Editora editora) throws ClassNotFoundException, SQLException;
	
	List<Editora> listarTodos() throws ClassNotFoundException, SQLException;
	
	List<Editora> listarPorNome(String nome) throws ClassNotFoundException, SQLException;
	
	Editora getPorCnpj(String cnpj) throws ClassNotFoundException, SQLException;
}
