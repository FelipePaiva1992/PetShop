package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import model.Cliente;
import model.Grupo;
import model.Usuario;
import dao.ClienteDao;
import dao.GrupoDao;
import dao.UsuarioDao;

@ManagedBean
public class CadastroClienteBean {

	private Cliente cliente;
	private Usuario usuario;

	public CadastroClienteBean(){
		cliente = new Cliente();
		usuario = new Usuario();
	}
		
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
	public String salvarPessoa(){			
		ClienteDao clienteDao = new ClienteDao();
		clienteDao.insert(cliente);	
		
		GrupoDao grupoDao = new GrupoDao();
		Grupo grupo = grupoDao.findById(2);
		
		usuario.setCliente(cliente);
		usuario.setGrupo(grupo);
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.insert(usuario);
		
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Cadastrado.", "Usuario Cadastrado.")); 
		
		return "index";
		
	}
	
}
