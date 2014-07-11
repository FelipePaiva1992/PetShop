package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import model.AnimalTipo;
import dao.AnimalTipoDao;

@ManagedBean
public class CadastroTipoAnimalBean {

	private AnimalTipo animaltipo;
	private List<AnimalTipo> animaltipos;
	
	public CadastroTipoAnimalBean(){
		animaltipo = new AnimalTipo();
	}	
	

	public AnimalTipo getAnimaltipo() {
		return animaltipo;
	}



	public void setAnimaltipo(AnimalTipo animaltipo) {
		this.animaltipo = animaltipo;
	}



	public List<AnimalTipo> getAnimaltipos() {
		return animaltipos;
	}



	public void setAnimaltipos(List<AnimalTipo> animaltipos) {
		this.animaltipos = animaltipos;
	}
	

	public void salvarAnimalTipo(){		
		AnimalTipoDao animalTipoDao = new AnimalTipoDao();
		animalTipoDao.insert(animaltipo);
	}






}
