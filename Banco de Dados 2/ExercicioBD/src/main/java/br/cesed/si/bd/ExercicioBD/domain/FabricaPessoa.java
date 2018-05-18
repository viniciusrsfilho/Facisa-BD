package br.cesed.si.bd.ExercicioBD.domain;

import br.cesed.si.bd.ExercicioBD.enums.TipoPessoa;
import br.cesed.si.bd.ExercicioBD.interfaces.IPessoa;

public class FabricaPessoa {
	
	public static IPessoa criarPessoa(TipoPessoa pessoa) {
		if(pessoa.equals(TipoPessoa.FUNCIONARIO)) {
			return new Funcionario(2500);
		} if(pessoa.equals(TipoPessoa.COORDENADOR)) {
			return new Coordenador(8000);
		} if(pessoa.equals(TipoPessoa.PROFESSOR)) {
			return new Professor(4000);
		} return new Aluno(0);
	}
}
