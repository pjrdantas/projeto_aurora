package br.com.ztec.projeto_aurora.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the TB_PESSOA database table.
 * 
 */
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@Table(name="TB_PESSOA")
public class TbPessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="TB_PESSOA_ATIVO")
	private BigDecimal tbPessoaAtivo;

	@Temporal(TemporalType.DATE)
	@Column(name="TB_PESSOA_DATA_CADASTRO")
	private Date tbPessoaDataCadastro;

	@Temporal(TemporalType.DATE)
	@Column(name="TB_PESSOA_DATA_NASC_ABERTURA")
	private Date tbPessoaDataNascAbertura;

	@Column(name="TB_PESSOA_ISENTO")
	private BigDecimal tbPessoaIsento;

	@Column(name="TB_PESSOA_NOME_RAZAO_SOCIAL")
	private String tbPessoaNomeRazaoSocial;

	@Column(name="TB_PESSOA_PESS_EXP_POLIT")
	private BigDecimal tbPessoaPessExpPolit;

	@Column(name="TB_PESSOA_PF_PJ")
	private String tbPessoaPfPj;

	@Column(name="TB_PESSOA_SEXO")
	private String tbPessoaSexo;

	//bi-directional many-to-one association to TbContato
	@OneToMany(mappedBy="tbPessoa")
	private List<TbContato> tbContatos;

	//bi-directional many-to-one association to TbDocumento
	@OneToMany(mappedBy="tbPessoa")
	private List<TbDocumento> tbDocumentos;

	//bi-directional many-to-one association to TbEmail
	@OneToMany(mappedBy="tbPessoa")
	private List<TbEmail> tbEmails;

	//bi-directional many-to-one association to TbEndereco
	@OneToMany(mappedBy="tbPessoa")
	private List<TbEndereco> tbEnderecos;

	//bi-directional many-to-one association to TbTelefone
	@OneToMany(mappedBy="tbPessoa")
	private List<TbTelefone> tbTelefones;

	//bi-directional many-to-one association to TbUsuario
	@OneToMany(mappedBy="tbPessoa")
	private List<TbUsuario> tbUsuarios;

	public TbPessoa() {
	}
}