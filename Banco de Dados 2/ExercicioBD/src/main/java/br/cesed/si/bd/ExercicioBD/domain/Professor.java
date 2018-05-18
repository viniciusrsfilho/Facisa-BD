package br.cesed.si.bd.ExercicioBD.domain;

import br.cesed.si.bd.ExercicioBD.interfaces.IPessoa;

public class Professor implements IPessoa {
	
	private double salario;
	
	public Professor(double salario) {
		this.salario = salario;
	}
	
	public double getSalario() {
		return salario;
	}

	@Override
	public String toString() {
		return "Professor [salario=" + salario + "]";
	}

	
}
