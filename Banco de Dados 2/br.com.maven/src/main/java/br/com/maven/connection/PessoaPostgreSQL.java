package br.com.maven.connection;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.maven.dao.PessoaDAO;
import br.com.maven.entities.Pessoa;
import br.com.maven.factories.SessionFactoryUtil;

public class PessoaPostgreSQL implements PessoaDAO{

	SessionFactory factory = SessionFactoryUtil.createSessionFactory();
	
	public void cadastrar(Pessoa pessoa) {		
		Session session = factory.openSession();
		
		session.getTransaction().begin();
		session.persist(pessoa);
		session.getTransaction().commit();
		
		session.close();
	}

	public void atualizar(Pessoa pessoa) {
		Session session = factory.openSession();
		
		session.getTransaction().begin();
		session.update(pessoa);;
		session.getTransaction().commit();
		
		session.close();
	}

	public void deletar(Pessoa pessoa) {
		Session session = factory.openSession();
		
		session.getTransaction().begin();
		session.delete(pessoa);
		session.getTransaction().commit();
		
		session.close();
	}

	public List<Pessoa> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public Pessoa getById(int id) {
		Session session = factory.openSession();
		session.getTransaction().begin();
		Pessoa pessoa = session.get(Pessoa.class, 11);
		session.close();
		return pessoa;
	}

}
