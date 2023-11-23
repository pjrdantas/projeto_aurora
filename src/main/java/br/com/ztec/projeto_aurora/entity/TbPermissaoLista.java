package br.com.ztec.projeto_aurora.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@Table(name="TB_PERMISSAO_LISTA")
public class TbPermissaoLista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;

	//bi-directional many-to-one association to TbPerfil
	@ManyToOne
	@JoinColumn(name="TB_PERFIL_ID")
	private TbPerfil tbPerfil;

	//bi-directional many-to-one association to TbPermissao
	@ManyToOne
	@JoinColumn(name="TB_PERMISSAO_ID")
	private TbPermissao tbPermissao;

	public TbPermissaoLista() {
	}

}