package br.com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the macro_atividade database table.
 * 
 */
@Entity
@Table(name="macro_atividade")
@NamedQuery(name="MacroAtividade.findAll", query="SELECT m FROM MacroAtividade m")
public class MacroAtividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_macro_atividade")
	private Long codigoMacroAtividade;

	private String nome;

	//bi-directional many-to-many association to FonteRecurso
	@ManyToMany(mappedBy="macroAtividades1")
	private List<FonteRecurso> fonteRecursos1;

	//bi-directional many-to-one association to Setor
	@ManyToOne
	@JoinColumn(name="codigo_setor")
	private Setor setor;

	//bi-directional many-to-many association to FonteRecurso
	@ManyToMany
	@JoinTable(
		name="macro_atividade_fonte_recurso"
		, joinColumns={
			@JoinColumn(name="macroatividade_codigo_macro_atividade")
			}
		, inverseJoinColumns={
			@JoinColumn(name="fontesrecurso_codigo_fonte_recurso")
			}
		)
	private List<FonteRecurso> fonteRecursos2;

	//bi-directional many-to-one association to Meta
	@OneToMany(mappedBy="macroAtividade")
	private List<Meta> metas;

	public MacroAtividade() {
	}

	public Long getCodigoMacroAtividade() {
		return this.codigoMacroAtividade;
	}

	public void setCodigoMacroAtividade(Long codigoMacroAtividade) {
		this.codigoMacroAtividade = codigoMacroAtividade;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<FonteRecurso> getFonteRecursos1() {
		return this.fonteRecursos1;
	}

	public void setFonteRecursos1(List<FonteRecurso> fonteRecursos1) {
		this.fonteRecursos1 = fonteRecursos1;
	}

	public Setor getSetor() {
		return this.setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public List<FonteRecurso> getFonteRecursos2() {
		return this.fonteRecursos2;
	}

	public void setFonteRecursos2(List<FonteRecurso> fonteRecursos2) {
		this.fonteRecursos2 = fonteRecursos2;
	}

	public List<Meta> getMetas() {
		return this.metas;
	}

	public void setMetas(List<Meta> metas) {
		this.metas = metas;
	}

	public Meta addMeta(Meta meta) {
		getMetas().add(meta);
		meta.setMacroAtividade(this);

		return meta;
	}

	public Meta removeMeta(Meta meta) {
		getMetas().remove(meta);
		meta.setMacroAtividade(null);

		return meta;
	}

}