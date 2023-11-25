package br.com.ztec.projeto_aurora.entity;

import java.io.Serializable;

import javax.persistence.Column;
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


@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@Table(name="TB_DOCUMENTO")
public class TbDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="TB_DOCUMENTO_CNPJ")
	private String tbDocumentoCnpj;

	@Column(name="TB_DOCUMENTO_CPF")
	private String tbDocumentoCpf;

	@Column(name="TB_DOCUMENTO_FUNCIONAL")
	private String tbDocumentoFuncional;

	@Column(name="TB_DOCUMENTO_INSCR_EST")
	private String tbDocumentoInscrEst;

	@Column(name="TB_DOCUMENTO_INSCR_MUN")
	private String tbDocumentoInscrMun;

	@Column(name="TB_DOCUMENTO_RG")
	private String tbDocumentoRg;

	@ManyToOne
	@JoinColumn(name="TB_PESSOA_ID")
	private TbPessoa tbPessoa;

	public TbDocumento() {
	}



}