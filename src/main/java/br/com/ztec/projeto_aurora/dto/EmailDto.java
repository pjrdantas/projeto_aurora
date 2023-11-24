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
@JsonPropertyOrder({ "idEmail", "emailDataCadastro", "emailDescr", "emailTipo", "pessoaId" })
public class EmailDto {
	
	@JsonProperty("idEmail")
	private Long idEmail;
	
	@JsonProperty("emailDataCadastro")
	private Date emailDataCadastro;	
	
	@JsonProperty("emailDescr")
	private String emailDescr;	
	
	@JsonProperty("emailTipo")
	private String emailTipo;	
	
	@JsonProperty("pessoaId")
	private PessoaDto pessoaDto;

	public EmailDto() {
		
	}

}