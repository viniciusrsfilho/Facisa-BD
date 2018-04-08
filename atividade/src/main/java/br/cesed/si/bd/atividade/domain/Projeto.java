package br.cesed.si.bd.atividade.domain;

import java.util.ArrayList;
import java.util.Date;

public class Projeto {

	private Professor professorResponsavel;
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	private Date dataInicio;
	private Date dataConclusao;
	private String areaRelacionada;
	private String titulo;
	private String descricao;
	private String referencias;
	private ArrayList<Tecnologia> tecnologias = new ArrayList<Tecnologia>();
	
	public Projeto(Professor professorResponsavel) throws Exception {
		if(professorResponsavel.getProjeto() == null) {
			this.professorResponsavel = professorResponsavel;
			professorResponsavel.setProjeto(this);
		} else {
			throw new Exception("O professor já possui um projeto.");
		}
	}
	
	public void addAluno(Aluno aluno) throws Exception {
		if(aluno.getPeriodo() == 4) {
			this.alunos.add(aluno);
			aluno.addProjeto(this);
		} else {		
			throw new Exception("O aluno deve ser do quarto período.");
		}
	}

	public Professor getProfessorResponsavel() {
		return professorResponsavel;
	}

	public void setProfessorResponsavel(Professor professorResponsavel) {
		this.professorResponsavel = professorResponsavel;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public String getAreaRelacionada() {
		return areaRelacionada;
	}

	public void setAreaRelacionada(String areaRelacionada) {
		this.areaRelacionada = areaRelacionada;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getReferencias() {
		return referencias;
	}

	public void setReferencias(String referencias) {
		this.referencias = referencias;
	}

	public ArrayList<Tecnologia> getTecnologias() {
		return tecnologias;
	}

	public void setTecnologias(ArrayList<Tecnologia> tecnologias) {
		this.tecnologias = tecnologias;
	}

	@Override
	public String toString() {
		return "Projeto [professorResponsavel=" + professorResponsavel + ", alunos=" + alunos + ", dataInicio="
				+ dataInicio + ", dataConclusao=" + dataConclusao + ", areaRelacionada=" + areaRelacionada + ", titulo="
				+ titulo + ", descricao=" + descricao + ", referencias=" + referencias + ", tecnologias=" + tecnologias
				+ "]";
	}
	
	
}
