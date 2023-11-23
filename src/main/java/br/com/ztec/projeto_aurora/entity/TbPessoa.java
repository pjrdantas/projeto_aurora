package br.com.ztec.projeto_aurora.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


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
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="TB_PESSOA_ATIVO", nullable=false)
	private BigDecimal tbPessoaAtivo;

	@Temporal(TemporalType.DATE)
	@Column(name="TB_PESSOA_DATA_CADASTRO", nullable=false)
	private Date tbPessoaDataCadastro;

	@Temporal(TemporalType.DATE)
	@Column(name="TB_PESSOA_DATA_NASC_ABERTURA")
	private Date tbPessoaDataNascAbertura;

	@Column(name="TB_PESSOA_ISENTO")
	private BigDecimal tbPessoaIsento;

	@Column(name="TB_PESSOA_NOME_RAZAO_SOCIAL", length=255)
	private String tbPessoaNomeRazaoSocial;

	@Column(name="TB_PESSOA_PESS_EXP_POLIT")
	private BigDecimal tbPessoaPessExpPolit;

	@Column(name="TB_PESSOA_PF_PJ", length=255)
	private String tbPessoaPfPj;

	@Column(name="TB_PESSOA_SEXO", length=255)
	private String tbPessoaSexo;

	//bi-directional many-to-one association to TbUsuario
	@ManyToOne
	@JoinColumn(name="TB_USUARIO_ID")
	private TbUsuario tbUsuario;

	@Column(name="TB_PESSOA_TIPO", length=255)
	private String tbPessoaTipo;

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

	public TbPessoa() {
	}
}