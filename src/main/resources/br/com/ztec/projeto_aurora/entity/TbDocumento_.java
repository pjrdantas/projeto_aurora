package br.com.ztec.projeto_aurora.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2025-04-03T16:30:05.524-0300")
@StaticMetamodel(TbDocumento.class)
public class TbDocumento_ {
	public static volatile SingularAttribute<TbDocumento, Long> id;
	public static volatile SingularAttribute<TbDocumento, String> tbDocumentoCnpj;
	public static volatile SingularAttribute<TbDocumento, String> tbDocumentoCpf;
	public static volatile SingularAttribute<TbDocumento, String> tbDocumentoFuncional;
	public static volatile SingularAttribute<TbDocumento, String> tbDocumentoInscrEst;
	public static volatile SingularAttribute<TbDocumento, String> tbDocumentoInscrMun;
	public static volatile SingularAttribute<TbDocumento, String> tbDocumentoRg;
	public static volatile SingularAttribute<TbDocumento, TbPessoa> tbPessoa;
}
