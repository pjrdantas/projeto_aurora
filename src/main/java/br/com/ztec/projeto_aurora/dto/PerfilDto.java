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
@JsonInclude(JsonInclude.Include.USE_DEFAULTS)
@JsonPropertyOrder({ "idPerfil", "perfilDescricao", "perfilNome", "permissaoId", "permissaoCd" })
public class PerfilDto {

	@JsonProperty("idPerfil")
	private Long idPerfil;

	@JsonProperty("perfilDescricao")
	private String perfilDescricao;

	@JsonProperty("perfilNome")
	private String perfilNome;
	
	@JsonProperty("idPermissao")
	private long idPermissao;
	
	@JsonProperty("permissaoCd")
	private String permissaoCd;
	
	public PerfilDto() {
	}

}