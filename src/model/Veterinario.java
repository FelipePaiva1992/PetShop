package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the veterinario database table.
 * 
 */
@Entity
@NamedQuery(name="Veterinario.findAll", query="SELECT v FROM Veterinario v")
public class Veterinario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_veterinario")
	private int idVeterinario;

	@Column(name="nm_veterinario")
	private String nmVeterinario;

	@Column(name="vl_crmv")
	private String vlCrmv;

	@Column(name="vl_telefone")
	private String vlTelefone;

	//bi-directional many-to-one association to Agendamento
	@OneToMany(mappedBy="veterinario")
	private List<Agendamento> agendamentos;

	//bi-directional many-to-one association to Especialidade
	@ManyToOne
	@JoinColumn(name="fk_id_especialidade")
	private Especialidade especialidade;

	public Veterinario() {
	}

	public int getIdVeterinario() {
		return this.idVeterinario;
	}

	public void setIdVeterinario(int idVeterinario) {
		this.idVeterinario = idVeterinario;
	}

	public String getNmVeterinario() {
		return this.nmVeterinario;
	}

	public void setNmVeterinario(String nmVeterinario) {
		this.nmVeterinario = nmVeterinario;
	}

	public String getVlCrmv() {
		return this.vlCrmv;
	}

	public void setVlCrmv(String vlCrmv) {
		this.vlCrmv = vlCrmv;
	}

	public String getVlTelefone() {
		return this.vlTelefone;
	}

	public void setVlTelefone(String vlTelefone) {
		this.vlTelefone = vlTelefone;
	}

	public List<Agendamento> getAgendamentos() {
		return this.agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}

	public Agendamento addAgendamento(Agendamento agendamento) {
		getAgendamentos().add(agendamento);
		agendamento.setVeterinario(this);

		return agendamento;
	}

	public Agendamento removeAgendamento(Agendamento agendamento) {
		getAgendamentos().remove(agendamento);
		agendamento.setVeterinario(null);

		return agendamento;
	}

	public Especialidade getEspecialidade() {
		return this.especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

}