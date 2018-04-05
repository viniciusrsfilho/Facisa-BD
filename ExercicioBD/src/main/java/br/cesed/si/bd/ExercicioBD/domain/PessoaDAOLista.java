package br.cesed.si.bd.ExercicioBD.domain;

import java.util.ArrayList;
import java.util.List;

import br.cesed.si.bd.ExercicioBD.interfaces.IPessoa;
import br.cesed.si.bd.ExercicioBD.interfaces.PessoaDAO;

public class PessoaDAOLista implements PessoaDAO {
	
	List<IPessoa> pessoas = new ArrayList<IPessoa>();
	
	public void cadastrar(IPessoa pessoa) {
		pessoas.add(pessoa);
	}

	public List<IPessoa> recuperar() {
		return pessoas;
	}

	public void atualizar(IPessoa pessoa) {
		// TODO Auto-generated method stub
		
	}

	public void deletar(IPessoa pessoa) {
		pessoas.remove(pessoa);
	}

}
