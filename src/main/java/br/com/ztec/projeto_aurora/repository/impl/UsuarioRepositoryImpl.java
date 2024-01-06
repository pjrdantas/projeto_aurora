package br.com.ztec.projeto_aurora.repository.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ztec.projeto_aurora.dto.UsuarioDto;
import br.com.ztec.projeto_aurora.repository.UsuarioRepository;

@Transactional
@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {



	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public void createUsuarioDto(UsuarioDto usuarioDto) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("  INSERT INTO ");
		sql.append("  TB_USUARIO (");
		sql.append("  TB_USUARIO_ATIVO, ");
		sql.append("  TB_USUARIO_DATA_CADASTRADO, ");
		sql.append("  TB_USUARIO_LOGIN, ");
		sql.append("  TB_USUARIO_NOME, ");
		sql.append("  TB_USUARIO_SENHA, ");
		sql.append("  TB_PESSOA_ID) ");

		sql.append("  values (:tbUsuarioAtivo, :tbUsuarioDataCadastrado, :tbUsuarioLogin, :tbUsuarioNome, :tbUsuarioSenha, :tbPessoa)");
		SqlParameterSource params = new MapSqlParameterSource()
				.addValue("tbUsuarioAtivo", usuarioDto.getUsuarioLogin())
				.addValue("tbUsuarioDataCadastrado", usuarioDto.getUsuarioDataCadastrado())
				.addValue("tbUsuarioLogin", usuarioDto.getUsuarioLogin())
				.addValue("tbUsuarioNome", usuarioDto.getUsuarioNome())
				.addValue("tbUsuarioSenha", usuarioDto.getUsuarioSenha())
				.addValue("tbPessoa", usuarioDto.getTbPessoa());

		jdbcTemplate.update(sql.toString(), params);
	
	}

	@Override
	public void updateUsuarioDto(UsuarioDto usuarioDto) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE TB_USUARIO ");
		sql.append(" SET  ");
		sql.append(" TB_USUARIO_ATIVO = :tbUsuarioLogin, ");
		sql.append(" TB_USUARIO_DATA_CADASTRADO = :tbUsuarioLogin, ");
		sql.append(" TB_USUARIO_LOGIN = :tbUsuarioLogin, ");
		sql.append(" TB_USUARIO_NOME = :tbUsuarioLogin, ");
		sql.append(" TB_USUARIO_SENHA = :tbUsuarioSenha, ");
		sql.append(" TB_PESSOA_ID ");
		sql.append(" WHERE id = :id");
		SqlParameterSource params = new MapSqlParameterSource()
				.addValue("id", usuarioDto.getIdUsuario())
				.addValue("tbUsuarioAtivo", usuarioDto.getUsuarioLogin())
				.addValue("tbUsuarioDataCadastrado", usuarioDto.getUsuarioDataCadastrado())
				.addValue("tbUsuarioLogin", usuarioDto.getUsuarioLogin())
				.addValue("tbUsuarioNome", usuarioDto.getUsuarioNome())
				.addValue("tbUsuarioSenha", usuarioDto.getUsuarioSenha())
				.addValue("tbPessoa", usuarioDto.getTbPessoa());
		jdbcTemplate.update(sql.toString(), params);
		
	}

	@Override
	public void deleteUsuario(Long id) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM ");
		sql.append(" TB_USUARIO ");
		sql.append(" WHERE id = :id");
		SqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
		jdbcTemplate.update(sql.toString(), params);
		
	}

	@Override
	public UsuarioDto findUsuarioById(Long id) throws SQLException {

		StringBuilder sql = new StringBuilder(sqlSelectPrincipal);
		sql.append(" WHERE id = :id");
		SqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
		return devolveObjeto(sql, params);
	}

	@Override
	public List<UsuarioDto> findAllUsuarios() throws SQLException {

		StringBuilder sql = new StringBuilder(sqlSelectPrincipal).append(" order by TB_USUARIO_LOGIN ");
		return devolveListaObjetos(sql, null);
	}


	final static StringBuilder sqlSelectPrincipal = new StringBuilder()
			.append("  SELECT ")
			.append("  id")
			.append("  ,TB_USUARIO_ATIVO")
			.append("  ,TB_USUARIO_DATA_CADASTRADO")
			.append("  ,TB_USUARIO_LOGIN")
			.append("  ,TB_USUARIO_NOME")
			.append("  ,TB_USUARIO_SENHA")
			.append("  FROM tb_usuario ");


	private UsuarioDto devolveObjeto(StringBuilder sql, SqlParameterSource params) {
		return jdbcTemplate.queryForObject(sql.toString(), params, (rs, i) -> {
			UsuarioDto usuarioDto = new UsuarioDto();
			usuarioDto.setIdUsuario(rs.getLong("id"));
			usuarioDto.setUsuarioAtivo(rs.getInt("TB_USUARIO_ATIVO"));
			usuarioDto.setUsuarioDataCadastrado(rs.getDate("TB_USUARIO_DATA_CADASTRADO"));
			usuarioDto.setUsuarioLogin(rs.getString("TB_USUARIO_LOGIN"));
			usuarioDto.setUsuarioNome(rs.getString("TB_USUARIO_NOME"));
			usuarioDto.setUsuarioSenha(rs.getString("TB_USUARIO_SENHA"));
			
			return usuarioDto;
		});
	}


	private List<UsuarioDto> devolveListaObjetos(StringBuilder sql, SqlParameterSource params) {
		return jdbcTemplate.query(sql.toString(), params, (rs, i) -> {
			UsuarioDto usuarioDto = new UsuarioDto();
			usuarioDto.setIdUsuario(rs.getLong("id"));
			usuarioDto.setUsuarioAtivo(rs.getInt("TB_USUARIO_ATIVO"));
			usuarioDto.setUsuarioDataCadastrado(rs.getDate("TB_USUARIO_DATA_CADASTRADO"));
			usuarioDto.setUsuarioLogin(rs.getString("TB_USUARIO_LOGIN"));
			usuarioDto.setUsuarioNome(rs.getString("TB_USUARIO_NOME"));
			usuarioDto.setUsuarioSenha(rs.getString("TB_USUARIO_SENHA"));
			
			return usuarioDto;
		});
	}


}

