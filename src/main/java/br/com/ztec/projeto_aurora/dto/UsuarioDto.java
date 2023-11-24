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
@JsonInclude(JsonInclude.Include.USE_DEFAULTS)
@JsonPropertyOrder({ "idUsuario", "usuarioAtivo", "usuarioDataCadastrado", "usuarioEmail", "usuarioLogin",
		"usuarioNome", "usuarioSenha", "perfilId" })
public class UsuarioDto {

	@JsonProperty("idUsuario")
	private Long idUsuario;

	@JsonProperty("usuarioAtivo")
	private int usuarioAtivo;

	@JsonProperty("usuarioDataCadastrado")
	private Date usuarioDataCadastrado;

	@JsonProperty("usuarioEmail")
	private String usuarioEmail;

	@JsonProperty("usuarioLogin")
	private String usuarioLogin;

	@JsonProperty("usuarioNome")
	private String usuarioNome;

	@JsonProperty("usuarioSenha")
	private String usuarioSenha;

	@JsonProperty("perfilId")
	private PerfilDto perfilDto;

	public UsuarioDto() {
	}

}
