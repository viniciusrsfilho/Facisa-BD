package br.cesed.si.bd.atividade.domain;

import java.util.ArrayList;

public class Aluno {
	
	private String nome;
	private long cpf;
	private String matricula;
	private int periodo;
	private ArrayList<Projeto> projetos = new ArrayList<Projeto>();
	
	public Aluno(String nome, long cpf, String matricula, int periodo) {
		this.nome = nome;
		this.cpf = cpf;
		this.matricula = matricula;
		this.periodo = periodo;
	}
	
	public int getPeriodo() {
		return this.periodo;
	}
	
	public void addProjeto(Projeto projeto) {
		this.projetos.add(projeto);
	}
	
	public ArrayList<Projeto> getProjetos() {
		return this.projetos;
	}
	
	public long getCpf() {
		return this.cpf;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", cpf=" + cpf + ", matricula=" + matricula + ", periodo=" + periodo + "]";
	}
	
	
}
