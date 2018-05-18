package exercicioEmbedded2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class PessoaTeste {

	static SessionFactory factory;
	
	@BeforeClass
	public static void instanciarSession() {
		factory = new Configuration().configure().buildSessionFactory();
	}
	
	@Test
	public void testeCadastroDePessoa() {
		Telefone telefone = new Telefone();
		telefone.setNumero("83 988612591");
		telefone.setTipo("celular");
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Vinicius");
		pessoa.setCpf("708689");
		pessoa.setTelefone(telefone);
		
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.persist(pessoa);
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testeObtencaoDePessoaPorId() {
		Session session = factory.openSession();
		session.getTransaction().begin();
		Pessoa pessoa = session.get(Pessoa.class, 11);
		Assert.assertTrue(pessoa.getCpf().equals("708689"));
		session.close();
	}
}
