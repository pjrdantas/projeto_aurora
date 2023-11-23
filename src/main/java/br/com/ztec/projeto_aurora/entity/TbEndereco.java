package br.com.ztec.projeto_aurora.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@Table(name="TB_ENDERECO")
public class TbEndereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="TB_ENDERECO_BAIRRO", nullable=false, length=255)
	private String tbEnderecoBairro;

	@Column(name="TB_ENDERECO_CEP", nullable=false, length=255)
	private String tbEnderecoCep;

	@Column(name="TB_ENDERECO_CIDADE", nullable=false, length=255)
	private String tbEnderecoCidade;

	@Column(name="TB_ENDERECO_COMPLEMENTO", length=255)
	private String tbEnderecoComplemento;

	@Temporal(TemporalType.DATE)
	@Column(name="TB_ENDERECO_DATA_CADASTRO", nullable=false)
	private Date tbEnderecoDataCadastro;

	@Column(name="TB_ENDERECO_LOGRADOURO", nullable=false, length=255)
	private String tbEnderecoLogradouro;

	@Column(name="TB_ENDERECO_NUMERO", length=255)
	private String tbEnderecoNumero;

	@Column(name="TB_ENDERECO_TIPO", nullable=false, length=255)
	private String tbEnderecoTipo;

	@Column(name="TB_ENDERECO_UF", nullable=false, length=255)
	private String tbEnderecoUf;

	//bi-directional many-to-one association to TbPessoa
	@ManyToOne
	@JoinColumn(name="TB_PESSOA_ID")
	private TbPessoa tbPessoa;

	public TbEndereco() {
	}

}