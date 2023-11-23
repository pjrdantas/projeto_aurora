package br.com.ztec.projeto_aurora.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ztec.projeto_aurora.dto.PermissaoDto;
import br.com.ztec.projeto_aurora.exception.CreationException;
import br.com.ztec.projeto_aurora.repository.PermissaoRepository;
import br.com.ztec.projeto_aurora.service.PermissaoService;

@Service
public class PermissaoServiceImpl implements PermissaoService {
	
	private static final Logger _logger = LoggerFactory.getLogger(PermissaoServiceImpl.class);

	@Autowired
	private PermissaoRepository permissaoRepository;

	@Override
	public void createPermissaoDto(PermissaoDto permissaoDto) throws SQLException {
        try {
        	permissaoRepository.createPermissaoDto(permissaoDto);
        } catch (SQLException e) {
            _logger.error("Erro ao criar a permissão", e.toString());
            throw new CreationException("Erro ao criar a permissão", e);
        }
	}

	@Override
	public void updatePermissaoDto(PermissaoDto permissaoDto) throws SQLException {
        try {
        	permissaoRepository.updatePermissaoDto(permissaoDto);
        } catch (SQLException e) {
            _logger.error("Erro ao atualizar a permissão", e.toString());            
        }
	}

	@Override
	public void deletePermissao(Long id) throws SQLException {
        try {
        	permissaoRepository.deletePermissao(id);
        } catch (SQLException e) {
            _logger.error("Erro ao excluir a permissão com ID: " + id, e.toString());            
        }		
	}

	@Override
	public PermissaoDto findPermissaoById(Long id) throws SQLException {
        try {
            return permissaoRepository.findPermissaoById(id);
        } catch (SQLException e) {
            _logger.error("Erro ao buscar a permissão com ID: " + id, e.toString());            
            return null;
        }

	}

	@Override
	public List<PermissaoDto> findAllPermissaos() throws SQLException {
        try {
            return permissaoRepository.findAllPermissaos();
        } catch (SQLException e) {
            _logger.error("Erro ao buscar todas as permissões", e.toString());
            return null;
        }

	}



}
