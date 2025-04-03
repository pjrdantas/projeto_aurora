package br.com.ztec.projeto_aurora.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2025-04-03T16:30:05.529-0300")
@StaticMetamodel(TbPerfil.class)
public class TbPerfil_ {
	public static volatile SingularAttribute<TbPerfil, Long> id;
	public static volatile SingularAttribute<TbPerfil, String> tbPerfilDescricao;
	public static volatile SingularAttribute<TbPerfil, String> tbPerfilNome;
	public static volatile SingularAttribute<TbPerfil, TbUsuario> tbUsuario;
	public static volatile ListAttribute<TbPerfil, TbPermissaoLista> tbPermissaoListas;
}
