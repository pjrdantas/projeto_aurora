package br.com.ztec.projeto_aurora.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "idTelefone", "telefoneDataCadastro", "telefoneDdd", "telefoneNumero", "telefoneRamal", "telefoneTipo",
		"pessoaId" })
public class TelefoneDto {

	@JsonProperty("idTelefone")
	private Long idTelefone;

	@JsonProperty("telefoneDataCadastro")
	private Date telefoneDataCadastroDto;

	@JsonProperty("telefoneDdd")
	private String telefoneDddDto;

	@JsonProperty("telefoneNumero")
	private String telefoneNumeroDto;

	@JsonProperty("telefoneRamal")
	private String telefoneRamalDto;

	@JsonProperty("telefoneTipo")
	private String telefoneTipoDto;

	@JsonProperty("pessoaId")
	private PessoaDto pessoaDto;

	public TelefoneDto() {

	}

}