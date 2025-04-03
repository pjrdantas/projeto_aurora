package br.com.ztec.projeto_aurora.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2025-04-03T16:30:05.531-0300")
@StaticMetamodel(TbPermissao.class)
public class TbPermissao_ {
	public static volatile SingularAttribute<TbPermissao, Long> id;
	public static volatile SingularAttribute<TbPermissao, String> tbPermissaoCodigo;
	public static volatile SingularAttribute<TbPermissao, String> tbPermissaoDescricao;
	public static volatile ListAttribute<TbPermissao, TbPermissaoLista> tbPermissaoListas;
}
