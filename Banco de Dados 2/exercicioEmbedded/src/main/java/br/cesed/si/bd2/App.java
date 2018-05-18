package br.cesed.si.bd2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.cesed.si.bd2.entities.Endereco;
import br.cesed.si.bd2.entities.Pessoa;

public class App {

	public static void main(String[] args) {
		Endereco endereco = new Endereco();
		endereco.setRua("Rua Epaminondas Macaxeira");
		endereco.setBairro("Jardim Tavares");
		endereco.setCep("58402-053");
		endereco.setCidade("Campina Grande");
		endereco.setEstado("Paraíba");
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Vinicius Ramos");
		pessoa.setCpf("708689");
		pessoa.setEndereco(endereco);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		session.getTransaction().begin();
		session.persist(pessoa);
		session.getTransaction().commit();
		session.close();
		System.out.println("cadastrou");
	}

}
