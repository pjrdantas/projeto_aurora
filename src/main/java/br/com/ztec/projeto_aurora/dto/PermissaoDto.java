package br.com.ztec.projeto_aurora.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "idPermissao", "permissaoCodigo", "permissaoDescricao" })
public class PermissaoDto {

	@JsonProperty("idPermissao")
	private Long idPermissao;

	@JsonProperty("permissaoCodigo")
	private String permissaoCodigoDto;

	@JsonProperty("permissaoDescricao")
	private String permissaoDescricaoDto;

	public PermissaoDto() {
	}

}