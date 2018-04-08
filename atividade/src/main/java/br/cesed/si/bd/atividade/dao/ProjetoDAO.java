package br.cesed.si.bd.atividade.dao;

import java.util.ArrayList;
import java.util.Date;

import br.cesed.si.bd.atividade.domain.Aluno;
import br.cesed.si.bd.atividade.domain.Professor;
import br.cesed.si.bd.atividade.domain.Projeto;
import br.cesed.si.bd.atividade.interfaces.IDAO;

public class ProjetoDAO implements IDAO<Projeto> {
	
	ArrayList<Projeto> projetos = new ArrayList<Projeto>();

	public void create(Projeto projeto) {
		projetos.add(projeto);
	}

	public Projeto retrieve(Projeto projeto) {
		int i = projetos.indexOf(projeto);
		return projetos.get(i);
	}

	public void update(Projeto projeto) {
		projetos.add(projeto);
	}

	public void delete(Projeto projeto) {
		projetos.remove(projeto);
	}
	
	public ArrayList<Projeto> getProjetos(){
		return this.projetos;
	}
	
	public Projeto getByTitle(String titulo) throws Exception {
		Projeto retorno = null;
		boolean achou = false;
		for (Projeto p : projetos) {
			if(p.getTitulo().equals(titulo)) {
				achou = true;
				retorno = p;
			}
		}
		if(!achou) {
			throw new Exception("Projeto não encontrado.");
		}
		return retorno;
	}
	
	public ArrayList<Aluno> getParticipantes(String titulo) throws Exception {
		ArrayList<Aluno> retorno = null;
		boolean achou = false;
		for (Projeto p : projetos) {
			if(p.getTitulo().equals(titulo)) {
				achou = true;
				retorno = p.getAlunos();
			}
		}
		if(!achou) {
			throw new Exception("Projeto não encontrado.");
		}
		return retorno;
	}
	
	public Projeto getByProfessor(Professor professor) throws Exception {
		Projeto retorno = null;
		boolean achou = false;
		for (Projeto p : projetos) {
			if(p.getProfessorResponsavel() == professor) {
				achou = true;
				retorno = p;
			}
		}
		if(!achou) {
			throw new Exception("Projeto não encontrado");
		}
		return retorno;
	}
	
	public Projeto getByDataInicio(Date date) throws Exception {
		Projeto retorno = null;
		boolean achou = false;
		for (Projeto p : projetos) {
			if(p.getDataInicio() == date) {
				achou = true;
				retorno = p;
			}
		}
		if(!achou) {
			throw new Exception("Projeto não encontrado.");
		}
		return retorno;
	}
	
	public Projeto getByDataConclusao(Date date) throws Exception {
		Projeto retorno = null;
		boolean achou = false;
		for (Projeto p : projetos) {
			if(p.getDataConclusao() == date) {
				achou = true;
				retorno = p;
			}
		}
		if(!achou) {
			throw new Exception("Projeto não encontrado.");
		}
		return retorno;
	}
	


}
