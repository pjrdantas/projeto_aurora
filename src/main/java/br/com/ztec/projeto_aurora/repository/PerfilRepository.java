package br.com.ztec.projeto_aurora.repository;

import java.sql.SQLException;
import java.util.List;

import br.com.ztec.projeto_aurora.dto.PerfilDto;


public interface PerfilRepository {

	void createPerfilDto(PerfilDto perfilDto) throws SQLException;
	void updatePerfilDto(PerfilDto perfilDto) throws SQLException;
	void deletePerfil(Long id) throws SQLException;
	PerfilDto findPerfilById(Long id) throws SQLException;
	List<PerfilDto> findAllPerfils() throws SQLException;
	
}
