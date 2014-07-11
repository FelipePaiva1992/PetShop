package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the exame database table.
 * 
 */
@Entity
@NamedQuery(name="Exame.findAll", query="SELECT e FROM Exame e")
public class Exame implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_exame")
	private int idExame;

	@Column(name="nm_exame")
	private String nmExame;

	//bi-directional many-to-one association to Agendamento
	@OneToMany(mappedBy="exame")
	private List<Agendamento> agendamentos;

	public Exame() {
	}

	public int getIdExame() {
		return this.idExame;
	}

	public void setIdExame(int idExame) {
		this.idExame = idExame;
	}

	public String getNmExame() {
		return this.nmExame;
	}

	public void setNmExame(String nmExame) {
		this.nmExame = nmExame;
	}

	public List<Agendamento> getAgendamentos() {
		return this.agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}

	public Agendamento addAgendamento(Agendamento agendamento) {
		getAgendamentos().add(agendamento);
		agendamento.setExame(this);

		return agendamento;
	}

	public Agendamento removeAgendamento(Agendamento agendamento) {
		getAgendamentos().remove(agendamento);
		agendamento.setExame(null);

		return agendamento;
	}

}