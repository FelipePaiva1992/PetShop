package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the animal_tipo database table.
 * 
 */
@Entity
@Table(name="animal_tipo")
@NamedQuery(name="AnimalTipo.findAll", query="SELECT a FROM AnimalTipo a")
public class AnimalTipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_animal_tipo")
	private int idAnimalTipo;

	@Column(name="nm_animal")
	private String nmAnimal;

	//bi-directional many-to-one association to Animal
	@OneToMany(mappedBy="animalTipo")
	private List<Animal> animals;

	public AnimalTipo() {
	}

	public int getIdAnimalTipo() {
		return this.idAnimalTipo;
	}

	public void setIdAnimalTipo(int idAnimalTipo) {
		this.idAnimalTipo = idAnimalTipo;
	}

	public String getNmAnimal() {
		return this.nmAnimal;
	}

	public void setNmAnimal(String nmAnimal) {
		this.nmAnimal = nmAnimal;
	}

	public List<Animal> getAnimals() {
		return this.animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public Animal addAnimal(Animal animal) {
		getAnimals().add(animal);
		animal.setAnimalTipo(this);

		return animal;
	}

	public Animal removeAnimal(Animal animal) {
		getAnimals().remove(animal);
		animal.setAnimalTipo(null);

		return animal;
	}

}