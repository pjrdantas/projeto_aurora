package br.com.ztec.projeto_aurora.repository.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ztec.projeto_aurora.dto.PermissaoDto;
import br.com.ztec.projeto_aurora.repository.PermissaoRepository;

@Transactional
@Repository
public class PermissaoRepositoryImpl implements PermissaoRepository {



	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public void createPermissaoDto(PermissaoDto permissaoDto) throws SQLException {
		
		StringBuilder sql = new StringBuilder();
		sql.append("  INSERT INTO ");
		sql.append("  TB_PERMISSAO (");
		sql.append("  TB_PERMISSAO_CODIGO, ");
		sql.append("  TB_PERMISSAO_DESCRICAO) ");
		sql.append("  values (:tbPermissaoCodigo, :tbPermissaoDescricao)");
		SqlParameterSource params = new MapSqlParameterSource()
				.addValue("tbPermissaoCodigo", permissaoDto.getPermissaoCodigo())
				.addValue("tbPermissaoDescricao", permissaoDto.getPermissaoDescricao());
		jdbcTemplate.update(sql.toString(), params);
		
	}


	@Override
	public void updatePermissaoDto(PermissaoDto permissaoDto) throws SQLException {
		
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE TB_PERMISSAO ");
		sql.append(" SET  ");
		sql.append(" TB_PERMISSAO_CODIGO = :tbPermissaoCodigo, ");
		sql.append(" TB_PERMISSAO_DESCRICAO = :tbPermissaoDescricao ");
		sql.append(" WHERE id = :id");
		SqlParameterSource params = new MapSqlParameterSource()
				.addValue("id", permissaoDto.getIdPermissao())
				.addValue("tbPermissaoCodigo", permissaoDto.getPermissaoCodigo())
				.addValue("tbPermissaoDescricao", permissaoDto.getPermissaoDescricao());
		jdbcTemplate.update(sql.toString(), params);
		
	}


	@Override
	public void deletePermissao(Long id) throws SQLException {
		
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM ");
		sql.append(" TB_PERMISSAO ");
		sql.append(" WHERE id = :id");
		SqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
		jdbcTemplate.update(sql.toString(), params);
		
	}


	@Override
	public PermissaoDto findPermissaoById(Long id) throws SQLException {
		
		StringBuilder sql = new StringBuilder(sqlSelectPrincipal);
		sql.append(" WHERE id = :id");
		SqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
		return devolveObjeto(sql, params);
	}


	@Override
	public List<PermissaoDto> findAllPermissaos() throws SQLException {
		
		StringBuilder sql = new StringBuilder(sqlSelectPrincipal).append(" order by tb_permissao_codigo ");
		return devolveListaObjetos(sql, null);
	}


	final static StringBuilder sqlSelectPrincipal = new StringBuilder()
			.append("  SELECT ")
			.append("  id")
			.append("  ,tb_permissao_codigo")
			.append("  ,tb_permissao_descricao")
			.append("  FROM tb_permissao ");


	private PermissaoDto devolveObjeto(StringBuilder sql, SqlParameterSource params) {
		return jdbcTemplate.queryForObject(sql.toString(), params, (rs, i) -> {
			PermissaoDto permissaoDto = new PermissaoDto();
			permissaoDto.setIdPermissao(rs.getLong("id"));
			permissaoDto.setPermissaoCodigo(rs.getString("tb_permissao_codigo"));
			permissaoDto.setPermissaoDescricao(rs.getString("tb_permissao_descricao"));
			return permissaoDto;
		});
	}


	private List<PermissaoDto> devolveListaObjetos(StringBuilder sql, SqlParameterSource params) {
		return jdbcTemplate.query(sql.toString(), params, (rs, i) -> {
			PermissaoDto permissaoDto = new PermissaoDto();
			permissaoDto.setIdPermissao(rs.getLong("id"));
			permissaoDto.setPermissaoCodigo(rs.getString("tb_permissao_codigo"));
			permissaoDto.setPermissaoDescricao(rs.getString("tb_permissao_descricao"));
			return permissaoDto;
		});
	}



}
