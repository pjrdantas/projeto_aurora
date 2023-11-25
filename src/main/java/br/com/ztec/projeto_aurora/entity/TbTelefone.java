package br.com.ztec.projeto_aurora.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


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
	@Column(name="TB_TELEFONE_DATA_CADASTRO")
	private Date tbTelefoneDataCadastro;

	@Column(name="TB_TELEFONE_DDD")
	private String tbTelefoneDdd;

	@Column(name="TB_TELEFONE_NUMERO")
	private String tbTelefoneNumero;

	@Column(name="TB_TELEFONE_RAMAL")
	private String tbTelefoneRamal;

	@Column(name="TB_TELEFONE_TIPO")
	private String tbTelefoneTipo;

	@ManyToOne
	@JoinColumn(name="TB_PESSOA_ID")
	private TbPessoa tbPessoa;

	public TbTelefone() {
	}


}