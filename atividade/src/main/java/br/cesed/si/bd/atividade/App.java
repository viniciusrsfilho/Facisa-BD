package br.cesed.si.bd.atividade;

import javax.swing.JOptionPane;

import br.cesed.si.bd.atividade.dao.AlunoDAO;
import br.cesed.si.bd.atividade.dao.ProfessorDAO;
import br.cesed.si.bd.atividade.dao.ProjetoDAO;
import br.cesed.si.bd.atividade.domain.Aluno;
import br.cesed.si.bd.atividade.domain.Professor;
import br.cesed.si.bd.atividade.domain.Projeto;
import br.cesed.si.bd.atividade.factories.AlunoFactory;
import br.cesed.si.bd.atividade.factories.ProfessorFactory;
import br.cesed.si.bd.atividade.factories.ProjetoFactory;

public class App {
	
	public static void main(String[] args) throws Exception {
		
		ProjetoDAO projetodao = new ProjetoDAO();
		ProfessorDAO professordao = new ProfessorDAO();
		AlunoDAO alunodao = new AlunoDAO();
		int resposta;
		
		do {
			String respostaStr = JOptionPane.showInputDialog("Bem-vindo, O que você deseja?"
		
				+ "\n 1) Criar projeto \n 2) Adicionar aluno no projeto \n 3) Listar projetos "
				+ "\n 4) Buscar projeto por titulo \n 5) Buscar projeto de um professor \n 6) Buscar projeto de um aluno"
				+ "\n 7) Buscar participantes de um projeto \n 8) Sair");
			resposta = Integer.parseInt(respostaStr);
		
		if(resposta == 1) {
				String cpf1s = JOptionPane.showInputDialog("Digite seu CPF: ");
				long cpf1 = Integer.parseInt(cpf1s);
				
				Professor professor1 = ProfessorFactory.criarInstancia(JOptionPane.showInputDialog("Digite seu nome: "), cpf1,
						JOptionPane.showInputDialog("Digite sua matricula: "));
				professordao.create(professor1);
				Projeto projeto = ProjetoFactory.CriarInstancia(professor1);
				projetodao.create(projeto);
				projeto.setTitulo(JOptionPane.showInputDialog("Digite o titulo do projeto: "));
				JOptionPane.showMessageDialog(null, projeto + " Projeto criado com sucesso");
				
		} if(resposta == 2) {
			String titulo = JOptionPane.showInputDialog("Digite o titulo do projeto: ");
			Projeto p1 = projetodao.getByTitle(titulo);
			String cpf1s = JOptionPane.showInputDialog("Digite o CPF do aluno: ");
			long cpf1 = Integer.parseInt(cpf1s);
			String periodos = JOptionPane.showInputDialog("Digite o período do aluno: ");
			int periodo = Integer.parseInt(periodos);
			Aluno aluno = AlunoFactory.criarInstancia(JOptionPane.showInputDialog("Digite o nome do aluno: "), 
					cpf1, JOptionPane.showInputDialog("Digite a matricula do aluno: "), periodo);
			alunodao.create(aluno);
			p1.addAluno(aluno);
			JOptionPane.showMessageDialog(null, aluno + " adicionado com sucesso");
			
		} if(resposta == 3) {
			JOptionPane.showMessageDialog(null, projetodao.getProjetos());
			
		} if(resposta == 4){
			Projeto p = projetodao.getByTitle(JOptionPane.showInputDialog("Digite o titulo do projeto: "));
			JOptionPane.showMessageDialog(null, p);
			
		} if(resposta == 5) {
			String cpf1s = JOptionPane.showInputDialog("Digite o CPF do professor: ");
			long cpf1 = Integer.parseInt(cpf1s);
			JOptionPane.showMessageDialog(null, professordao.getProjeto(cpf1));
			
		} if(resposta == 6) {
			String cpf1s = JOptionPane.showInputDialog("Digite o CPF do aluno: ");
			long cpf1 = Integer.parseInt(cpf1s);
			JOptionPane.showMessageDialog(null, alunodao.getProjetos(cpf1));
		} if(resposta == 7) {
			String titulo = JOptionPane.showInputDialog("Digite o titulo do projeto:");
			JOptionPane.showMessageDialog(null, projetodao.getParticipantes(titulo));
		}
		
		} while(resposta != 8);
	   
	}
}
