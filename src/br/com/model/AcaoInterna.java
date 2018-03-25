package br.com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the acao_interna database table.
 * 
 */
@Entity
@Table(name="acao_interna")
@NamedQuery(name="AcaoInterna.findAll", query="SELECT a FROM AcaoInterna a")
public class AcaoInterna implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_acao_interna")
	private Long codigoAcaoInterna;

	private String descricao;

	private String sigla;

	private Boolean status;

	//bi-directional many-to-one association to FonteRecurso
	@OneToMany(mappedBy="acaoInterna")
	private List<FonteRecurso> fonteRecursos;

	public AcaoInterna() {
	}

	public Long getCodigoAcaoInterna() {
		return this.codigoAcaoInterna;
	}

	public void setCodigoAcaoInterna(Long codigoAcaoInterna) {
		this.codigoAcaoInterna = codigoAcaoInterna;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<FonteRecurso> getFonteRecursos() {
		return this.fonteRecursos;
	}

	public void setFonteRecursos(List<FonteRecurso> fonteRecursos) {
		this.fonteRecursos = fonteRecursos;
	}

	public FonteRecurso addFonteRecurso(FonteRecurso fonteRecurso) {
		getFonteRecursos().add(fonteRecurso);
		fonteRecurso.setAcaoInterna(this);

		return fonteRecurso;
	}

	public FonteRecurso removeFonteRecurso(FonteRecurso fonteRecurso) {
		getFonteRecursos().remove(fonteRecurso);
		fonteRecurso.setAcaoInterna(null);

		return fonteRecurso;
	}

}