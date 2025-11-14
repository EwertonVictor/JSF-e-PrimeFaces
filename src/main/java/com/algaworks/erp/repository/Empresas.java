package com.algaworks.erp.repository;

//Entity Manager = Responsavel por fazer as operações no banco

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.algaworks.erp.model.Empresa;


public class Empresas implements Serializable {

	private static final long serialVersionUID = 1L;

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
	
	//pesquisa por empresas | jpql
	public List<Empresa> pesquisar(String nome) {
	
	//consulta com jpql
	//String jpql = "from Empresa where nomeFantasia like :nomeFantasia";
		
		//consulta criteria
		TypedQuery<Empresa> query = manager
				.createQuery("from Empresa where nomeFantasia like :nomeFantasia", Empresa.class);
		
		query.setParameter("nomeFantasia", nome + "%");
		
		return query.getResultList();
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
