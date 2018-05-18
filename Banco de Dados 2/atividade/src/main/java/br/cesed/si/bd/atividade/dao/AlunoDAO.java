package br.cesed.si.bd.atividade.dao;

import java.util.ArrayList;

import br.cesed.si.bd.atividade.domain.Aluno;
import br.cesed.si.bd.atividade.domain.Projeto;
import br.cesed.si.bd.atividade.interfaces.IDAO;

public class AlunoDAO implements IDAO<Aluno> {
	
	ArrayList<Aluno> alunos = new ArrayList<Aluno>();

	public void create(Aluno aluno) {
		alunos.add(aluno);
	}

	public Aluno retrieve(Aluno aluno) {
		int i = alunos.indexOf(aluno);
		return alunos.get(i);
	}

	public void update(Aluno aluno) {
		alunos.add(aluno);
	}

	public void delete(Aluno aluno) {
		alunos.remove(aluno);
	}
	
	public ArrayList<Projeto> getProjetos(long cpf) throws Exception {
		ArrayList<Projeto> retorno = null;
		boolean achou = false;
		for (Aluno a : alunos) {
			if(a.getCpf() == cpf) {
				achou = true;
				retorno = a.getProjetos();
			}
		}
		if(!achou) {
			throw new Exception("Projeto não encontrado.");
		}
		return retorno;
	}

}
