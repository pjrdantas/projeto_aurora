package br.com.ztec.projeto_aurora.service;

import java.sql.SQLException;
import java.util.List;

import br.com.ztec.projeto_aurora.dto.PermissaoListaDto;



public interface PermissaoListaService {

	void createListaPermissaoDto(PermissaoListaDto permissaoListaDto)  throws SQLException;   	
	void updateListaPermissaoDto(PermissaoListaDto permissaoListaDto)  throws SQLException;   	
	void deleteListaPermissao(Long id) throws SQLException;   
	PermissaoListaDto findListaPermissaoById(Long id) throws SQLException;   
	List<PermissaoListaDto> findAllListaPermissaos() throws SQLException;   	
		
		
}