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
@JsonPropertyOrder({ "id", "perfilId", "permissaoId" })
public class PermissaoListaDto {
	
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("perfilId")
	private Long perfilId;
	
	@JsonProperty("permissaoId")
	private Long permissaoId;
	
	public PermissaoListaDto() {
		
	}

}
