package br.com.ztec.projeto_aurora.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the TB_ENDERECO database table.
 * 
 */
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
	private Long id;

	@Column(name="TB_ENDERECO_BAIRRO")
	private String tbEnderecoBairro;

	@Column(name="TB_ENDERECO_CEP")
	private String tbEnderecoCep;

	@Column(name="TB_ENDERECO_CIDADE")
	private String tbEnderecoCidade;

	@Column(name="TB_ENDERECO_COMPLEMENTO")
	private String tbEnderecoComplemento;

	@Temporal(TemporalType.DATE)
	@Column(name="TB_ENDERECO_DATA_CADASTRO")
	private Date tbEnderecoDataCadastro;

	@Column(name="TB_ENDERECO_LOGRADOURO")
	private String tbEnderecoLogradouro;

	@Column(name="TB_ENDERECO_NUMERO")
	private String tbEnderecoNumero;

	@Column(name="TB_ENDERECO_TIPO")
	private String tbEnderecoTipo;

	@Column(name="TB_ENDERECO_UF")
	private String tbEnderecoUf;

	//bi-directional many-to-one association to TbPessoa
	@ManyToOne
	@JoinColumn(name="TB_PESSOA_ID")
	private TbPessoa tbPessoa;

	public TbEndereco() {
	}
}