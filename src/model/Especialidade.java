package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the especialidade database table.
 * 
 */
@Entity
@NamedQuery(name="Especialidade.findAll", query="SELECT e FROM Especialidade e")
public class Especialidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_especialidade")
	private int idEspecialidade;

	@Column(name="nm_veterinario")
	private String nmVeterinario;

	//bi-directional many-to-one association to Veterinario
	@OneToMany(mappedBy="especialidade")
	private List<Veterinario> veterinarios;

	public Especialidade() {
	}

	public int getIdEspecialidade() {
		return this.idEspecialidade;
	}

	public void setIdEspecialidade(int idEspecialidade) {
		this.idEspecialidade = idEspecialidade;
	}

	public String getNmVeterinario() {
		return this.nmVeterinario;
	}

	public void setNmVeterinario(String nmVeterinario) {
		this.nmVeterinario = nmVeterinario;
	}

	public List<Veterinario> getVeterinarios() {
		return this.veterinarios;
	}

	public void setVeterinarios(List<Veterinario> veterinarios) {
		this.veterinarios = veterinarios;
	}

	public Veterinario addVeterinario(Veterinario veterinario) {
		getVeterinarios().add(veterinario);
		veterinario.setEspecialidade(this);

		return veterinario;
	}

	public Veterinario removeVeterinario(Veterinario veterinario) {
		getVeterinarios().remove(veterinario);
		veterinario.setEspecialidade(null);

		return veterinario;
	}

}