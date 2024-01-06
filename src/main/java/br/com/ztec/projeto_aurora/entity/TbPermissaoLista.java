package br.com.ztec.projeto_aurora.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the TB_PERMISSAO_LISTA database table.
 * 
 */
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