package br.cesed.si.bd.atividade.dao;

import java.util.ArrayList;

import br.cesed.si.bd.atividade.domain.Professor;
import br.cesed.si.bd.atividade.domain.Projeto;
import br.cesed.si.bd.atividade.interfaces.IDAO;

public class ProfessorDAO implements IDAO<Professor> {

	ArrayList<Professor> professores = new ArrayList<Professor>();

	public void create(Professor professor) {
		professores.add(professor);
	}

	public Professor retrieve(Professor professor) {
		int i = professores.indexOf(professor);
		return professores.get(i);
	}

	public void update(Professor professor) {
		professores.add(professor);
	}

	public void delete(Professor professor) {
		professores.remove(professor);
	}
	
	public Projeto getProjeto(long cpf) throws Exception {
		boolean achou = false;
		Projeto retorno = null;
		for (Professor p : professores) {
			if(p.getCpf() == cpf) {
				achou = true;
				retorno = p.getProjeto();
			}
		}
		if(!achou) {
			throw new Exception("Professor não encontrado.");
		}
		return retorno;
	}
}
