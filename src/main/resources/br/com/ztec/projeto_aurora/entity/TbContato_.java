package br.com.ztec.projeto_aurora.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2025-04-03T16:30:05.522-0300")
@StaticMetamodel(TbContato.class)
public class TbContato_ {
	public static volatile SingularAttribute<TbContato, Long> id;
	public static volatile SingularAttribute<TbContato, Date> tbContatoDataCadastro;
	public static volatile SingularAttribute<TbContato, String> tbContatoNome;
	public static volatile SingularAttribute<TbContato, String> tbContatoTipo;
	public static volatile SingularAttribute<TbContato, TbPessoa> tbPessoa;
}
