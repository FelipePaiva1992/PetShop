package controller;

import javax.faces.bean.ManagedBean;

import dao.FornecedorDao;
import model.Fornecedor;

@ManagedBean
public class CadastroFonecedorBean {
	
	private Fornecedor fornecedor;
	
	public CadastroFonecedorBean(){
		fornecedor = new Fornecedor();
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public void salvarFornecedor(){
		FornecedorDao fornecedorDao = new FornecedorDao();
		fornecedorDao.insert(fornecedor);
	}

}
