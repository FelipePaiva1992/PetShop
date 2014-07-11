package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import model.Agendamento;
import dao.AgendamentoDao;

@ManagedBean
public class ControleHistoricoBean {

	private List<Agendamento> agendamentos;
	private int intAnimal;
	
	public ControleHistoricoBean(){
		agendamentos = listarAgendamentos();
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}
	
	public int getIntAnimal() {
		return intAnimal;
	}

	public void setIntAnimal(int intAnimal) {
		this.intAnimal = intAnimal;
	}

	
	
	public List<Agendamento> listarAgendamentos(){
		AgendamentoDao agendamentoDao = new AgendamentoDao();
		return agendamentoDao.findByanimal(intAnimal);
	}
	
}
