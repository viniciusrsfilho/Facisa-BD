package br.cesed.si.bd2.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	private String rua;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
	
	public String getRua() {
		return rua;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
}