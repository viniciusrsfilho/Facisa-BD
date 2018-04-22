package br.cesed.si.bd.exercicioJDBC;

import java.sql.SQLException;

import br.cesed.si.bd.exercicioJDBC.domain.GerenteDeBiblioteca;
import br.cesed.si.bd.exercicioJDBC.domain.Livro;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		try {
			
			Livro l1 = new Livro(1, "Banco de dados", "Vinicius Ramos", "Livro de banco de dados");
			Livro l2 = new Livro(2, "Programação", "Vinicius", "Livro de programação");
			GerenteDeBiblioteca gerente = new GerenteDeBiblioteca();
			gerente.cadastrar(l1);
			gerente.cadastrar(l2);
			
			l2.setAutor("Vinicius Ramos");
			gerente.atualizar(l2);
			gerente.deletar(l2);
			System.out.println(gerente.listarTodos());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
