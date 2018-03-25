package br.com.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the acao database table.
 * 
 */
@Entity
@NamedQuery(name="Acao.findAll", query="SELECT a FROM Acao a")
public class Acao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long codigo;

	private String descricao;

	//bi-directional many-to-one association to Meta
	@ManyToOne
	private Meta meta;

	public Acao() {
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Meta getMeta() {
		return this.meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

}