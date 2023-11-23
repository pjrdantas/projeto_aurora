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
	private String enderecoBairroDto;

	@JsonProperty("enderecoCep")
	private String enderecoCepDto;

	@JsonProperty("enderecoCidade")
	private String enderecoCidadeDto;

	@JsonProperty("enderecoComplemento")
	private String enderecoComplemento;

	@JsonProperty("enderecoDataCadastro")
	private Date enderecoDataCadastroDto;

	@JsonProperty("enderecoLogradouro")
	private String enderecoLogradouroDto;

	@JsonProperty("enderecoNumero")
	private String enderecoNumeroDto;

	@JsonProperty("enderecoTipo")
	private String enderecoTipoDto;

	@JsonProperty("enderecoUf")
	private String enderecoUfDto;
	
	@JsonProperty("pessoaId")
	private PessoaDto pessoaDto;

	public EnderecoDto() {

	}

}