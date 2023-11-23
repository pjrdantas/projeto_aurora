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
import br.com.ztec.projeto_aurora.repository.PerfilRepository;

@Transactional
@Repository
public class PerfilRepositoryImpl implements PerfilRepository {



	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public void createPerfilDto(PerfilDto perfilDto) throws SQLException {
		
		StringBuilder sql = new StringBuilder();
		sql.append("  INSERT INTO ");
		sql.append("  TB_PERFIL (");
		sql.append("  TB_PERFIL_DESCRICAO, ");
		sql.append("  TB_PERFIL_NOME) ");
		sql.append("  values (:tbPerfilDescricao, :tbPerfilNome)");
		SqlParameterSource params = new MapSqlParameterSource()
				.addValue("tbPerfilDescricao", perfilDto.getPerfilDescricaoDto())
				.addValue("tbPerfilNome", perfilDto.getPerfilNomeDto());
		jdbcTemplate.update(sql.toString(), params);
		
	}

	@Override
	public void updatePerfilDto(PerfilDto perfilDto) throws SQLException {
		
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE TB_PERFIL ");
		sql.append(" SET  ");
		sql.append(" TB_PERFIL_DESCRICAO = :tbPerfilDescricao, ");
		sql.append(" TB_PERFIL_NOME = :tbPerfilNome ");
		sql.append(" WHERE id = :id");
		SqlParameterSource params = new MapSqlParameterSource()
				.addValue("id", perfilDto.getIdPerfil())
				.addValue("tbPerfilDescricao", perfilDto.getPerfilDescricaoDto())
				.addValue("tbPerfilNome", perfilDto.getPerfilNomeDto());

		jdbcTemplate.update(sql.toString(), params);
		
	}

	@Override
	public void deletePerfil(Long id) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM ");
		sql.append(" TB_PERFIL ");
		sql.append(" WHERE id = :id");
		SqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
		jdbcTemplate.update(sql.toString(), params);
		
	}

	@Override
	public PerfilDto findPerfilById(Long id) throws SQLException {

		StringBuilder sql = new StringBuilder(sqlSelectPrincipal);
		sql.append(" WHERE id = :id");
		SqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
		return devolveObjeto(sql, params);
		
	}

	@Override
	public List<PerfilDto> findAllPerfils() throws SQLException {
		
		StringBuilder sql = new StringBuilder(sqlSelectPrincipal).append(" order by tb_perfil_nome ");
		return devolveListaObjetos(sql, null);
	}
	
	
	final static StringBuilder sqlSelectPrincipal = new StringBuilder()
			.append("  SELECT ")
			.append("  id")
			.append("  ,TB_PERFIL_DESCRICAO")
			.append("  ,TB_PERFIL_NOME")
			.append("  FROM TB_PERFIL ");

	
	private PerfilDto devolveObjeto(StringBuilder sql, SqlParameterSource params)  {
		return jdbcTemplate.queryForObject(sql.toString(), params, (rs, i) -> {
			PerfilDto perfilDto = new PerfilDto();
			
			perfilDto.setIdPerfil(rs.getLong("id"));
			perfilDto.setPerfilDescricaoDto(rs.getString("TB_PERFIL_DESCRICAO"));
			perfilDto.setPerfilNomeDto(rs.getString("TB_PERFIL_NOME"));			
			return perfilDto;
		});
	}
	
	private List<PerfilDto> devolveListaObjetos(StringBuilder sql, SqlParameterSource params) {
		return jdbcTemplate.query(sql.toString(), params, (rs, i) -> {
			PerfilDto perfilDto = new PerfilDto();
			perfilDto.setIdPerfil(rs.getLong("id"));
			perfilDto.setPerfilDescricaoDto(rs.getString("TB_PERFIL_DESCRICAO"));
			perfilDto.setPerfilNomeDto(rs.getString("TB_PERFIL_NOME"));

			return perfilDto;
		});
	}
	

}
