package br.com.ztec.projeto_aurora.repository.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ztec.projeto_aurora.dto.PerfilDto;
import br.com.ztec.projeto_aurora.dto.PermissaoDto;
import br.com.ztec.projeto_aurora.dto.PermissaoListaDto;
import br.com.ztec.projeto_aurora.repository.PermissaoListaRepository;



@Transactional
@Repository
public class PermissaoListaRepositoryImpl implements PermissaoListaRepository {



	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public void createListaPermissaoDto(PermissaoListaDto permissaoListaDto) throws SQLException {
		
		StringBuilder sql = new StringBuilder();
		sql.append("  INSERT INTO ");
		sql.append("  TB_PERMISSAO_LISTA (");
		sql.append("  TB_PERFIL_ID, ");
		sql.append("  TB_PERMISSAO_ID) ");
		sql.append("  values (:perfilId, :permissaoId)");
		SqlParameterSource params = new MapSqlParameterSource()
				.addValue("perfilId", permissaoListaDto.getPerfilDto())
				.addValue("permissaoId", permissaoListaDto.getPermissaoDto());
		jdbcTemplate.update(sql.toString(), params);
		
	}

	@Override
	public void updateListaPermissaoDto(PermissaoListaDto permissaoListaDto) throws SQLException {
		
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE TB_PERMISSAO_LISTA ");
		sql.append(" SET  ");
		sql.append(" TB_PERFIL_ID = :perfilId, ");
		sql.append(" tb_permissao_id = :permissaoId ");
		sql.append(" WHERE id = :id");
		SqlParameterSource params = new MapSqlParameterSource()
				.addValue("id", permissaoListaDto.getIdPermissaoLista())
				.addValue("perfilId", permissaoListaDto.getPerfilDto())
				.addValue("tbPermissao", permissaoListaDto.getPermissaoDto());
		jdbcTemplate.update(sql.toString(), params);
		
	}

	@Override
	public void deleteListaPermissao(Long id) throws SQLException {
		
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM ");
		sql.append(" TB_PERMISSAO_LISTA ");
		sql.append(" WHERE id = :id");
		SqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
		jdbcTemplate.update(sql.toString(), params);
		
	}

	@Override
	public PermissaoListaDto findListaPermissaoById(Long id) throws SQLException {
		StringBuilder sql = new StringBuilder(sqlSelectPrincipal);
		sql.append(" WHERE id = :id");
		SqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
		return devolveObjeto(sql, params);
	}

	@Override
	public List<PermissaoListaDto> findAllListaPermissaos() throws SQLException {
		StringBuilder sql = new StringBuilder(sqlSelectPrincipal).append(" order by TB_PERFIL_ID ");
		return devolveListaObjetos(sql, null);
	}
	
	
	

	final static StringBuilder sqlSelectPrincipal = new StringBuilder()
			.append("  SELECT ")
			.append("  ID")
			.append("  ,TB_PERFIL_ID")
			.append("  ,TB_PERMISSAO_ID")
			.append("  FROM TB_PERMISSAO_LISTA ");

	private PermissaoListaDto devolveObjeto(StringBuilder sql, SqlParameterSource params)  {
		return jdbcTemplate.queryForObject(sql.toString(), params, (rs, i) -> {
			PermissaoListaDto permissaoListaDto = new PermissaoListaDto();
			permissaoListaDto.setIdPermissaoLista(rs.getLong("ID"));
			permissaoListaDto.setPerfilDto((PerfilDto) rs.getArray("TB_PERFIL_ID"));
			permissaoListaDto.setPermissaoDto((PermissaoDto) rs.getArray("TB_PERMISSAO_ID"));
			return permissaoListaDto;
		});
	}
	
	private List<PermissaoListaDto> devolveListaObjetos(StringBuilder sql, SqlParameterSource params) {
		return jdbcTemplate.query(sql.toString(), params, (rs, i) -> {
			PermissaoListaDto permissaoListaDto = new PermissaoListaDto();
			permissaoListaDto.setIdPermissaoLista(rs.getLong("ID"));
			permissaoListaDto.setPerfilDto((PerfilDto) rs.getArray("TB_PERFIL_ID"));
			permissaoListaDto.setPermissaoDto((PermissaoDto) rs.getArray("TB_PERMISSAO_ID"));
			return permissaoListaDto;
		});
	}


}
