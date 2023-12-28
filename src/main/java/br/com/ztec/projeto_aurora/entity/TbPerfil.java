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


/**
 * The persistent class for the TB_PERFIL database table.
 * 
 */
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
	private Long id;

	@Column(name="TB_PERFIL_DESCRICAO")
	private String tbPerfilDescricao;

	@Column(name="TB_PERFIL_NOME")
	private String tbPerfilNome;

	//bi-directional many-to-one association to TbUsuario
	@ManyToOne
	@JoinColumn(name="TB_USUARIO_ID")
	private TbUsuario tbUsuario;

	//bi-directional many-to-one association to TbPermissao
	@OneToMany(mappedBy="tbPerfil")
	private List<TbPermissao> tbPermissaos;

	public TbPerfil() {
	}
}