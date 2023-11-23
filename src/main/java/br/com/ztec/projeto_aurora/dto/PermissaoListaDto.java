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
@JsonPropertyOrder({ "idPermissaoLista", "perfilId", "permissaoId" })
public class PermissaoListaDto {

	@JsonProperty("idPermissaoLista")
	private Long idPermissaoLista;

	@JsonProperty("perfilId")
	private PerfilDto perfilDto;

	@JsonProperty("permissaoId")
	private PermissaoDto permissaoDto;

	public PermissaoListaDto() {
	}

}