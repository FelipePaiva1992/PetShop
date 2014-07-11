package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the vw_acesso_usuario database table.
 * 
 */
@Entity
@Table(name="vw_acesso_usuario")
@NamedQuery(name="VwAcessoUsuario.findAll", query="SELECT v FROM VwAcessoUsuario v")
public class VwAcessoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	
	
	@Column(name="nm_cliente")
	private String nmCliente;

	@Column(name="nm_funcionario")
	private String nmFuncionario;

	@Column(name="nm_grupo")
	private String nmGrupo;

	@Id
	@Column(name="nm_usuario")
	private String nmUsuario;

	@Column(name="vl_senha")
	private String vlSenha;

	public VwAcessoUsuario() {
	}

	public String getNmCliente() {
		return this.nmCliente;
	}

	public void setNmCliente(String nmCliente) {
		this.nmCliente = nmCliente;
	}

	public String getNmFuncionario() {
		return this.nmFuncionario;
	}

	public void setNmFuncionario(String nmFuncionario) {
		this.nmFuncionario = nmFuncionario;
	}

	public String getNmGrupo() {
		return this.nmGrupo;
	}

	public void setNmGrupo(String nmGrupo) {
		this.nmGrupo = nmGrupo;
	}

	public String getNmUsuario() {
		return this.nmUsuario;
	}

	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}

	public String getVlSenha() {
		return this.vlSenha;
	}

	public void setVlSenha(String vlSenha) {
		this.vlSenha = vlSenha;
	}

}