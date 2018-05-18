package br.cesed.si.bd.atividade;

import static org.junit.Assert.fail;

import org.junit.Test;

import br.cesed.si.bd.atividade.dao.AlunoDAO;
import br.cesed.si.bd.atividade.dao.ProfessorDAO;
import br.cesed.si.bd.atividade.dao.ProjetoDAO;
import br.cesed.si.bd.atividade.domain.Aluno;
import br.cesed.si.bd.atividade.domain.Professor;
import br.cesed.si.bd.atividade.domain.Projeto;
import br.cesed.si.bd.atividade.factories.AlunoFactory;
import br.cesed.si.bd.atividade.factories.ProfessorFactory;
import br.cesed.si.bd.atividade.factories.ProjetoFactory;

public class TesteProjetoDAO {

	@Test
	public void test() {
		try {
			Professor professor = ProfessorFactory.criarInstancia("Adriano", 123, "101308");
			Projeto projeto = ProjetoFactory.CriarInstancia(professor);
			Aluno aluno = AlunoFactory.criarInstancia("Vinicius", 121, "161", 4);
			ProjetoDAO projetodao = new ProjetoDAO();
			projetodao.create(projeto);
			projeto.setTitulo("Maratona");
			projeto.addAluno(aluno);
			projetodao.getByTitle("Maratona");
			projetodao.getParticipantes("Maratona");
			AlunoDAO alunodao = new AlunoDAO();
			alunodao.create(aluno);
			alunodao.getProjetos(121);
			ProfessorDAO professordao = new ProfessorDAO();
			professordao.create(professor);
			professordao.getProjeto(123);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
