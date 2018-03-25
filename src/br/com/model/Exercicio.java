package br.com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the exercicio database table.
 * 
 */
@Entity
@NamedQuery(name="Exercicio.findAll", query="SELECT e FROM Exercicio e")
public class Exercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer ano;

	private Timestamp datafim;

	private Timestamp datainicio;

	private Integer statusexercicio;

	//bi-directional many-to-many association to FonteRecurso
	@ManyToMany
	@JoinTable(
		name="exercicio_fonte_recurso"
		, joinColumns={
			@JoinColumn(name="exercicio_ano")
			}
		, inverseJoinColumns={
			@JoinColumn(name="fontesrecurso_codigo_fonte_recurso")
			}
		)
	private List<FonteRecurso> fonteRecursos1;

	//bi-directional many-to-many association to FonteRecurso
	@ManyToMany(mappedBy="exercicios2")
	private List<FonteRecurso> fonteRecursos2;

	public Exercicio() {
	}

	public Integer getAno() {
		return this.ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Timestamp getDatafim() {
		return this.datafim;
	}

	public void setDatafim(Timestamp datafim) {
		this.datafim = datafim;
	}

	public Timestamp getDatainicio() {
		return this.datainicio;
	}

	public void setDatainicio(Timestamp datainicio) {
		this.datainicio = datainicio;
	}

	public Integer getStatusexercicio() {
		return this.statusexercicio;
	}

	public void setStatusexercicio(Integer statusexercicio) {
		this.statusexercicio = statusexercicio;
	}

	public List<FonteRecurso> getFonteRecursos1() {
		return this.fonteRecursos1;
	}

	public void setFonteRecursos1(List<FonteRecurso> fonteRecursos1) {
		this.fonteRecursos1 = fonteRecursos1;
	}

	public List<FonteRecurso> getFonteRecursos2() {
		return this.fonteRecursos2;
	}

	public void setFonteRecursos2(List<FonteRecurso> fonteRecursos2) {
		this.fonteRecursos2 = fonteRecursos2;
	}

}