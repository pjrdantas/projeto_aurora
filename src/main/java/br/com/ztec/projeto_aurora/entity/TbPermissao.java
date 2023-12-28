package br.com.ztec.projeto_aurora.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the TB_PERMISSAO database table.
 * 
 */
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@Table(name="TB_PERMISSAO")
public class TbPermissao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="TB_PERMISSAO_CODIGO")
	private String tbPermissaoCodigo;

	@Column(name="TB_PERMISSAO_DESCRICAO")
	private String tbPermissaoDescricao;

	//bi-directional many-to-one association to TbPermissaoLista
	@OneToMany(mappedBy="tbPermissao")
	private List<TbPermissaoLista> tbPermissaoListas;

	public TbPermissao() {
	}
}