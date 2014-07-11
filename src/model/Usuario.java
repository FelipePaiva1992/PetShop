package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nm_usuario")
	private String nmUsuario;

	@Column(name="vl_senha")
	private String vlSenha;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne
	@JoinColumn(name="fk_id_funcionario")
	private Funcionario funcionario;

	//bi-directional many-to-one association to Grupo
	@ManyToOne
	@JoinColumn(name="fk_id_grupo")
	private Grupo grupo;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="fk_id_cliente")
	private Cliente cliente;

	public Usuario() {
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

	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}