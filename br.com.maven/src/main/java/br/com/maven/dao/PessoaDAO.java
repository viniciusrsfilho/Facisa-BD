package br.com.maven.dao;

import java.util.List;

import br.com.maven.entities.Pessoa;

public interface PessoaDAO {

	void cadastrar(Pessoa pessoa);
	
	void atualizar(Pessoa pessoa);
	
	void deletar(Pessoa pessoa);
	
	List<Pessoa> listarTodos();
	
	Pessoa getById(int id);
}
