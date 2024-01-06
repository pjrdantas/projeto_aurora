package br.com.ztec.projeto_aurora.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ztec.projeto_aurora.dto.PermissaoListaDto;
import br.com.ztec.projeto_aurora.service.PermissaoListaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Validated
@Api(value = "service")
@RequestMapping("/service/permissaoLista")
public class PermissaoListaController {
	
	private static final Logger _logger = LoggerFactory.getLogger(PermissaoListaController.class);
	
	@Autowired
	private PermissaoListaService permissaoListaService;
	
	@ApiOperation(value = "INCLUIR PERMISSÃO DE PERFIL- (PermissaoLista)")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 201, message = "Criado."),
			@ApiResponse(code = 400, message = "Requisição Invalida."),
			@ApiResponse(code = 401, message = "Não Autorizado"),
			@ApiResponse(code = 403, message = "Acesso Proibido"),
			@ApiResponse(code = 404, message = "Não Localizado"),
			@ApiResponse(code = 409, message = "Erro de integridade do registro."),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção."), })
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Void>  create(@RequestBody PermissaoListaDto permissaoListaDto) {
		
		try {		
			this.permissaoListaService.createPermissaoListaDto(permissaoListaDto);
			if (permissaoListaDto != null) {
				return new ResponseEntity<>(HttpStatus.CREATED);
			} else {
				_logger.warn("O registro não pode ser nulo. Por favor, forneça os dados necessários.");
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}			
		} catch (DataIntegrityViolationException e) {
			_logger.error("Erro de integridade ao criar o registro permissaoLista. Verifique se os dados são válidos.", e.getCause());
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} catch (Exception e) {
			_logger.error("Ocorreu um erro na inclusão do permissaoLista: ", e.getCause());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

	@ApiOperation(value = "ATUALIZAR PERMISSÃO DE PERFIL -  (PermissaoLista)")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 204, message = "Requisição foi bem-sucedida."),
			@ApiResponse(code = 401, message = "Não Autorizado"),
			@ApiResponse(code = 403, message = "Acesso Proibido"),
			@ApiResponse(code = 404, message = "Não Localizado"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Void> update(@RequestBody PermissaoListaDto permissaoListaDto) {

		try {
			this.permissaoListaService.updatePermissaoListaDto(permissaoListaDto);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (DataIntegrityViolationException e) {
			_logger.error("Erro de integridade ao atualizar o registro da Permissão de perfil. Verifique se os dados são válidos.",
					e.getCause());
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} catch (Exception e) {
			_logger.error("Erro ao atualizar o a Permissão de perfil: ", e.getCause());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	

	@ApiOperation(value = "EXCLUIR A PERMISSÃO DE PERFIL POR ID - (PermissaoLista)")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 204, message = "Requisição foi bem-sucedida."),
			@ApiResponse(code = 401, message = "Não Autorizado"),
			@ApiResponse(code = 403, message = "Acesso Proibido"),
			@ApiResponse(code = 404, message = "Não Localizado"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@RequestMapping(value = "/delete/{idPermissaoLista}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Void> delete(@PathVariable("idPermissaoLista") Long idPermissaoLista) {

		try {
			permissaoListaService.deletePermissaoLista(idPermissaoLista);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (EmptyResultDataAccessException e) {
			_logger.warn("Nenhuma registro de permissaoLista foi encontrado para excluir com o ID: {}", idPermissaoLista);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			_logger.error("Erro ao excluir o registro de permissaoLista por ID: {}", idPermissaoLista, e.getCause());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	

	@ApiOperation(value = "CONSULTAR PERMISSÃO POR PERFIL POR ID - (PermissaoLista)")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 401, message = "Não Autorizado"),
			@ApiResponse(code = 403, message = "Acesso Proibido"),
			@ApiResponse(code = 404, message = "Não Localizado"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@RequestMapping(value = "/findById/{idPermissaoLista}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<PermissaoListaDto> findById(@PathVariable("idPermissaoLista") Long idPermissaoLista) {

		try {						 
			return new ResponseEntity<>(permissaoListaService.findPermissaoListaById(idPermissaoLista),(HttpStatus.OK));			 
		} catch (NoSuchElementException e) {
			_logger.warn("O registro da Permissão de perfil não encontrada para o ID: {}", idPermissaoLista);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			_logger.error("Erro ao buscar a Permissão de perfil por ID: {}", idPermissaoLista, e.getCause());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@ApiOperation(value = "CONSULTAR LISTA DE PERMISSÕES POR PERFIL - (PermissaoLista)")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Retorna a lista de regras"),
			@ApiResponse(code = 401, message = "Não Autorizado"),
			@ApiResponse(code = 403, message = "Acesso Proibido"),
			@ApiResponse(code = 404, message = "Não Localizado"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<PermissaoListaDto>> findAll() {

		try {
			List<PermissaoListaDto> permissaoLista = permissaoListaService.findAllPermissaoListas();
			if (!permissaoLista.isEmpty()) {
				_logger.info("Lista de permissões de perfil obtida com sucesso!");
				return new ResponseEntity<>(permissaoLista, HttpStatus.OK);
			} else {
				_logger.warn("Lista de permissões de perfil está vazia!");
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			_logger.error("Erro ao listar as permissões por perfil: ", e.getCause());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
