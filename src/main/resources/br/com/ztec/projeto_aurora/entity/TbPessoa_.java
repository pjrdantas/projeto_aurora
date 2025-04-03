package br.com.ztec.projeto_aurora.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2025-04-03T16:30:05.534-0300")
@StaticMetamodel(TbPessoa.class)
public class TbPessoa_ {
	public static volatile SingularAttribute<TbPessoa, Long> id;
	public static volatile SingularAttribute<TbPessoa, BigDecimal> tbPessoaAtivo;
	public static volatile SingularAttribute<TbPessoa, Date> tbPessoaDataCadastro;
	public static volatile SingularAttribute<TbPessoa, Date> tbPessoaDataNascAbertura;
	public static volatile SingularAttribute<TbPessoa, BigDecimal> tbPessoaIsento;
	public static volatile SingularAttribute<TbPessoa, String> tbPessoaNomeRazaoSocial;
	public static volatile SingularAttribute<TbPessoa, BigDecimal> tbPessoaPessExpPolit;
	public static volatile SingularAttribute<TbPessoa, String> tbPessoaPfPj;
	public static volatile SingularAttribute<TbPessoa, String> tbPessoaSexo;
	public static volatile ListAttribute<TbPessoa, TbContato> tbContatos;
	public static volatile ListAttribute<TbPessoa, TbDocumento> tbDocumentos;
	public static volatile ListAttribute<TbPessoa, TbEmail> tbEmails;
	public static volatile ListAttribute<TbPessoa, TbEndereco> tbEnderecos;
	public static volatile ListAttribute<TbPessoa, TbTelefone> tbTelefones;
	public static volatile ListAttribute<TbPessoa, TbUsuario> tbUsuarios;
}
