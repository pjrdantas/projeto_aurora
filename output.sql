
    create table TB_CONTATO (
       id number(19,0) generated as identity,
        TB_CONTATO_DATA_CADASTRO date,
        TB_CONTATO_NOME varchar2(255 char),
        TB_CONTATO_TIPO varchar2(255 char),
        TB_PESSOA_ID number(19,0),
        primary key (id)
    );

    create table TB_DOCUMENTO (
       id number(19,0) generated as identity,
        TB_DOCUMENTO_CNPJ varchar2(255 char),
        TB_DOCUMENTO_CPF varchar2(255 char),
        TB_DOCUMENTO_FUNCIONAL varchar2(255 char),
        TB_DOCUMENTO_INSCR_EST varchar2(255 char),
        TB_DOCUMENTO_INSCR_MUN varchar2(255 char),
        TB_DOCUMENTO_RG varchar2(255 char),
        TB_PESSOA_ID number(19,0),
        primary key (id)
    );

    create table TB_EMAIL (
       id number(19,0) generated as identity,
        TB_EMAIL_DATA_CADASTRO date,
        TB_EMAIL_DESCR varchar2(255 char),
        TB_EMAIL_TIPO varchar2(255 char),
        TB_PESSOA_ID number(19,0),
        primary key (id)
    );

    create table TB_ENDERECO (
       id number(19,0) generated as identity,
        TB_ENDERECO_BAIRRO varchar2(255 char),
        TB_ENDERECO_CEP varchar2(255 char),
        TB_ENDERECO_CIDADE varchar2(255 char),
        TB_ENDERECO_COMPLEMENTO varchar2(255 char),
        TB_ENDERECO_DATA_CADASTRO date,
        TB_ENDERECO_LOGRADOURO varchar2(255 char),
        TB_ENDERECO_NUMERO varchar2(255 char),
        TB_ENDERECO_TIPO varchar2(255 char),
        TB_ENDERECO_UF varchar2(255 char),
        TB_PESSOA_ID number(19,0),
        primary key (id)
    );

    create table TB_PERFIL (
       id number(19,0) generated as identity,
        TB_PERFIL_DESCRICAO varchar2(255 char),
        TB_PERFIL_NOME varchar2(255 char),
        TB_USUARIO_ID number(19,0),
        primary key (id)
    );

    create table TB_PERMISSAO (
       id number(19,0) generated as identity,
        TB_PERMISSAO_CODIGO varchar2(255 char),
        TB_PERMISSAO_DESCRICAO varchar2(255 char),
        primary key (id)
    );

    create table TB_PERMISSAO_LISTA (
       id number(19,0) generated as identity,
        TB_PERFIL_ID number(19,0),
        TB_PERMISSAO_ID number(19,0),
        primary key (id)
    );

    create table TB_PESSOA (
       id number(19,0) generated as identity,
        TB_PESSOA_ATIVO number(19,2),
        TB_PESSOA_DATA_CADASTRO date,
        TB_PESSOA_DATA_NASC_ABERTURA date,
        TB_PESSOA_ISENTO number(19,2),
        TB_PESSOA_NOME_RAZAO_SOCIAL varchar2(255 char),
        TB_PESSOA_PESS_EXP_POLIT number(19,2),
        TB_PESSOA_PF_PJ varchar2(255 char),
        TB_PESSOA_SEXO varchar2(255 char),
        primary key (id)
    );

    create table TB_TELEFONE (
       id number(19,0) generated as identity,
        TB_TELEFONE_DATA_CADASTRO date,
        TB_TELEFONE_DDD varchar2(255 char),
        TB_TELEFONE_NUMERO varchar2(255 char),
        TB_TELEFONE_RAMAL varchar2(255 char),
        TB_TELEFONE_TIPO varchar2(255 char),
        TB_PESSOA_ID number(19,0),
        primary key (id)
    );

    create table TB_USUARIO (
       id number(19,0) generated as identity,
        TB_USUARIO_ATIVO number(19,2),
        TB_USUARIO_DATA_CADASTRADO date,
        TB_USUARIO_LOGIN varchar2(255 char),
        TB_USUARIO_NOME varchar2(255 char),
        TB_USUARIO_SENHA varchar2(255 char),
        TB_PESSOA_ID number(19,0),
        primary key (id)
    );

    alter table TB_CONTATO 
       add constraint FKpeqmm53ocfeor4fpgc3avcaxo 
       foreign key (TB_PESSOA_ID) 
       references TB_PESSOA;

    alter table TB_DOCUMENTO 
       add constraint FKqmxxaf6qfv1e44o3gr1ptow77 
       foreign key (TB_PESSOA_ID) 
       references TB_PESSOA;

    alter table TB_EMAIL 
       add constraint FK6ui4h9to5icwbkhx0jeyn3whn 
       foreign key (TB_PESSOA_ID) 
       references TB_PESSOA;

    alter table TB_ENDERECO 
       add constraint FK51gjuiocatr3exy3022yvaljj 
       foreign key (TB_PESSOA_ID) 
       references TB_PESSOA;

    alter table TB_PERFIL 
       add constraint FKnd8a04qqoesmsok8lb4fr5oxg 
       foreign key (TB_USUARIO_ID) 
       references TB_USUARIO;

    alter table TB_PERMISSAO_LISTA 
       add constraint FKjmc6bmv4cfiyhgrjd8jek3xt9 
       foreign key (TB_PERFIL_ID) 
       references TB_PERFIL;

    alter table TB_PERMISSAO_LISTA 
       add constraint FK7c0dh9revfcjnfo1asmvlqcbj 
       foreign key (TB_PERMISSAO_ID) 
       references TB_PERMISSAO;

    alter table TB_TELEFONE 
       add constraint FK4th7nr06v1rigo34bl22ps3nr 
       foreign key (TB_PESSOA_ID) 
       references TB_PESSOA;

    alter table TB_USUARIO 
       add constraint FKgqxd6ps86ittahvjodui87737 
       foreign key (TB_PESSOA_ID) 
       references TB_PESSOA;

    create table TB_CONTATO (
       id number(19,0) generated as identity,
        TB_CONTATO_DATA_CADASTRO date,
        TB_CONTATO_NOME varchar2(255 char),
        TB_CONTATO_TIPO varchar2(255 char),
        TB_PESSOA_ID number(19,0),
        primary key (id)
    );

    create table TB_DOCUMENTO (
       id number(19,0) generated as identity,
        TB_DOCUMENTO_CNPJ varchar2(255 char),
        TB_DOCUMENTO_CPF varchar2(255 char),
        TB_DOCUMENTO_FUNCIONAL varchar2(255 char),
        TB_DOCUMENTO_INSCR_EST varchar2(255 char),
        TB_DOCUMENTO_INSCR_MUN varchar2(255 char),
        TB_DOCUMENTO_RG varchar2(255 char),
        TB_PESSOA_ID number(19,0),
        primary key (id)
    );

    create table TB_EMAIL (
       id number(19,0) generated as identity,
        TB_EMAIL_DATA_CADASTRO date,
        TB_EMAIL_DESCR varchar2(255 char),
        TB_EMAIL_TIPO varchar2(255 char),
        TB_PESSOA_ID number(19,0),
        primary key (id)
    );

    create table TB_ENDERECO (
       id number(19,0) generated as identity,
        TB_ENDERECO_BAIRRO varchar2(255 char),
        TB_ENDERECO_CEP varchar2(255 char),
        TB_ENDERECO_CIDADE varchar2(255 char),
        TB_ENDERECO_COMPLEMENTO varchar2(255 char),
        TB_ENDERECO_DATA_CADASTRO date,
        TB_ENDERECO_LOGRADOURO varchar2(255 char),
        TB_ENDERECO_NUMERO varchar2(255 char),
        TB_ENDERECO_TIPO varchar2(255 char),
        TB_ENDERECO_UF varchar2(255 char),
        TB_PESSOA_ID number(19,0),
        primary key (id)
    );

    create table TB_PERFIL (
       id number(19,0) generated as identity,
        TB_PERFIL_DESCRICAO varchar2(255 char),
        TB_PERFIL_NOME varchar2(255 char),
        TB_USUARIO_ID number(19,0),
        primary key (id)
    );

    create table TB_PERMISSAO (
       id number(19,0) generated as identity,
        TB_PERMISSAO_CODIGO varchar2(255 char),
        TB_PERMISSAO_DESCRICAO varchar2(255 char),
        primary key (id)
    );

    create table TB_PERMISSAO_LISTA (
       id number(19,0) generated as identity,
        TB_PERFIL_ID number(19,0),
        TB_PERMISSAO_ID number(19,0),
        primary key (id)
    );

    create table TB_PESSOA (
       id number(19,0) generated as identity,
        TB_PESSOA_ATIVO number(19,2),
        TB_PESSOA_DATA_CADASTRO date,
        TB_PESSOA_DATA_NASC_ABERTURA date,
        TB_PESSOA_ISENTO number(19,2),
        TB_PESSOA_NOME_RAZAO_SOCIAL varchar2(255 char),
        TB_PESSOA_PESS_EXP_POLIT number(19,2),
        TB_PESSOA_PF_PJ varchar2(255 char),
        TB_PESSOA_SEXO varchar2(255 char),
        primary key (id)
    );

    create table TB_TELEFONE (
       id number(19,0) generated as identity,
        TB_TELEFONE_DATA_CADASTRO date,
        TB_TELEFONE_DDD varchar2(255 char),
        TB_TELEFONE_NUMERO varchar2(255 char),
        TB_TELEFONE_RAMAL varchar2(255 char),
        TB_TELEFONE_TIPO varchar2(255 char),
        TB_PESSOA_ID number(19,0),
        primary key (id)
    );

    create table TB_USUARIO (
       id number(19,0) generated as identity,
        TB_USUARIO_ATIVO number(19,2),
        TB_USUARIO_DATA_CADASTRADO date,
        TB_USUARIO_LOGIN varchar2(255 char),
        TB_USUARIO_NOME varchar2(255 char),
        TB_USUARIO_SENHA varchar2(255 char),
        TB_PESSOA_ID number(19,0),
        primary key (id)
    );

    alter table TB_CONTATO 
       add constraint FKpeqmm53ocfeor4fpgc3avcaxo 
       foreign key (TB_PESSOA_ID) 
       references TB_PESSOA;

    alter table TB_DOCUMENTO 
       add constraint FKqmxxaf6qfv1e44o3gr1ptow77 
       foreign key (TB_PESSOA_ID) 
       references TB_PESSOA;

    alter table TB_EMAIL 
       add constraint FK6ui4h9to5icwbkhx0jeyn3whn 
       foreign key (TB_PESSOA_ID) 
       references TB_PESSOA;

    alter table TB_ENDERECO 
       add constraint FK51gjuiocatr3exy3022yvaljj 
       foreign key (TB_PESSOA_ID) 
       references TB_PESSOA;

    alter table TB_PERFIL 
       add constraint FKnd8a04qqoesmsok8lb4fr5oxg 
       foreign key (TB_USUARIO_ID) 
       references TB_USUARIO;

    alter table TB_PERMISSAO_LISTA 
       add constraint FKjmc6bmv4cfiyhgrjd8jek3xt9 
       foreign key (TB_PERFIL_ID) 
       references TB_PERFIL;

    alter table TB_PERMISSAO_LISTA 
       add constraint FK7c0dh9revfcjnfo1asmvlqcbj 
       foreign key (TB_PERMISSAO_ID) 
       references TB_PERMISSAO;

    alter table TB_TELEFONE 
       add constraint FK4th7nr06v1rigo34bl22ps3nr 
       foreign key (TB_PESSOA_ID) 
       references TB_PESSOA;

    alter table TB_USUARIO 
       add constraint FKgqxd6ps86ittahvjodui87737 
       foreign key (TB_PESSOA_ID) 
       references TB_PESSOA;
