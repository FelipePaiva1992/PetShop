package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import model.Agendamento;
import dao.AgendamentoDao;

@ManagedBean
public class ControleAgendamentoBean {

	private List<Agendamento> agendamentos;
	
	public ControleAgendamentoBean(){
		agendamentos = listarAgendamentos();
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}
	
	
	public List<Agendamento> listarAgendamentos(){
		AgendamentoDao agendamentoDao = new AgendamentoDao();
		return agendamentoDao.findAll();
	}
	
}
