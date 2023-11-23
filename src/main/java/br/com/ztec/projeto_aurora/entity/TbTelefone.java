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
@Table(name="TB_TELEFONE")
public class TbTelefone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name="TB_TELEFONE_DATA_CADASTRO", nullable=false)
	private Date tbTelefoneDataCadastro;

	@Column(name="TB_TELEFONE_DDD", nullable=false, length=255)
	private String tbTelefoneDdd;

	@Column(name="TB_TELEFONE_NUMERO", nullable=false, length=255)
	private String tbTelefoneNumero;

	@Column(name="TB_TELEFONE_RAMAL", nullable=false, length=255)
	private String tbTelefoneRamal;

	@Column(name="TB_TELEFONE_TIPO", nullable=false, length=255)
	private String tbTelefoneTipo;

	//bi-directional many-to-one association to TbPessoa
	@ManyToOne
	@JoinColumn(name="TB_PESSOA_ID")
	private TbPessoa tbPessoa;

	public TbTelefone() {
	}
}