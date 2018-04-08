package br.cesed.si.bd.atividade.dao;

import java.util.ArrayList;

import br.cesed.si.bd.atividade.domain.Tecnologia;
import br.cesed.si.bd.atividade.interfaces.IDAO;

public class TecnologiaDAO implements IDAO<Tecnologia> {
	
	ArrayList<Tecnologia> tecnologias = new ArrayList<Tecnologia>();

	public void create(Tecnologia tecnologia) {
		tecnologias.add(tecnologia);
	}

	public Tecnologia retrieve(Tecnologia tecnologia) {
		int i = tecnologias.indexOf(tecnologia);
		return tecnologias.get(i);
	}

	public void update(Tecnologia tecnologia) {
		tecnologias.add(tecnologia);
	}

	public void delete(Tecnologia tecnologia) {
		tecnologias.remove(tecnologia);
	}

}
