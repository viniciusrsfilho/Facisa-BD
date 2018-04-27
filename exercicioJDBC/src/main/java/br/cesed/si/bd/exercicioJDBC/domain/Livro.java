package br.cesed.si.bd.exercicioJDBC.domain;

public class Livro {
	
	private int idLivro;
	private String titulo;
	private String descricao;
	private Editora editora;
	
	public Livro(int id, String titulo, String descricao, Editora editora) {
		this.idLivro = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.editora = editora;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int id) {
		this.idLivro = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	
	
}
