package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fornecedor database table.
 * 
 */
@Entity
@NamedQuery(name="Fornecedor.findAll", query="SELECT f FROM Fornecedor f")
public class Fornecedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_fornecedor")
	private int idFornecedor;

	@Column(name="nm_fornecedor")
	private String nmFornecedor;

	@Column(name="vl_endereco_fornecedor")
	private String vlEnderecoFornecedor;

	//bi-directional many-to-one association to EstoqueMedicamento
	@OneToMany(mappedBy="fornecedor")
	private List<EstoqueMedicamento> estoqueMedicamentos;

	public Fornecedor() {
	}

	public int getIdFornecedor() {
		return this.idFornecedor;
	}

	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getNmFornecedor() {
		return this.nmFornecedor;
	}

	public void setNmFornecedor(String nmFornecedor) {
		this.nmFornecedor = nmFornecedor;
	}

	public String getVlEnderecoFornecedor() {
		return this.vlEnderecoFornecedor;
	}

	public void setVlEnderecoFornecedor(String vlEnderecoFornecedor) {
		this.vlEnderecoFornecedor = vlEnderecoFornecedor;
	}

	public List<EstoqueMedicamento> getEstoqueMedicamentos() {
		return this.estoqueMedicamentos;
	}

	public void setEstoqueMedicamentos(List<EstoqueMedicamento> estoqueMedicamentos) {
		this.estoqueMedicamentos = estoqueMedicamentos;
	}

	public EstoqueMedicamento addEstoqueMedicamento(EstoqueMedicamento estoqueMedicamento) {
		getEstoqueMedicamentos().add(estoqueMedicamento);
		estoqueMedicamento.setFornecedor(this);

		return estoqueMedicamento;
	}

	public EstoqueMedicamento removeEstoqueMedicamento(EstoqueMedicamento estoqueMedicamento) {
		getEstoqueMedicamentos().remove(estoqueMedicamento);
		estoqueMedicamento.setFornecedor(null);

		return estoqueMedicamento;
	}

}