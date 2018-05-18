package br.cesed.si.bd.atividade.domain;

public class Professor {
	
	private String nome;
	private long cpf;
	private String matricula;
	private Projeto projeto;
	
	public Professor(String nome, long cpf, String matricula) {
		this.nome = nome;
		this.cpf = cpf;
		this.matricula = matricula;
	}
	
	public Projeto getProjeto() {
		return this.projeto;
	}
	
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
	public long getCpf() {
		return this.cpf;
	}

	@Override
	public String toString() {
		return "Professor [nome=" + nome + ", cpf=" + cpf + ", matricula=" + matricula + "]";
	}
	
	
}
