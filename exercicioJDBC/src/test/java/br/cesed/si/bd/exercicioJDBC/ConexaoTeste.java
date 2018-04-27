package br.cesed.si.bd.exercicioJDBC;

import java.sql.SQLException;

import org.junit.Test;

import br.cesed.si.bd.exercicioJDBC.factories.ConexaoFactory;

public class ConexaoTeste {

	@Test
	public void testConexao() throws ClassNotFoundException, SQLException {
		ConexaoFactory.getConexao();
	}

}
