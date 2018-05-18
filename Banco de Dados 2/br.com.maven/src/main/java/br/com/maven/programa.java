package br.com.maven;

import br.com.maven.connection.PessoaPostgreSQL;
import br.com.maven.entities.Pessoa;

public class programa {

	public static void main(String[] args) {

		// Instanciando um cliente
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("099912");
		pessoa.setNome("teste");
		
		PessoaPostgreSQL pp = new PessoaPostgreSQL();
		pp.cadastrar(pessoa);

		System.out.println("Finalizando o cadastro.");

	}

}
