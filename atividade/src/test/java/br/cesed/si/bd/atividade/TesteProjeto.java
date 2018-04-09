package br.cesed.si.bd.atividade;

import static org.junit.Assert.fail;

import org.junit.Test;

import br.cesed.si.bd.atividade.domain.Aluno;
import br.cesed.si.bd.atividade.domain.Professor;
import br.cesed.si.bd.atividade.domain.Projeto;
import br.cesed.si.bd.atividade.domain.Tecnologia;
import br.cesed.si.bd.atividade.factories.AlunoFactory;
import br.cesed.si.bd.atividade.factories.ProfessorFactory;
import br.cesed.si.bd.atividade.factories.ProjetoFactory;
import br.cesed.si.bd.atividade.factories.TecnologiaFactory;

public class TesteProjeto {
	
	@Test
	public void testCriaProjeto() {
		try {
			Professor professorResponsavel = ProfessorFactory.criarInstancia("Adriano", 123123, "101308");
			Projeto projeto = ProjetoFactory.CriarInstancia(professorResponsavel);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testAddAluno() {
		try {
			Professor professorResponsavel = ProfessorFactory.criarInstancia("Adriano", 123123, "101308");
			Projeto projeto = ProjetoFactory.CriarInstancia(professorResponsavel);
			Aluno aluno1 = AlunoFactory.criarInstancia("Vinicius", 123123123, "161308", 4);
			
			projeto.addAluno(aluno1);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		
	}
	
	@Test
	public void testAddTecnologia() {
		try {
			Professor professorResponsavel = ProfessorFactory.criarInstancia("Adriano", 123123, "101308");
			Projeto projeto = ProjetoFactory.CriarInstancia(professorResponsavel);
			Tecnologia tecnologia = TecnologiaFactory.criarInstanca("java", "java", "oracle.com/java", "java");
			projeto.addTecnologia(tecnologia);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
