package br.cesed.si.bd.ExercicioBD.interfaces;

import java.util.List;

public interface PessoaDAO {
	
	void cadastrar(IPessoa pessoa);
	List<IPessoa> recuperar();
	void atualizar(IPessoa pessoa);
	void deletar(IPessoa pessoa);

}
