package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estoque_medicamento database table.
 * 
 */
@Entity
@Table(name="estoque_medicamento")
@NamedQuery(name="EstoqueMedicamento.findAll", query="SELECT e FROM EstoqueMedicamento e")
public class EstoqueMedicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cod_medicamento")
	private int codMedicamento;

	@Column(name="nm_medicamento")
	private String nmMedicamento;

	@Column(name="nu_medicamento")
	private int nuMedicamento;

	@Column(name="vl_descricao")
	private String vlDescricao;

	@Column(name="vl_posologia")
	private String vlPosologia;

	//bi-directional many-to-one association to Fornecedor
	@ManyToOne
	@JoinColumn(name="fk_id_fornecedor")
	private Fornecedor fornecedor;

	public EstoqueMedicamento() {
	}

	public int getCodMedicamento() {
		return this.codMedicamento;
	}

	public void setCodMedicamento(int codMedicamento) {
		this.codMedicamento = codMedicamento;
	}

	public String getNmMedicamento() {
		return this.nmMedicamento;
	}

	public void setNmMedicamento(String nmMedicamento) {
		this.nmMedicamento = nmMedicamento;
	}

	public int getNuMedicamento() {
		return this.nuMedicamento;
	}

	public void setNuMedicamento(int nuMedicamento) {
		this.nuMedicamento = nuMedicamento;
	}

	public String getVlDescricao() {
		return this.vlDescricao;
	}

	public void setVlDescricao(String vlDescricao) {
		this.vlDescricao = vlDescricao;
	}

	public String getVlPosologia() {
		return this.vlPosologia;
	}

	public void setVlPosologia(String vlPosologia) {
		this.vlPosologia = vlPosologia;
	}

	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

}