package br.com.ztec.projeto_aurora.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ztec.projeto_aurora.dto.PermissaoListaDto;
import br.com.ztec.projeto_aurora.exception.CreationException;
import br.com.ztec.projeto_aurora.repository.PermissaoListaRepository;
import br.com.ztec.projeto_aurora.service.PermissaoListaService;

@Service
public class PermissaoListaServiceImpl implements PermissaoListaService {
	
	
	private static final Logger _logger = LoggerFactory.getLogger(PermissaoListaServiceImpl.class);
	
	@Autowired
	private PermissaoListaRepository permissaoListaRepository;

	@Override
	public void createPermissaoListaDto(PermissaoListaDto permissaoListaDto) throws SQLException {
		 try {
			 permissaoListaRepository.createPermissaoListaDto(permissaoListaDto);
	        } catch (SQLException e) {
	            _logger.error("Erro ao criar a lista de permissão", e.toString());
	            throw new CreationException("Erro ao criar a lista de permissão", e);
	        }
		
	}

	@Override
	public void updatePermissaoListaDto(PermissaoListaDto permissaoListaDto) throws SQLException {
		 try {
			 permissaoListaRepository.updatePermissaoListaDto(permissaoListaDto);
	        } catch (SQLException e) {
	            _logger.error("Erro ao atualizar a lista de permissão", e.toString());            
	        }
		
	}

	@Override
	public void deletePermissaoLista(Long id) throws SQLException {
		 try {
			 permissaoListaRepository.deletePermissaoLista(id);
	        } catch (SQLException e) {
	            _logger.error("Erro ao excluir a lista de permissão com ID: " + id, e.toString());            
	        }
		
	}

	@Override
	public PermissaoListaDto findPermissaoListaById(Long id) throws SQLException {
		try {
            return permissaoListaRepository.findPermissaoListaById(id);
        } catch (SQLException e) {
            _logger.error("Erro ao buscar a lista de permissão com ID: " + id, e.toString());            
            return null;
        }
	}

	@Override
	public List<PermissaoListaDto> findAllPermissaoListas() throws SQLException {
		try {
            return permissaoListaRepository.findAllPermissaoListas();
        } catch (SQLException e) {
            _logger.error("Erro ao buscar todas as listas de permissões", e.toString());
            return null;
        }
	}
	

}
