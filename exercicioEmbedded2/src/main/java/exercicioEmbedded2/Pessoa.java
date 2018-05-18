package exercicioEmbedded2;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private String cpf;
	@Embedded
	private Telefone telefone;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Telefone getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
}