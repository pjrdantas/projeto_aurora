package br.com.ztec.projeto_aurora.repository;

import java.sql.SQLException;
import java.util.List;

import br.com.ztec.projeto_aurora.dto.PermissaoDto;


public interface PermissaoRepository {


	void createPermissao(PermissaoDto permissaoDto) throws SQLException;
	void updatePermissao(PermissaoDto permissaoDto) throws SQLException;
	void deletePermissao(Long id) throws SQLException;
	PermissaoDto findPermissaoById(Long id) throws SQLException;
	List<PermissaoDto> findAllPermissaos() throws SQLException;
	
}
