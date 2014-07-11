package dao;

import java.util.List;

import model.Agendamento;
import util.GenericDAO;


public class AgendamentoDao extends GenericDAO<Agendamento> {

	private List<Agendamento> agendamentosRetorno;

	public List<Agendamento> findByanimal(int idAnimal){
		List<Agendamento> agendamentos = findAll();
		for (int i = 0; i < agendamentos.size(); i++) {
			if(agendamentos.get(i).getAnimal().getIdAnimal() == idAnimal){
				agendamentosRetorno.add(agendamentos.get(i));
			}
		}
		
		return agendamentosRetorno;
	}
	    
}
