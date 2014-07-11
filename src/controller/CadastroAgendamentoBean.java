package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import model.Agendamento;
import model.Animal;
import model.Cliente;
import model.Exame;
import model.Veterinario;
import dao.AgendamentoDao;
import dao.AnimalDao;
import dao.ClienteDao;
import dao.ExameDao;
import dao.VeterinarioDao;

@ManagedBean
public class CadastroAgendamentoBean {
	
	private Animal animal;
	private Cliente cliente;
	private Veterinario veterinario;
	private Agendamento agendamento;
	private Exame exame;
	
	private List<SelectItem> animalDonos;
	private List<SelectItem> animais;
	private List<SelectItem> veterinarios;
	private List<SelectItem> exames;
	
	private int intDonoAnimal;
	private int intAnimal;
	private int intVeterinario;
	private int intExame;
	
	public CadastroAgendamentoBean(){
		animal = new Animal();
		cliente = new Cliente();
		veterinario = new Veterinario();
		agendamento = new Agendamento();
		animalDonos = listarDonos();
		animais = listarAnimais();
		veterinarios = listarVeterinarios();
		exames = listarExames();
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<SelectItem> getAnimalDonos() {
		return animalDonos;
	}

	public void setAnimalDonos(List<SelectItem> animalDonos) {
		this.animalDonos = animalDonos;
	}

	public int getDonoAnimal() {
		return intDonoAnimal;
	}

	public void setDonoAnimal(int donoAnimal) {
		intDonoAnimal = donoAnimal;
	}

	public List<SelectItem> getAnimais() {
		return animais;
	}

	public void setAnimais(List<SelectItem> animais) {
		this.animais = animais;
	}

	public int getIntDonoAnimal() {
		return intDonoAnimal;
	}

	public void setIntDonoAnimal(int intDonoAnimal) {
		this.intDonoAnimal = intDonoAnimal;
	}

	public int getIntAnimal() {
		return intAnimal;
	}

	public void setIntAnimal(int intAnimal) {
		this.intAnimal = intAnimal;
	}
	
	public List<SelectItem> getVeterinarios() {
		return veterinarios;
	}

	public void setVeterinarios(List<SelectItem> veterinarios) {
		this.veterinarios = veterinarios;
	}

	public int getIntVeterinario() {
		return intVeterinario;
	}

	public void setIntVeterinario(int intVeterinario) {
		this.intVeterinario = intVeterinario;
	}
		
	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public List<SelectItem> getExames() {
		return exames;
	}

	public void setExames(List<SelectItem> exames) {
		this.exames = exames;
	}

	public int getIntExame() {
		return intExame;
	}

	public void setIntExame(int intExame) {
		this.intExame = intExame;
	}
	
	

	public String salvarAgendamento(){
		VeterinarioDao veterinarioDao = new VeterinarioDao();
		Veterinario veterinario = veterinarioDao.findById(intVeterinario);
		AnimalDao animalDao = new AnimalDao();
		Animal animal = animalDao.findById(intAnimal);
		ClienteDao clienteDao = new ClienteDao();
		Cliente cliente = clienteDao.findById(intDonoAnimal);
		ExameDao exameDao = new ExameDao();
		Exame exame = exameDao.findById(intExame);	
		
		agendamento.setAnimal(animal);
		agendamento.setExame(exame);
		agendamento.setVeterinario(veterinario);
		
		AgendamentoDao agendamentoDao = new AgendamentoDao();
		agendamentoDao.insert(agendamento);
		return "TelaInicial";
	}

	public List<SelectItem> listarDonos(){
		ClienteDao clienteDao = new ClienteDao();
		 List<Cliente> clientes = clienteDao.findAll();
		 ArrayList<SelectItem> lista = new ArrayList<SelectItem>();
		 
		 for (Cliente donos : clientes) {
	            SelectItem item = new SelectItem(donos.getIdCliente(), donos.getNmCliente());
	            lista.add(item);
	        }
		 
		 return lista;
	}
	
	public List<SelectItem> listarAnimais(){
		AnimalDao animalDao = new AnimalDao();
		 List<Animal> animais = animalDao.findAll();
		 ArrayList<SelectItem> lista = new ArrayList<SelectItem>();
		 
		 for (Animal animal : animais) {
	            SelectItem item = new SelectItem(animal.getIdAnimal(), animal.getNmAnimal());
	            lista.add(item);
	        }
		 
		 return lista;
	}
	
	public List<SelectItem> listarVeterinarios(){
		VeterinarioDao veterinarioDao = new VeterinarioDao();
		 List<Veterinario> veterinarios = veterinarioDao.findAll();
		 ArrayList<SelectItem> lista = new ArrayList<SelectItem>();
		 
		 for (Veterinario veterinario : veterinarios) {
	            SelectItem item = new SelectItem(veterinario.getIdVeterinario(), veterinario.getNmVeterinario());
	            lista.add(item);
	        }
		 
		 return lista;
	}
	
	public List<SelectItem> listarExames(){
		ExameDao exameDao = new ExameDao();
		 List<Exame> exames = exameDao.findAll();
		 ArrayList<SelectItem> lista = new ArrayList<SelectItem>();
		 
		 for (Exame exame : exames) {
	            SelectItem item = new SelectItem(exame.getIdExame(), exame.getNmExame());
	            lista.add(item);
	        }
		 
		 return lista;
	}
}
