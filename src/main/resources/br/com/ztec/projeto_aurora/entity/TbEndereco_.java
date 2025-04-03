package br.com.ztec.projeto_aurora.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2025-04-03T16:30:05.527-0300")
@StaticMetamodel(TbEndereco.class)
public class TbEndereco_ {
	public static volatile SingularAttribute<TbEndereco, Long> id;
	public static volatile SingularAttribute<TbEndereco, String> tbEnderecoBairro;
	public static volatile SingularAttribute<TbEndereco, String> tbEnderecoCep;
	public static volatile SingularAttribute<TbEndereco, String> tbEnderecoCidade;
	public static volatile SingularAttribute<TbEndereco, String> tbEnderecoComplemento;
	public static volatile SingularAttribute<TbEndereco, Date> tbEnderecoDataCadastro;
	public static volatile SingularAttribute<TbEndereco, String> tbEnderecoLogradouro;
	public static volatile SingularAttribute<TbEndereco, String> tbEnderecoNumero;
	public static volatile SingularAttribute<TbEndereco, String> tbEnderecoTipo;
	public static volatile SingularAttribute<TbEndereco, String> tbEnderecoUf;
	public static volatile SingularAttribute<TbEndereco, TbPessoa> tbPessoa;
}
