package br.cesed.si.bd.ExercicioBD.domain;

public class FabricaDAO {
	
	private static PessoaDAOLista pessoas;
	
	public static void criarPessoaDAOLista() {
		pessoas = new PessoaDAOLista();	
	}
	
	public static PessoaDAOLista getDAO() {
		return pessoas;
	}
}
