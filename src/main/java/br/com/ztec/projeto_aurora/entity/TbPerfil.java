package br.com.ztec.projeto_aurora.entity;

import java.io.Serializable;
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

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@Table(name="TB_PERFIL")
public class TbPerfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="TB_PERFIL_DESCRICAO")
	private String tbPerfilDescricao;

	@Column(name="TB_PERFIL_NOME")
	private String tbPerfilNome;

	@ManyToOne
	@JoinColumn(name="TB_PERMISSAO_ID")
	private TbPermissao tbPermissao;

	@OneToMany(mappedBy="tbPerfil")
	private List<TbUsuario> tbUsuarios;

	public TbPerfil() {
	}



}