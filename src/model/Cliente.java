package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_cliente")
	private int idCliente;

	@Column(name="nm_cliente")
	private String nmCliente;

	@Column(name="vl_cpf_cliente")
	private String vlCpfCliente;

	@Column(name="vl_endereco")
	private String vlEndereco;

	@Column(name="vl_telefone")
	private String vlTelefone;

	//bi-directional many-to-one association to Animal
	@OneToMany(mappedBy="cliente")
	private List<Animal> animals;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="cliente")
	private List<Usuario> usuarios;

	public Cliente() {
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNmCliente() {
		return this.nmCliente;
	}

	public void setNmCliente(String nmCliente) {
		this.nmCliente = nmCliente;
	}

	public String getVlCpfCliente() {
		return this.vlCpfCliente;
	}

	public void setVlCpfCliente(String vlCpfCliente) {
		this.vlCpfCliente = vlCpfCliente;
	}

	public String getVlEndereco() {
		return this.vlEndereco;
	}

	public void setVlEndereco(String vlEndereco) {
		this.vlEndereco = vlEndereco;
	}

	public String getVlTelefone() {
		return this.vlTelefone;
	}

	public void setVlTelefone(String vlTelefone) {
		this.vlTelefone = vlTelefone;
	}

	public List<Animal> getAnimals() {
		return this.animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public Animal addAnimal(Animal animal) {
		getAnimals().add(animal);
		animal.setCliente(this);

		return animal;
	}

	public Animal removeAnimal(Animal animal) {
		getAnimals().remove(animal);
		animal.setCliente(null);

		return animal;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setCliente(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setCliente(null);

		return usuario;
	}

}