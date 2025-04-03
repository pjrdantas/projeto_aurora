package br.com.ztec.projeto_aurora.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2025-04-03T16:30:05.539-0300")
@StaticMetamodel(TbUsuario.class)
public class TbUsuario_ {
	public static volatile SingularAttribute<TbUsuario, Long> id;
	public static volatile SingularAttribute<TbUsuario, BigDecimal> tbUsuarioAtivo;
	public static volatile SingularAttribute<TbUsuario, Date> tbUsuarioDataCadastrado;
	public static volatile SingularAttribute<TbUsuario, String> tbUsuarioLogin;
	public static volatile SingularAttribute<TbUsuario, String> tbUsuarioNome;
	public static volatile SingularAttribute<TbUsuario, String> tbUsuarioSenha;
	public static volatile ListAttribute<TbUsuario, TbPerfil> tbPerfils;
	public static volatile SingularAttribute<TbUsuario, TbPessoa> tbPessoa;
}
