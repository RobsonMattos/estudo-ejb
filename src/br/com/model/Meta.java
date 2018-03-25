package br.com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the meta database table.
 * 
 */
@Entity
@NamedQuery(name="Meta.findAll", query="SELECT m FROM Meta m")
public class Meta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_meta")
	private Long codigoMeta;

	private String consequencia;

	@Column(name="data_fim")
	private Timestamp dataFim;

	@Column(name="data_inicio")
	private Timestamp dataInicio;

	private String descricao;

	@Column(name="informacoes_complementares")
	private String informacoesComplementares;

	private String justificativa;

	@Column(name="prazo_meta")
	private Integer prazoMeta;

	@Column(name="prioridade_meta")
	private Integer prioridadeMeta;

	private Integer status;

	@Column(name="tipo_meta")
	private Integer tipoMeta;

	@Column(name="valor_solicitado")
	private BigDecimal valorSolicitado;

	//bi-directional many-to-one association to Acao
	@OneToMany(mappedBy="meta")
	private List<Acao> acaos;

	//bi-directional many-to-one association to MacroAtividade
	@ManyToOne
	@JoinColumn(name="codigo_macro_atividade")
	private MacroAtividade macroAtividade;

	//bi-directional many-to-one association to Setor
	@ManyToOne
	@JoinColumn(name="codigo_setor")
	private Setor setor;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="meta1")
	private List<Pedido> pedidos;

	//bi-directional one-to-one association to Pedido
	@OneToOne(mappedBy="meta2")
	private Pedido pedido;

	public Meta() {
	}

	public Long getCodigoMeta() {
		return this.codigoMeta;
	}

	public void setCodigoMeta(Long codigoMeta) {
		this.codigoMeta = codigoMeta;
	}

	public String getConsequencia() {
		return this.consequencia;
	}

	public void setConsequencia(String consequencia) {
		this.consequencia = consequencia;
	}

	public Timestamp getDataFim() {
		return this.dataFim;
	}

	public void setDataFim(Timestamp dataFim) {
		this.dataFim = dataFim;
	}

	public Timestamp getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Timestamp dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getInformacoesComplementares() {
		return this.informacoesComplementares;
	}

	public void setInformacoesComplementares(String informacoesComplementares) {
		this.informacoesComplementares = informacoesComplementares;
	}

	public String getJustificativa() {
		return this.justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public Integer getPrazoMeta() {
		return this.prazoMeta;
	}

	public void setPrazoMeta(Integer prazoMeta) {
		this.prazoMeta = prazoMeta;
	}

	public Integer getPrioridadeMeta() {
		return this.prioridadeMeta;
	}

	public void setPrioridadeMeta(Integer prioridadeMeta) {
		this.prioridadeMeta = prioridadeMeta;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTipoMeta() {
		return this.tipoMeta;
	}

	public void setTipoMeta(Integer tipoMeta) {
		this.tipoMeta = tipoMeta;
	}

	public BigDecimal getValorSolicitado() {
		return this.valorSolicitado;
	}

	public void setValorSolicitado(BigDecimal valorSolicitado) {
		this.valorSolicitado = valorSolicitado;
	}

	public List<Acao> getAcaos() {
		return this.acaos;
	}

	public void setAcaos(List<Acao> acaos) {
		this.acaos = acaos;
	}

	public Acao addAcao(Acao acao) {
		getAcaos().add(acao);
		acao.setMeta(this);

		return acao;
	}

	public Acao removeAcao(Acao acao) {
		getAcaos().remove(acao);
		acao.setMeta(null);

		return acao;
	}

	public MacroAtividade getMacroAtividade() {
		return this.macroAtividade;
	}

	public void setMacroAtividade(MacroAtividade macroAtividade) {
		this.macroAtividade = macroAtividade;
	}

	public Setor getSetor() {
		return this.setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setMeta1(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setMeta1(null);

		return pedido;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}