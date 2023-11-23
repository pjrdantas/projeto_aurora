package br.com.ztec.projeto_aurora.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ztec.projeto_aurora.dto.UsuarioDto;
import br.com.ztec.projeto_aurora.exception.CreationException;
import br.com.ztec.projeto_aurora.repository.UsuarioRepository;
import br.com.ztec.projeto_aurora.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private static final Logger _logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void createUsuarioDto(UsuarioDto usuarioDto) throws SQLException {
        try {
        	usuarioRepository.createUsuarioDto(usuarioDto);
        } catch (SQLException e) {
            _logger.error("Erro ao criar o usuário", e.toString());
            throw new CreationException("Erro ao criar o usuário", e);
        }
	}

	@Override
	public void updateUsuarioDto(UsuarioDto usuarioDto) throws SQLException {
        try {
        	usuarioRepository.updateUsuarioDto(usuarioDto);
        } catch (SQLException e) {
            _logger.error("Erro ao atualizar o usuário", e.toString());            
        }
	}

	@Override
	public void deleteUsuario(Long id) throws SQLException {
        try {
        	usuarioRepository.deleteUsuario(id);
        } catch (SQLException e) {
            _logger.error("Erro ao excluir o usuário com ID: " + id, e.toString());            
        }		
	}

	@Override
	public UsuarioDto findUsuarioById(Long id) throws SQLException {
        try {
            return usuarioRepository.findUsuarioById(id);
        } catch (SQLException e) {
            _logger.error("Erro ao buscar o usuário com ID: " + id, e.toString());            
            return null;
        }

	}

	@Override
	public List<UsuarioDto> findAllUsuarios() throws SQLException {
        try {
            return usuarioRepository.findAllUsuarios();
        } catch (SQLException e) {
            _logger.error("Erro ao buscar todas as regras", e.toString());
            return null;
        }

	}



}
