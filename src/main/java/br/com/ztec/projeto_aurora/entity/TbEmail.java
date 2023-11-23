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
@Table(name="TB_EMAIL")
public class TbEmail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="TB_EMAIL_DATA_CADASTRO", nullable=false, length=255)
	private String tbEmailDataCadastro;

	@Column(name="TB_EMAIL_DESCR", nullable=false, length=255)
	private String tbEmailDescr;

	@Column(name="TB_EMAIL_TIPO", nullable=false, length=255)
	private String tbEmailTipo;

	//bi-directional many-to-one association to TbPessoa
	@ManyToOne
	@JoinColumn(name="TB_PESSOA_ID")
	private TbPessoa tbPessoa;

	public TbEmail() {
	}
}