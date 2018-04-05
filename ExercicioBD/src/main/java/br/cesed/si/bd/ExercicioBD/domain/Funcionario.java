package br.cesed.si.bd.ExercicioBD.domain;

import br.cesed.si.bd.ExercicioBD.interfaces.IPessoa;

public class Funcionario implements IPessoa {
	
	private double salario;
	
	public Funcionario(double salario) {
		this.salario = salario;
	}
	
	public double getSalario() {
		return 0;
	}

	@Override
	public String toString() {
		return "Funcionario [salario=" + salario + "]";
	}

}
