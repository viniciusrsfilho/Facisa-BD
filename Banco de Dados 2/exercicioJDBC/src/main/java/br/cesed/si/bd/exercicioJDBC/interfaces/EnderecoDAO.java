package br.cesed.si.bd.exercicioJDBC.interfaces;

import java.sql.SQLException;
import java.util.List;

import br.cesed.si.bd.exercicioJDBC.domain.Endereco;

public interface EnderecoDAO {
	
	public void cadastrar(Endereco endereco) throws ClassNotFoundException, SQLException;
	
	public void deletar(Endereco endereco) throws ClassNotFoundException, SQLException;
	
	public void atualizar(Endereco endereco) throws ClassNotFoundException, SQLException;
	
	public List<Endereco> listarTodos() throws ClassNotFoundException, SQLException;

}
