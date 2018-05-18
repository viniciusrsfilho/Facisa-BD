package br.cesed.si.bd.exercicioJDBC.domain;

public class Autor {
	
	private int id_autor;
	private String nome;
	private String cpf;
	private String email;
	
	public Autor(int id_autor, String nome, String cpf, String email) {
		this.id_autor = id_autor;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}

	public int getId_autor() {
		return id_autor;
	}

	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
