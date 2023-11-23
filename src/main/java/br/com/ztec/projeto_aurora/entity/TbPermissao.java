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
@Table(name="TB_PERMISSAO")
public class TbPermissao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="TB_PERMISSAO_CODIGO", nullable=false, length=255)
	private String tbPermissaoCodigo;

	@Column(name="TB_PERMISSAO_DESCRICAO", nullable=false, length=255)
	private String tbPermissaoDescricao;

	//bi-directional many-to-one association to TbPermissaoLista
	@OneToMany(mappedBy="tbPermissao")
	private List<TbPermissaoLista> tbPermissaoListas;

	public TbPermissao() {
	}


}