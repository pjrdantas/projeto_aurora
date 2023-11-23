package br.com.ztec.projeto_aurora.service;

import java.sql.SQLException;
import java.util.List;

import br.com.ztec.projeto_aurora.dto.UsuarioDto;



public interface UsuarioService {


	void createUsuarioDto(UsuarioDto usuarioDto)  throws SQLException;   
	void updateUsuarioDto(UsuarioDto usuarioDto)  throws SQLException;   
	void deleteUsuario(Long id)  throws SQLException;   
	UsuarioDto findUsuarioById(Long id)  throws SQLException;   
	List<UsuarioDto> findAllUsuarios()  throws SQLException;   
	
	
}