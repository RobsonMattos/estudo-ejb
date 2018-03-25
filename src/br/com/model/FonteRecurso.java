package br.com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fonte_recurso database table.
 * 
 */
@Entity
@Table(name="fonte_recurso")
@NamedQuery(name="FonteRecurso.findAll", query="SELECT f FROM FonteRecurso f")
public class FonteRecurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_fonte_recurso")
	private Long codigoFonteRecurso;

	private String tipofonte;

	//bi-directional many-to-many association to Exercicio
	@ManyToMany(mappedBy="fonteRecursos1")
	private List<Exercicio> exercicios1;

	//bi-directional many-to-one association to AcaoInterna
	@ManyToOne
	private AcaoInterna acaoInterna;

	//bi-directional many-to-many association to Exercicio
	@ManyToMany
	@JoinTable(
		name="fonte_recurso_exercicio"
		, joinColumns={
			@JoinColumn(name="fonterecurso_codigo_fonte_recurso")
			}
		, inverseJoinColumns={
			@JoinColumn(name="exercicio_ano")
			}
		)
	private List<Exercicio> exercicios2;

	//bi-directional many-to-many association to MacroAtividade
	@ManyToMany
	@JoinTable(
		name="fonte_recurso_macro_atividade"
		, joinColumns={
			@JoinColumn(name="fonterecurso_codigo_fonte_recurso")
			}
		, inverseJoinColumns={
			@JoinColumn(name="macroatividades_codigo_macro_atividade")
			}
		)
	private List<MacroAtividade> macroAtividades1;

	//bi-directional many-to-many association to MacroAtividade
	@ManyToMany(mappedBy="fonteRecursos2")
	private List<MacroAtividade> macroAtividades2;

	public FonteRecurso() {
	}

	public Long getCodigoFonteRecurso() {
		return this.codigoFonteRecurso;
	}

	public void setCodigoFonteRecurso(Long codigoFonteRecurso) {
		this.codigoFonteRecurso = codigoFonteRecurso;
	}

	public String getTipofonte() {
		return this.tipofonte;
	}

	public void setTipofonte(String tipofonte) {
		this.tipofonte = tipofonte;
	}

	public List<Exercicio> getExercicios1() {
		return this.exercicios1;
	}

	public void setExercicios1(List<Exercicio> exercicios1) {
		this.exercicios1 = exercicios1;
	}

	public AcaoInterna getAcaoInterna() {
		return this.acaoInterna;
	}

	public void setAcaoInterna(AcaoInterna acaoInterna) {
		this.acaoInterna = acaoInterna;
	}

	public List<Exercicio> getExercicios2() {
		return this.exercicios2;
	}

	public void setExercicios2(List<Exercicio> exercicios2) {
		this.exercicios2 = exercicios2;
	}

	public List<MacroAtividade> getMacroAtividades1() {
		return this.macroAtividades1;
	}

	public void setMacroAtividades1(List<MacroAtividade> macroAtividades1) {
		this.macroAtividades1 = macroAtividades1;
	}

	public List<MacroAtividade> getMacroAtividades2() {
		return this.macroAtividades2;
	}

	public void setMacroAtividades2(List<MacroAtividade> macroAtividades2) {
		this.macroAtividades2 = macroAtividades2;
	}

}