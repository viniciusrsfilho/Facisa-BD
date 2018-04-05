package br.cesed.si.bd.ExercicioBD;

import br.cesed.si.bd.ExercicioBD.domain.FabricaDAO;
import br.cesed.si.bd.ExercicioBD.domain.FabricaPessoa;
import br.cesed.si.bd.ExercicioBD.enums.TipoPessoa;

public class App {
	
	public static void main(String[] args) {
		
		FabricaDAO.criarPessoaDAOLista();
				
		FabricaDAO.getDAO().cadastrar(FabricaPessoa.criarPessoa(TipoPessoa.FUNCIONARIO));
		FabricaDAO.getDAO().cadastrar(FabricaPessoa.criarPessoa(TipoPessoa.COORDENADOR));
		FabricaDAO.getDAO().cadastrar(FabricaPessoa.criarPessoa(TipoPessoa.PROFESSOR));
		FabricaDAO.getDAO().cadastrar(FabricaPessoa.criarPessoa(TipoPessoa.ALUNO));
		FabricaDAO.getDAO().cadastrar(FabricaPessoa.criarPessoa(TipoPessoa.ALUNO));
		
		System.out.println(FabricaDAO.getDAO().recuperar());
		
		
	}
}
