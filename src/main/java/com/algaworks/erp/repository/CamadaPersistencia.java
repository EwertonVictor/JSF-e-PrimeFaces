package com.algaworks.erp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.erp.model.Empresa;
import com.algaworks.erp.model.RamoAtividade;

public class CamadaPersistencia {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlgaWorksPU");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//Declarando os repositorio
		RamoAtividades ramoAtividades = new RamoAtividades(em);
		Empresas empresas = new Empresas(em);
		
		//Buscando as informações no banco
		List<RamoAtividade> listaDeRamoAtividades = ramoAtividades.pesquisar("");
		List<Empresa> listaDeEmpresas = empresas.pesquisar("");
	}
}
