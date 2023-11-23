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
@JsonPropertyOrder({ "idPerfil", "perfilDescricao", "perfilNome" })
public class PerfilDto {

	@JsonProperty("idPerfil")
	private Long idPerfil;

	@JsonProperty("perfilDescricao")
	private String perfilDescricaoDto;

	@JsonProperty("perfilNome")
	private String perfilNomeDto;
	
	public PerfilDto() {
	}

}