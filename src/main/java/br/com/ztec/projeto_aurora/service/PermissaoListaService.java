package br.com.ztec.projeto_aurora.service;

import java.sql.SQLException;
import java.util.List;

import br.com.ztec.projeto_aurora.dto.PermissaoListaDto;

public interface PermissaoListaService {
	
	void createPermissaoListaDto(PermissaoListaDto permissaoListaDto)  throws SQLException;   
	void updatePermissaoListaDto(PermissaoListaDto permissaoListaDto)  throws SQLException;   
	void deletePermissaoLista(Long id)  throws SQLException;   
	PermissaoListaDto findPermissaoListaById(Long id)  throws SQLException;   
	List<PermissaoListaDto> findAllPermissaoListas()  throws SQLException;   

}
