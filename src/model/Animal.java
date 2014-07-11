package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the animal database table.
 * 
 */
@Entity
@NamedQuery(name="Animal.findAll", query="SELECT a FROM Animal a")
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_animal")
	private int idAnimal;

	@Column(name="nm_animal")
	private String nmAnimal;

	//bi-directional many-to-one association to Agendamento
	@OneToMany(mappedBy="animal")
	private List<Agendamento> agendamentos;

	//bi-directional many-to-one association to AnimalTipo
	@ManyToOne
	@JoinColumn(name="fk_id_animal_tipo")
	private AnimalTipo animalTipo;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="fk_id_cliente")
	private Cliente cliente;

	public Animal() {
	}

	public int getIdAnimal() {
		return this.idAnimal;
	}

	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}

	public String getNmAnimal() {
		return this.nmAnimal;
	}

	public void setNmAnimal(String nmAnimal) {
		this.nmAnimal = nmAnimal;
	}

	public List<Agendamento> getAgendamentos() {
		return this.agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}

	public Agendamento addAgendamento(Agendamento agendamento) {
		getAgendamentos().add(agendamento);
		agendamento.setAnimal(this);

		return agendamento;
	}

	public Agendamento removeAgendamento(Agendamento agendamento) {
		getAgendamentos().remove(agendamento);
		agendamento.setAnimal(null);

		return agendamento;
	}

	public AnimalTipo getAnimalTipo() {
		return this.animalTipo;
	}

	public void setAnimalTipo(AnimalTipo animalTipo) {
		this.animalTipo = animalTipo;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}