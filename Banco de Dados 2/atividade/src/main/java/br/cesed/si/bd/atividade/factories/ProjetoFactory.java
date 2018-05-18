package br.cesed.si.bd.atividade.factories;

import br.cesed.si.bd.atividade.domain.Professor;
import br.cesed.si.bd.atividade.domain.Projeto;

public class ProjetoFactory {

	public static Projeto CriarInstancia(Professor professor) throws Exception {
		return new Projeto(professor);
	}

}
