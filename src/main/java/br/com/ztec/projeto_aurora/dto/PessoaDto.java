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
@JsonPropertyOrder({ "idPessoa", "pessoaAtivo", "pessoaDataCadastro", "pessoaDataNascAbertura", "pessoaIsento",
		"pessoaNomeRazaoSocial", "pessoaPessExpPolit", "pessoaPfPj", "pessoaSexo", "pessoaTipo", "usuarioId" })
public class PessoaDto {

	@JsonProperty("idPessoa")
	private Long idPessoa;

	@JsonProperty("pessoaAtivo")
	private int pessoaAtivoDto;

	@JsonProperty("pessoaDataCadastro")
	private Date pessoaDataCadastroDto;

	@JsonProperty("pessoaDataNascAbertura")
	private Date pessoaDataNascAberturaDto;

	@JsonProperty("pessoaIsento")
	private int pessoaIsentoDto;

	@JsonProperty("pessoaNomeRazaoSocial")
	private String pessoaNomeRazaoSocialDto;

	@JsonProperty("pessoaPessExpPolit")
	private int pessoaPessExpPolitDto;

	@JsonProperty("pessoaPfPj")
	private String pessoaPfPjDto;

	@JsonProperty("pessoaSexo")
	private String pessoaSexoDto;

	@JsonProperty("pessoaTipo")
	private String pessoaTipo;

	@JsonProperty("usuarioId")
	private UsuarioDto usuarioDto;

	public PessoaDto() {
	}

}