package br.cesed.si.bd.atividade.factories;

import br.cesed.si.bd.atividade.domain.Aluno;

public class AlunoFactory {
	
	public static Aluno criarInstancia(String nome, long cpf, String matricula, int periodo) {
		return new Aluno(nome, cpf, matricula, periodo);
	}

}
