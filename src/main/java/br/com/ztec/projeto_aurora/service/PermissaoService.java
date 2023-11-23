package br.com.ztec.projeto_aurora.service;

import java.sql.SQLException;
import java.util.List;

import br.com.ztec.projeto_aurora.dto.PermissaoDto;



public interface PermissaoService {


	void createPermissaoDto(PermissaoDto permissaoDto)  throws SQLException;   
	void updatePermissaoDto(PermissaoDto permissaoDto)  throws SQLException;   
	void deletePermissao(Long id)  throws SQLException;   
	PermissaoDto findPermissaoById(Long id)  throws SQLException;   
	List<PermissaoDto> findAllPermissaos()  throws SQLException;   
	
	
}