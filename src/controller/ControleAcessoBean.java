package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import model.VwAcessoUsuario;
import dao.AcessoUsuarioDao;

@ManagedBean
public class ControleAcessoBean {

	private String user;
	private String senha;
	private static String tipoUser;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}	
	
	public String getTipoUser() {
		return tipoUser;
	}
	public void setTipoUser(String tipoUser1) {
		tipoUser = tipoUser1;
	}
	
	
	public String logar(){
		VwAcessoUsuario acessoUsuario = null;
		AcessoUsuarioDao acessoUsuarioDao = new AcessoUsuarioDao(); 
		try {
			acessoUsuario =  acessoUsuarioDao.findByNmUser(user);
			this.setTipoUser(acessoUsuario.getNmGrupo());
		} catch (Exception e) {
			System.out.println("ERRO");
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao Logar.", "Erro ao Logar.")); 
			return null;
		}
		
		if(acessoUsuario.getVlSenha().toString().equals(senha)){
			return "TelaInicial";
		}else{
			System.out.println("ERRO");
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao Logar.", "Erro ao Logar.")); 
		}
		
		 
		return null;
	}
	
	
	
}
