package br.com.ztec.projeto_aurora.repository;

import java.sql.SQLException;
import java.util.List;

import br.com.ztec.projeto_aurora.dto.PermissaoListaDto;

public interface PermissaoListaRepository {
	
	void createPermissaoLista(PermissaoListaDto permissaoListaDto)  throws SQLException;   
	void updatePermissaoLista(PermissaoListaDto permissaoListaDto)  throws SQLException;   
	void deletePermissaoLista(Long id)  throws SQLException;   
	PermissaoListaDto findPermissaoListaById(Long id)  throws SQLException;   
	List<PermissaoListaDto> findAllPermissaoListas()  throws SQLException;   
	
}
