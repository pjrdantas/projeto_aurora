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

import br.com.ztec.projeto_aurora.dto.UsuarioDto;
import br.com.ztec.projeto_aurora.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Validated
@Api(value = "service")
@RequestMapping("/service/usuario")
public class UsuarioController {

	private static final Logger _logger = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private UsuarioService usuario;
	
	@ApiOperation(value = "INCLUIR USUARIO - (Usuario)")
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
	public ResponseEntity<Void>  create(@RequestBody UsuarioDto usuarioDto) {
		
		try {		
			this.usuario.createUsuarioDto(usuarioDto);
			if (usuarioDto != null) {
				return new ResponseEntity<>(HttpStatus.CREATED);
			} else {
				_logger.error("O registro não pode ser nulo. Por favor, forneça os dados necessários.");
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}			
		} catch (DataIntegrityViolationException e) {
			_logger.error("Erro de integridade ao criar o usuario. Verifique se os dados são válidos.", e.getCause());
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} catch (Exception e) {
			_logger.error("Ocorreu um erro na inclusão do usuario: ", e.getCause());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

	@ApiOperation(value = "ATUALIZAR USUARIO -  (Usuario)")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Criado."),
			@ApiResponse(code = 204, message = "Requisição foi bem-sucedida."),
			@ApiResponse(code = 401, message = "Não Autorizado"),
			@ApiResponse(code = 403, message = "Acesso Proibido"),
			@ApiResponse(code = 404, message = "Não Localizado"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Void> update(@RequestBody UsuarioDto usuarioDto) {

		try {
			this.usuario.updateUsuarioDto(usuarioDto);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (DataIntegrityViolationException e) {
			_logger.error("Erro de integridade ao atualizar o usuario. Verifique se os dados são válidos.",
					e.getCause());
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} catch (Exception e) {
			_logger.error("Erro ao atualizar o usuario: ", e.getCause());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	

	@ApiOperation(value = "EXCLUIR A USUARIO POR ID - (Usuario)")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 204, message = "Requisição foi bem-sucedida."),
			@ApiResponse(code = 401, message = "Não Autorizado"),
			@ApiResponse(code = 403, message = "Acesso Proibido"),
			@ApiResponse(code = 404, message = "Não Localizado"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@RequestMapping(value = "/delete/{idUsuario}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Void> delete(@PathVariable("idUsuario") Long idUsuario) {

		try {
			usuario.deleteUsuario(idUsuario);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (EmptyResultDataAccessException e) {
			_logger.warn("Nenhuma usuario foi encontrado para excluir com o ID: {}", idUsuario);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			_logger.error("Erro ao excluir o usuario por ID: {}", idUsuario, e.getCause());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	

	@ApiOperation(value = "CONSULTAR USUARIO POR ID - (Usuario)")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 401, message = "Não Autorizado"),
			@ApiResponse(code = 403, message = "Acesso Proibido"),
			@ApiResponse(code = 404, message = "Não Localizado"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@RequestMapping(value = "/findById/{idUsuario}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<UsuarioDto> findById(@PathVariable("idUsuario") Long idUsuario) {

		try {
			UsuarioDto rulers = usuario.findUsuarioById(idUsuario);

			if (rulers != null) {
				return new ResponseEntity<>(rulers, HttpStatus.FOUND);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (NoSuchElementException e) {
			_logger.warn("Usuario não encontrada para o ID: {}", idUsuario);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			_logger.error("Erro ao buscar o usuario por ID: {}", idUsuario, e.getCause());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@ApiOperation(value = "CONSULTAR LISTA DE PERFIS - (Usuario)")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Retorna a lista de regras"),
			@ApiResponse(code = 401, message = "Não Autorizado"),
			@ApiResponse(code = 403, message = "Acesso Proibido"),
			@ApiResponse(code = 404, message = "Não Localizado"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<UsuarioDto>> findAll() {

		try {
			List<UsuarioDto> rulers = usuario.findAllUsuarios();
			if (!rulers.isEmpty()) {
				_logger.info("Lista de permissões obtida com sucesso!");
				return new ResponseEntity<>(rulers, HttpStatus.OK);
			} else {
				_logger.warn("Lista de permissões está vazia!");
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			_logger.error("Erro ao listar as permissões: ", e.getCause());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
