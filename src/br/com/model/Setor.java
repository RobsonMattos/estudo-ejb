package br.com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the setor database table.
 * 
 */
@Entity
@Table(name="setor")
@NamedQuery(name="Setor.findAll", query="SELECT s FROM Setor s")
public class Setor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_setor")
	private Long codigoSetor;

	private String descricao;

	private String sigla;

	//bi-directional many-to-one association to MacroAtividade
	@OneToMany(mappedBy="setor")
	private List<MacroAtividade> macroAtividades;

	//bi-directional many-to-one association to Meta
	@OneToMany(mappedBy="setor")
	private List<Meta> metas;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="setor")
	private List<Pedido> pedidos;

	public Setor() {
	}

	public Long getCodigoSetor() {
		return this.codigoSetor;
	}

	public void setCodigoSetor(Long codigoSetor) {
		this.codigoSetor = codigoSetor;
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

	public List<MacroAtividade> getMacroAtividades() {
		return this.macroAtividades;
	}

	public void setMacroAtividades(List<MacroAtividade> macroAtividades) {
		this.macroAtividades = macroAtividades;
	}

	public MacroAtividade addMacroAtividade(MacroAtividade macroAtividade) {
		getMacroAtividades().add(macroAtividade);
		macroAtividade.setSetor(this);

		return macroAtividade;
	}

	public MacroAtividade removeMacroAtividade(MacroAtividade macroAtividade) {
		getMacroAtividades().remove(macroAtividade);
		macroAtividade.setSetor(null);

		return macroAtividade;
	}

	public List<Meta> getMetas() {
		return this.metas;
	}

	public void setMetas(List<Meta> metas) {
		this.metas = metas;
	}

	public Meta addMeta(Meta meta) {
		getMetas().add(meta);
		meta.setSetor(this);

		return meta;
	}

	public Meta removeMeta(Meta meta) {
		getMetas().remove(meta);
		meta.setSetor(null);

		return meta;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setSetor(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setSetor(null);

		return pedido;
	}

}