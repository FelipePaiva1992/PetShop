package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import model.EstoqueMedicamento;
import model.Fornecedor;
import dao.EstoqueMedicamentoDao;
import dao.FornecedorDao;

@ManagedBean
public class CadastroMedicamentosBean {
	
	private EstoqueMedicamento estoqueMedicamento;
	private List<SelectItem> fornecedores;
	private int intFornecedor;
	
	public CadastroMedicamentosBean(){
		estoqueMedicamento = new EstoqueMedicamento();
		fornecedores = listarFornecedores();
	}

	public EstoqueMedicamento getEstoqueMedicamento() {
		return estoqueMedicamento;
	}

	public void setEstoqueMedicamento(EstoqueMedicamento estoqueMedicamento) {
		this.estoqueMedicamento = estoqueMedicamento;
	}

	public List<SelectItem> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<SelectItem> fornecedores) {
		this.fornecedores = fornecedores;
	}	
	
	public int getIntFornecedor() {
		return intFornecedor;
	}

	public void setIntFornecedor(int intFornecedor) {
		this.intFornecedor = intFornecedor;
	}

	
	
	public List<SelectItem> listarFornecedores(){
		FornecedorDao fornecedorDao = new FornecedorDao();
		 List<Fornecedor> fornecedores = fornecedorDao.findAll();
		 ArrayList<SelectItem> lista = new ArrayList<SelectItem>();
		 
		 for (Fornecedor fornecedor : fornecedores) {
	            SelectItem item = new SelectItem(fornecedor.getIdFornecedor(), fornecedor.getNmFornecedor());
	            lista.add(item);
	        }
		 
		 return lista;
	}
	
	public void salvarMedicamento(){
		FornecedorDao fornecedorDao = new FornecedorDao();
		Fornecedor fornecedor = fornecedorDao.findById(intFornecedor);
		
		estoqueMedicamento.setFornecedor(fornecedor);
		EstoqueMedicamentoDao estoqueMedicamentoDao = new EstoqueMedicamentoDao();
		estoqueMedicamentoDao.insert(estoqueMedicamento);
	}
	
	

}
