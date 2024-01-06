package br.com.ztec.projeto_aurora.repository.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ztec.projeto_aurora.dto.PermissaoListaDto;
import br.com.ztec.projeto_aurora.repository.PermissaoListaRepository;

@Transactional
@Repository
public class PermissaoListaRepositoryImpl implements  PermissaoListaRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public void createPermissaoListaDto(PermissaoListaDto permissaoListaDto) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("  INSERT INTO ");
		sql.append("  TB_PERMISSAO_LISTA (");
		sql.append("  TB_PERFIL_ID, ");
		sql.append("  TB_PERMISSAO_ID) ");
		sql.append("  values (:tbPerfil, :tbPermissao)");
		SqlParameterSource params = new MapSqlParameterSource()
				.addValue("tbPerfil", permissaoListaDto.getPerfilId())
				.addValue("tbPermissao", permissaoListaDto.getPermissaoId());
		jdbcTemplate.update(sql.toString(), params);
		
	}

	@Override
	public void updatePermissaoListaDto(PermissaoListaDto permissaoListaDto) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE TB_PERMISSAO_LISTA ");
		sql.append(" SET  ");
		sql.append(" TB_PERFIL_ID = :tbPerfil, ");
		sql.append(" TB_PERMISSAO_ID = :tbPermissao ");
		sql.append(" WHERE id = :id");
		SqlParameterSource params = new MapSqlParameterSource()
				.addValue("id", permissaoListaDto.getId())
				.addValue("tbPermissaoCodigo", permissaoListaDto.getPerfilId())
				.addValue("tbPermissaoDescricao", permissaoListaDto.getPermissaoId());
		jdbcTemplate.update(sql.toString(), params);
		
	}
	
	

	@Override
	public void deletePermissaoLista(Long id) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM ");
		sql.append(" TB_PERMISSAO_LISTA ");
		sql.append(" WHERE id = :id");
		SqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
		jdbcTemplate.update(sql.toString(), params);
		
	}

	@Override
	public PermissaoListaDto findPermissaoListaById(Long id) throws SQLException {

		StringBuilder sql = new StringBuilder(sqlSelectPrincipal);
		sql.append(" WHERE id = :id ");
		SqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
		return devolveObjeto(sql, params);
	}



	@Override
	public List<PermissaoListaDto> findAllPermissaoListas() throws SQLException {

		StringBuilder sql = new StringBuilder(sqlSelectPrincipal).append(" order by id ");
		return devolveListaObjetos(sql, null);
	}
	
	


	final static StringBuilder sqlSelectPrincipal = new StringBuilder()
			.append("  SELECT ")
			.append("  id")
			.append("  ,TB_PERFIL_ID")
			.append("  ,TB_PERMISSAO_ID")
			.append("  FROM TB_PERMISSAO_LISTA ");
	
	

	private PermissaoListaDto devolveObjeto(StringBuilder sql, SqlParameterSource params) {
		return jdbcTemplate.queryForObject(sql.toString(), params, (rs, i) -> {
			PermissaoListaDto permissaoListaDto = new PermissaoListaDto();
			permissaoListaDto.setId(rs.getLong("id"));
			permissaoListaDto.setPerfilId(rs.getLong("TB_PERFIL_ID"));
			permissaoListaDto.setPermissaoId(rs.getLong("TB_PERMISSAO_ID"));
			return permissaoListaDto;
		});
	}
	
	
	private List<PermissaoListaDto> devolveListaObjetos(StringBuilder sql, SqlParameterSource params) {
		return jdbcTemplate.query(sql.toString(), params, (rs, i) -> {
			PermissaoListaDto permissaoListaDto = new PermissaoListaDto();
			permissaoListaDto.setId(rs.getLong("id"));
			permissaoListaDto.setPerfilId(rs.getLong("TB_PERFIL_ID"));
			permissaoListaDto.setPermissaoId(rs.getLong("TB_PERMISSAO_ID"));
			return permissaoListaDto;
		});
	}
	

	
	

}
