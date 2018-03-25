package br.com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_pedido")
	private Long codigoPedido;

	private String descricao;

	private String justificativa;

	@Column(name="valor_solicitado")
	private BigDecimal valorSolicitado;

	//bi-directional many-to-one association to Meta
	@ManyToOne
	@JoinColumn(name="codigo_meta")
	private Meta meta1;

	//bi-directional one-to-one association to Meta
	@OneToOne
	@JoinColumn(name="codigo_pedido")
	private Meta meta2;

	//bi-directional many-to-one association to Setor
	@ManyToOne
	@JoinColumn(name="codigo_setor")
	private Setor setor;

	public Pedido() {
	}

	public Long getCodigoPedido() {
		return this.codigoPedido;
	}

	public void setCodigoPedido(Long codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getJustificativa() {
		return this.justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public BigDecimal getValorSolicitado() {
		return this.valorSolicitado;
	}

	public void setValorSolicitado(BigDecimal valorSolicitado) {
		this.valorSolicitado = valorSolicitado;
	}

	public Meta getMeta1() {
		return this.meta1;
	}

	public void setMeta1(Meta meta1) {
		this.meta1 = meta1;
	}

	public Meta getMeta2() {
		return this.meta2;
	}

	public void setMeta2(Meta meta2) {
		this.meta2 = meta2;
	}

	public Setor getSetor() {
		return this.setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

}