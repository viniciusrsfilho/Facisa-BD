package br.cesed.si.bd.atividade.factories;

import br.cesed.si.bd.atividade.domain.Professor;

public class ProfessorFactory {
	
	public static Professor criarInstancia(String nome, long cpf, String matricula) {
		return new Professor(nome, cpf, matricula);
	}

}
