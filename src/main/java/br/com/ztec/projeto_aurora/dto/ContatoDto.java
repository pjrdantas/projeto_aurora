package br.com.ztec.projeto_aurora.dto;

import java.util.Date;

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
@JsonPropertyOrder({ "idContato", "contatoDtCadastro", "contatoNome", "contatoTipo", "pessoaId" })
public class ContatoDto {

	@JsonProperty("idContato")
	private Long idContato;

	@JsonProperty("contatoDataCadastro")
	private Date contatoDataCadastroDto;

	@JsonProperty("contatoNome")
	private String contatoNome;

	@JsonProperty("contatoTipo")
	private String contatoTipo;

	@JsonProperty("pessoaId")
	private PessoaDto pessoaDto;

	public ContatoDto() {

	}

}