package br.com.ztec.projeto_aurora.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@Table(name="TB_CONTATO")
public class TbContato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name="TB_CONTATO_DATA_CADASTRO", nullable=false)
	private Date tbContatoDataCadastro;

	@Column(name="TB_CONTATO_NOME", nullable=false, length=255)
	private String tbContatoNome;

	@Column(name="TB_CONTATO_TIPO", nullable=false, length=255)
	private String tbContatoTipo;

	//bi-directional many-to-one association to TbPessoa
	@ManyToOne
	@JoinColumn(name="TB_PESSOA_ID")
	private TbPessoa tbPessoa;

	public TbContato() {
	}
}