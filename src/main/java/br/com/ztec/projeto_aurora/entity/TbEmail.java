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


/**
 * The persistent class for the TB_EMAIL database table.
 * 
 */
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
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name="TB_EMAIL_DATA_CADASTRO")
	private Date tbEmailDataCadastro;

	@Column(name="TB_EMAIL_DESCR")
	private String tbEmailDescr;

	@Column(name="TB_EMAIL_TIPO")
	private String tbEmailTipo;

	//bi-directional many-to-one association to TbPessoa
	@ManyToOne
	@JoinColumn(name="TB_PESSOA_ID")
	private TbPessoa tbPessoa;

	public TbEmail() {
	}
}