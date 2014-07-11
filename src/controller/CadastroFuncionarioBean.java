package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import model.Funcionario;
import dao.FuncionarioDao;

@ManagedBean
public class CadastroFuncionarioBean {

	private String nomeFuncionario;	
	
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	
	

	public void salvarFuncionario(){
		Funcionario funcionario = new Funcionario();
		funcionario.setNmFuncionario(this.getNomeFuncionario());
		
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		funcionarioDao.insert(funcionario);
	}
	
	public void alterarFuncionario(){
		
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = funcionarioDao.findById(1);
		funcionario.setNmFuncionario("Alterado");
		funcionarioDao.update(funcionario);
	}
	
	public void listarFuncionarios(){		
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		List<Funcionario> funcionarios = funcionarioDao.findAll();
		
		for(Funcionario funcionario: funcionarios){
			System.out.println(funcionario.getNmFuncionario());
		}
	}
	
}
