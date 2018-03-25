package br.com.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.dao.SetorDao;
import br.com.model.Setor;

@Named
@RequestScoped
public class SetorBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String setor = "Teste de tela";

	@Inject
	private SetorDao setorDao;
	
	private List<Setor> setores = new ArrayList<Setor>();
	
	@PostConstruct
	public void init() {
		setores = setorDao.obter();
		System.out.println("TEste");
	}

	public List<Setor> getSetores() {
		return setores;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}
	
}
