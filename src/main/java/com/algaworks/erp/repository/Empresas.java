package com.algaworks.erp.repository;

//Entity Manager = Responsavel por fazer as operações no banco

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.algaworks.erp.model.Empresa;


public class Empresas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public Empresas() {
		
	}
	
	public Empresas(EntityManager manager) {
		this.manager = manager;
	}
	
	//Faz uma pesquisa por id
	public Empresa porId(Long id) {
		return manager.find(Empresa.class, id);
	}	
	
	public List<Empresa> pesquisar(String nome) {
		String jpql = "from Empresa where razaoSocial like :razaoSocial";
		
		TypedQuery<Empresa> query = manager
				.createQuery(jpql, Empresa.class);
		
		query.setParameter("razaoSocial", nome + "%");
		
		return query.getResultList();
	}
//	public Empresa porId(Long id) {
//		return manager.find(Empresa.class, id);
//	}

	public List<Empresa> todas() {
		return manager.createQuery("from Empresa", Empresa.class).getResultList();
	}
	
	//salva a empresa na tabela empresa
	public Empresa guardar(Empresa empresa) {
		return manager.merge(empresa);
	}

	//Deleta uma empresa por id
	public void remover(Empresa empresa) {
		empresa = porId(empresa.getId());
		manager.remove(empresa);
	}
	
}
