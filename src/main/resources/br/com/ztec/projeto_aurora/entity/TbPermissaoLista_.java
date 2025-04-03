package br.com.ztec.projeto_aurora.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2025-04-03T16:30:05.533-0300")
@StaticMetamodel(TbPermissaoLista.class)
public class TbPermissaoLista_ {
	public static volatile SingularAttribute<TbPermissaoLista, Long> id;
	public static volatile SingularAttribute<TbPermissaoLista, TbPerfil> tbPerfil;
	public static volatile SingularAttribute<TbPermissaoLista, TbPermissao> tbPermissao;
}
