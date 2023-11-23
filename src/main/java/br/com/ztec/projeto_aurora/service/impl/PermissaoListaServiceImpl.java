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
	private PermissaoListaRepository listaListaPermissaoRepository;

	@Override
	public void createListaPermissaoDto(PermissaoListaDto permissaoListaDto) throws SQLException {
        try {
        	listaListaPermissaoRepository.createListaPermissaoDto(permissaoListaDto);
        } catch (SQLException e) {
            _logger.error("Erro ao criar a lista de permissão", e.toString());
            throw new CreationException("Erro ao criar a lista de permissão", e);
        }
    }

	@Override
	public void updateListaPermissaoDto(PermissaoListaDto permissaoListaDto) throws SQLException {

        try {
        	listaListaPermissaoRepository.updateListaPermissaoDto(permissaoListaDto);
        } catch (SQLException e) {
            _logger.error("Erro ao atualizar a lista de permissão", e.toString());
            
        }		
	}

	@Override
	public void deleteListaPermissao(Long id) throws SQLException {

        try {
        	listaListaPermissaoRepository.deleteListaPermissao(id);
        } catch (SQLException e) {
            _logger.error("Erro ao excluir a lista de permissão com ID: " + id, e.toString());            
        }		
		
	}

	@Override
	public PermissaoListaDto findListaPermissaoById(Long id) throws SQLException {

        try {
            return listaListaPermissaoRepository.findListaPermissaoById(id);
        } catch (SQLException e) {
            _logger.error("Erro ao buscar a lista de permissão com ID: " + id, e.toString());            
            return null;
        }

	}

	@Override
	public List<PermissaoListaDto> findAllListaPermissaos() throws SQLException {

        try {
            return listaListaPermissaoRepository.findAllListaPermissaos();
        } catch (SQLException e) {
            _logger.error("Erro ao buscar todas as regras", e.toString());
            return null;
        }

	}




}
