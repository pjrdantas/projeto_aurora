package br.com.ztec.projeto_aurora.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2025-04-03T16:30:05.526-0300")
@StaticMetamodel(TbEmail.class)
public class TbEmail_ {
	public static volatile SingularAttribute<TbEmail, Long> id;
	public static volatile SingularAttribute<TbEmail, Date> tbEmailDataCadastro;
	public static volatile SingularAttribute<TbEmail, String> tbEmailDescr;
	public static volatile SingularAttribute<TbEmail, String> tbEmailTipo;
	public static volatile SingularAttribute<TbEmail, TbPessoa> tbPessoa;
}
