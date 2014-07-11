package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import model.EstoqueMedicamento;
import dao.EstoqueMedicamentoDao;

@ManagedBean
public class ControleEstoqueBean {

	private List<EstoqueMedicamento> medicamentos;
	
	public ControleEstoqueBean(){
		medicamentos = listarMedicamentos();
	}
	
	public List<EstoqueMedicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<EstoqueMedicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}



	public List<EstoqueMedicamento> listarMedicamentos(){
		EstoqueMedicamentoDao estoqueMedicamentoDao = new EstoqueMedicamentoDao();
		return estoqueMedicamentoDao.findAll();
	}
	
}
