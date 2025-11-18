package controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.algaworks.erp.model.Empresa;
import com.algaworks.erp.model.TipoEmpresa;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Empresa empresa = new Empresa();
	
	public void salvar() {
		System.out.println("Razão social: " + empresa.getRazaoSocial()
				+ "\nNome Fantasia: " + empresa.getNomeFantasia()
				+ "\nTipo: " + empresa.getTipo()
				+ "\nCNPJ: " + empresa.getCnpj()
				+ "\nData Fundação: " + empresa.getDataFundacao()
				+ "\nFaturamento: " + empresa.getFaturamento());
	}
	
//	Informa que é uma navegação "Explícita" > ?faces-redirect=true
	public String ajuda() {
		return "AjudaGestaoEmpresa?faces-redirect=true";
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public TipoEmpresa[] getTiposEmpresa() {
		return TipoEmpresa.values();
	}
}
