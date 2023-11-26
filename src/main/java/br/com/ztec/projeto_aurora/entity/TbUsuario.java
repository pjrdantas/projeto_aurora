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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


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

	@Column(name="TB_USUARIO_ATIVO")
	private BigDecimal tbUsuarioAtivo;

	@Temporal(TemporalType.DATE)
	@Column(name="TB_USUARIO_DATA_CADASTRADO")
	private Date tbUsuarioDataCadastrado;

	@Column(name="TB_USUARIO_LOGIN")
	private String tbUsuarioLogin;

	@Column(name="TB_USUARIO_NOME")
	private String tbUsuarioNome;

	@Column(name="TB_USUARIO_SENHA")
	private String tbUsuarioSenha;

	@ManyToOne
	@JoinColumn(name="TB_PERFIL_ID")
	private TbPerfil tbPerfil;

	@OneToMany(mappedBy="tbUsuario")
	private List<TbPessoa> tbPessoas;

	public TbUsuario() {
	}


}