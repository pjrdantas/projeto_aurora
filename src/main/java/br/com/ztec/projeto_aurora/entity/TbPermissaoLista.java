package br.com.ztec.projeto_aurora.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TB_PERMISSAO_LISTA database table.
 * 
 */
@Entity
@Table(name="TB_PERMISSAO_LISTA")
@NamedQuery(name="TbPermissaoLista.findAll", query="SELECT t FROM TbPermissaoLista t")
public class TbPermissaoLista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TbPerfil getTbPerfil() {
		return this.tbPerfil;
	}

	public void setTbPerfil(TbPerfil tbPerfil) {
		this.tbPerfil = tbPerfil;
	}

	public TbPermissao getTbPermissao() {
		return this.tbPermissao;
	}

	public void setTbPermissao(TbPermissao tbPermissao) {
		this.tbPermissao = tbPermissao;
	}

}