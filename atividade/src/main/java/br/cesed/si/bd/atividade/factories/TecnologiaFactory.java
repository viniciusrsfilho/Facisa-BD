package br.cesed.si.bd.atividade.factories;

import br.cesed.si.bd.atividade.domain.Tecnologia;

public class TecnologiaFactory {

	public static Tecnologia criarInstanca(String nome, String tipo, String link, String descricao) {
		return new Tecnologia(nome, tipo, link, descricao);
	}
}
