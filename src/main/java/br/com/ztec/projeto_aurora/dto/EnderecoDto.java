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
@JsonPropertyOrder({ "idEndereco", "enderecoBairro", "enderecoCep", "enderecoCidade", "enderecoComplemento", "enderecoDataCadastro", "enderecoLogradouro", "enderecoNumero", "enderecoTipo", "enderecoUf", "pessoaId" })
public class EnderecoDto {

	@JsonProperty("idEndereco")
	private Long idEndereco;

	@JsonProperty("enderecoBairro")
	private String enderecoBairro;

	@JsonProperty("enderecoCep")
	private String enderecoCep;

	@JsonProperty("enderecoCidade")
	private String enderecoCidade;

	@JsonProperty("enderecoComplemento")
	private String enderecoComplemento;

	@JsonProperty("enderecoDataCadastro")
	private Date enderecoDataCadastro;

	@JsonProperty("enderecoLogradouro")
	private String enderecoLogradouro;

	@JsonProperty("enderecoNumero")
	private String enderecoNumero;

	@JsonProperty("enderecoTipo")
	private String enderecoTipo;

	@JsonProperty("enderecoUf")
	private String enderecoUf;
	
	@JsonProperty("pessoaId")
	private PessoaDto pessoaDto;

	public EnderecoDto() {

	}

}