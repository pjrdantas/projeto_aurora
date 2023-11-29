package br.com.ztec.projeto_aurora.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.USE_DEFAULTS)
@JsonPropertyOrder({ "idPermissao", "permissaoCodigo", "permissaoDescricao" })
public class PermissaoDto {

	@JsonProperty("idPermissao")
	private Long idPermissao;

	@JsonProperty("permissaoCodigo")
	private String permissaoCodigo;

	@JsonProperty("permissaoDescricao")
	private String permissaoDescricao;

	public PermissaoDto() {
	}
}