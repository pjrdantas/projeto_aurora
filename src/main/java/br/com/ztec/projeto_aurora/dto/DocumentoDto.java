package br.com.ztec.projeto_aurora.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "idDocumento", "documentoCnpj", "documentoCpf", "documentoFuncional", "documentoInscrEst",
		"documentoInscrMun", "documentoRg", "pessoaId" })
public class DocumentoDto {

	@JsonProperty("idDocumento")
	private Long idDocumento;

	@JsonProperty("documentoCnpj")
	private String documentoCnpjDto;

	@JsonProperty("documentoCpf")
	private String documentoCpfDto;

	@JsonProperty("documentoFuncional")
	private String documentoFuncionalDto;

	@JsonProperty("documentoInscrEst")
	private String documentoInscrEstDto;

	@JsonProperty("documentoInscrMun")
	private String documentoInscrMunDto;

	@JsonProperty("documentoRg")
	private String documentoRgDto;

	@JsonProperty("pessoaId")
	private PessoaDto pessoaDto;

	public DocumentoDto() {
	}

	
}