package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import model.Animal;
import model.AnimalTipo;
import model.Cliente;
import dao.AnimalDao;
import dao.AnimalTipoDao;
import dao.ClienteDao;

@ManagedBean
public class CadastroAnimalBean {
	
	private Animal animal;
	private int AnimalTipo;
	private int DonoAnimal;
	
	private List<SelectItem> animalTipos;
	private List<SelectItem> animalDonos;
	
	public CadastroAnimalBean(){
		animal = new Animal();
		animalTipos = listarTiposAnimal();
		animalDonos = listarTiposDonos();
	}
	

	public List<SelectItem> getAnimalTipos() {
		return animalTipos;
	}
	public void setAnimalTipos(List<SelectItem> animalTipos) {
		this.animalTipos = animalTipos;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public List<SelectItem> getAnimalDonos() {
		return animalDonos;
	}
	public void setAnimalDonos(List<SelectItem> animalDonos) {
		this.animalDonos = animalDonos;
	}	
	public int getAnimalTipo() {
		return AnimalTipo;
	}
	public void setAnimalTipo(int animalTipo) {
		AnimalTipo = animalTipo;
	}
	public int getDonoAnimal() {
		return DonoAnimal;
	}
	public void setDonoAnimal(int donoAnimal) {
		DonoAnimal = donoAnimal;
	}


	public void salvarAnimal(){
		AnimalDao animalDao = new AnimalDao();
		ClienteDao clienteDao = new ClienteDao();
		AnimalTipoDao animalTipoDao = new AnimalTipoDao();
		
		Cliente cliente = clienteDao.findById(getDonoAnimal());		
		AnimalTipo tipo = animalTipoDao.findById(getAnimalTipo());
		
		animal.setCliente(cliente);
		animal.setAnimalTipo(tipo);
		
		animalDao.insert(animal);
	}
	
	
	public List<SelectItem> listarTiposAnimal(){
		AnimalTipoDao animalTipoDao = new AnimalTipoDao();
		 List<AnimalTipo> animalTipos = animalTipoDao.findAll();
		 ArrayList<SelectItem> lista = new ArrayList<SelectItem>();
		 
		 for (AnimalTipo tipos : animalTipos) {
	            SelectItem item = new SelectItem(tipos.getIdAnimalTipo(), tipos.getNmAnimal());
	            lista.add(item);
	        }
		 
		 return lista;
	}
	
	public List<SelectItem> listarTiposDonos(){
		ClienteDao clienteDao = new ClienteDao();
		 List<Cliente> clientes = clienteDao.findAll();
		 ArrayList<SelectItem> lista = new ArrayList<SelectItem>();
		 
		 for (Cliente donos : clientes) {
	            SelectItem item = new SelectItem(donos.getIdCliente(), donos.getNmCliente());
	            lista.add(item);
	        }
		 
		 return lista;
	}
	
}
