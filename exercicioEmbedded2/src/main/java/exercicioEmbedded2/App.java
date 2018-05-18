package exercicioEmbedded2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		Telefone telefone = new Telefone();
		telefone.setNumero("83 988612591");
		telefone.setTipo("celular");
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Vinicius");
		pessoa.setCpf("708689");
		pessoa.setTelefone(telefone);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.persist(pessoa);
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Cadastrou!");
	}
}
