package br.cesed.si.bd.exercicioJDBC.domain;

public class Editora {
	
	private int idEditora;
	private Endereco endereco;
	private String nome;
	private String cnpj;
	
	public Editora(int idEditora, Endereco endereco, String nome, String cnpj) {
		this.idEditora = idEditora;
		this.endereco = endereco;
		this.nome = nome;
		this.cnpj = cnpj;
	}

	public int getIdEditora() {
		return idEditora;
	}

	public void setIdEditora(int idEditora) {
		this.idEditora = idEditora;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
}	