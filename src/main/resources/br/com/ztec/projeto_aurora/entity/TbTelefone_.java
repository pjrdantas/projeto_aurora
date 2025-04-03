package br.com.ztec.projeto_aurora.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2025-04-03T16:30:05.536-0300")
@StaticMetamodel(TbTelefone.class)
public class TbTelefone_ {
	public static volatile SingularAttribute<TbTelefone, Long> id;
	public static volatile SingularAttribute<TbTelefone, Date> tbTelefoneDataCadastro;
	public static volatile SingularAttribute<TbTelefone, String> tbTelefoneDdd;
	public static volatile SingularAttribute<TbTelefone, String> tbTelefoneNumero;
	public static volatile SingularAttribute<TbTelefone, String> tbTelefoneRamal;
	public static volatile SingularAttribute<TbTelefone, String> tbTelefoneTipo;
	public static volatile SingularAttribute<TbTelefone, TbPessoa> tbPessoa;
}
