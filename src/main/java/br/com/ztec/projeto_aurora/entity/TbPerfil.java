package br.com.ztec.projeto_aurora.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

	@Column(name="TB_PERFIL_DESCRICAO", nullable=false, length=255)
	private String tbPerfilDescricao;

	@Column(name="TB_PERFIL_NOME", nullable=false, length=255)
	private String tbPerfilNome;

	//bi-directional many-to-one association to TbPermissaoLista
	@OneToMany(mappedBy="tbPerfil")
	private List<TbPermissaoLista> tbPermissaoListas;

	//bi-directional many-to-one association to TbUsuario
	@OneToMany(mappedBy="tbPerfil")
	private List<TbUsuario> tbUsuarios;

	public TbPerfil() {
	}
}