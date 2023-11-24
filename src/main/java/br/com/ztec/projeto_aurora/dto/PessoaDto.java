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
	private int pessoaAtivo;

	@JsonProperty("pessoaDataCadastro")
	private Date pessoaDataCadastro;

	@JsonProperty("pessoaDataNascAbertura")
	private Date pessoaDataNascAbertura;

	@JsonProperty("pessoaIsento")
	private int pessoaIsento;

	@JsonProperty("pessoaNomeRazaoSocial")
	private String pessoaNomeRazaoSocial;

	@JsonProperty("pessoaPessExpPolit")
	private int pessoaPessExpPolit;

	@JsonProperty("pessoaPfPj")
	private String pessoaPfPj;

	@JsonProperty("pessoaSexo")
	private String pessoaSexo;

	@JsonProperty("pessoaTipo")
	private String pessoaTipo;

	@JsonProperty("usuarioId")
	private UsuarioDto usuarioDto;

	public PessoaDto() {
	}

}