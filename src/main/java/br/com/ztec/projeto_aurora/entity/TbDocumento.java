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
@Table(name="TB_DOCUMENTO")
public class TbDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="TB_DOCUMENTO_CNPJ", length=255)
	private String tbDocumentoCnpj;

	@Column(name="TB_DOCUMENTO_CPF", length=255)
	private String tbDocumentoCpf;

	@Column(name="TB_DOCUMENTO_FUNCIONAL", length=255)
	private String tbDocumentoFuncional;

	@Column(name="TB_DOCUMENTO_INSCR_EST", length=255)
	private String tbDocumentoInscrEst;

	@Column(name="TB_DOCUMENTO_INSCR_MUN", length=255)
	private String tbDocumentoInscrMun;

	@Column(name="TB_DOCUMENTO_RG", length=255)
	private String tbDocumentoRg;

	//bi-directional many-to-one association to TbPessoa
	@ManyToOne
	@JoinColumn(name="TB_PESSOA_ID")
	private TbPessoa tbPessoa;

	public TbDocumento() {
	}
}