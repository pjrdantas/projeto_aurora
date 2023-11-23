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
@Table(name="TB_USUARIO")
public class TbUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="TB_USUARIO_ATIVO", nullable=false)
	private BigDecimal tbUsuarioAtivo;

	@Temporal(TemporalType.DATE)
	@Column(name="TB_USUARIO_DATA_CADASTRADO", nullable=false)
	private Date tbUsuarioDataCadastrado;

	@Column(name="TB_USUARIO_LOGIN", nullable=false, length=255)
	private String tbUsuarioLogin;

	@Column(name="TB_USUARIO_NOME", nullable=false, length=255)
	private String tbUsuarioNome;

	@Column(name="TB_USUARIO_SENHA", nullable=false, length=255)
	private String tbUsuarioSenha;

	//bi-directional many-to-one association to TbPerfil
	@ManyToOne
	@JoinColumn(name="TB_PERFIL_ID")
	private TbPerfil tbPerfil;

	//bi-directional many-to-one association to TbPessoa
	@OneToMany(mappedBy="tbUsuario")
	private List<TbPessoa> tbPessoas;

	public TbUsuario() {
	}

}