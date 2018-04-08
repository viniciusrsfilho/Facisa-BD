package br.cesed.si.bd.atividade.domain;

public class Tecnologia {

	private String nome;
	private String tipo;
	private String link;
	private String descricao;
	
	public Tecnologia(String nome, String tipo, String link, String descricao) {
		this.nome = nome;
		this.tipo = tipo;
		this.link = link;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Tecnologia [nome=" + nome + ", tipo=" + tipo + ", link=" + link + ", descricao=" + descricao + "]";
	}
	
	
}
