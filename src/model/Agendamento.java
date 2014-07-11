package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the agendamento database table.
 * 
 */
@Entity
@NamedQuery(name="Agendamento.findAll", query="SELECT a FROM Agendamento a")
public class Agendamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_agendamento")
	private int idAgendamento;

	@Column(name="ds_informacoes")
	private String dsInformacoes;

	@Column(name="dt_data")
	private String dtData;

	@Column(name="vf_pago")
	private byte vfPago;

	@Column(name="vl_hh_inicio")
	private String vlHhInicio;

	//bi-directional many-to-one association to Exame
	@ManyToOne
	@JoinColumn(name="fk_id_exame")
	private Exame exame;

	//bi-directional many-to-one association to Animal
	@ManyToOne
	@JoinColumn(name="fk_id_animal")
	private Animal animal;

	//bi-directional many-to-one association to Veterinario
	@ManyToOne
	@JoinColumn(name="fk_id_veterinario")
	private Veterinario veterinario;

	public Agendamento() {
	}

	public int getIdAgendamento() {
		return this.idAgendamento;
	}

	public void setIdAgendamento(int idAgendamento) {
		this.idAgendamento = idAgendamento;
	}

	public String getDsInformacoes() {
		return this.dsInformacoes;
	}

	public void setDsInformacoes(String dsInformacoes) {
		this.dsInformacoes = dsInformacoes;
	}

	public String getDtData() {
		return this.dtData;
	}

	public void setDtData(String dtData) {
		this.dtData = dtData;
	}

	public byte getVfPago() {
		return this.vfPago;
	}

	public void setVfPago(byte vfPago) {
		this.vfPago = vfPago;
	}

	public String getVlHhInicio() {
		return this.vlHhInicio;
	}

	public void setVlHhInicio(String vlHhInicio) {
		this.vlHhInicio = vlHhInicio;
	}

	public Exame getExame() {
		return this.exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public Animal getAnimal() {
		return this.animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Veterinario getVeterinario() {
		return this.veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

}