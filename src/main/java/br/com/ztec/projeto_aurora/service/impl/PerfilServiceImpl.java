package br.com.ztec.projeto_aurora.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ztec.projeto_aurora.dto.PerfilDto;
import br.com.ztec.projeto_aurora.exception.CreationException;
import br.com.ztec.projeto_aurora.repository.PerfilRepository;
import br.com.ztec.projeto_aurora.service.PerfilService;

@Service
public class PerfilServiceImpl implements PerfilService {
	
	private static final Logger _logger = LoggerFactory.getLogger(PerfilServiceImpl.class);

	@Autowired
	private PerfilRepository perfilRepository;

	@Override
	public void createPerfilDto(PerfilDto perfilDto) throws SQLException {
        try {
        	perfilRepository.createPerfilDto(perfilDto);
        } catch (SQLException e) {
            _logger.error("Erro ao criar o perfil", e.toString());
            throw new CreationException("Erro ao criar o perfil", e);
        }
	}

	@Override
	public void updatePerfilDto(PerfilDto perfilDto) throws SQLException {
        try {
        	perfilRepository.updatePerfilDto(perfilDto);
        } catch (SQLException e) {
            _logger.error("Erro ao atualizar o perfil", e.toString());           
        }		
	}

	@Override
	public void deletePerfil(Long id) throws SQLException {
        try {
        	perfilRepository.deletePerfil(id);
        } catch (SQLException e) {
            _logger.error("Erro ao excluir o perfil com ID: " + id, e.toString());            
        }		

		
	}

	@Override
	public PerfilDto findPerfilById(Long id) throws SQLException {
        try {
            return perfilRepository.findPerfilById(id);
        } catch (SQLException e) {
            _logger.error("Erro ao buscar o perfil com ID: " + id, e.toString());            
            return null;
        }
	}

	@Override
	public List<PerfilDto> findAllPerfils() throws SQLException {
        try {
            return perfilRepository.findAllPerfils();
        } catch (SQLException e) {
            _logger.error("Erro ao buscar todos os perfis", e.toString());
            return null;
        }

	}



}
