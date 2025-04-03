package br.com.ztec.projeto_aurora.util;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

import br.com.ztec.projeto_aurora.entity.TbContato;
import br.com.ztec.projeto_aurora.entity.TbDocumento;
import br.com.ztec.projeto_aurora.entity.TbEmail;
import br.com.ztec.projeto_aurora.entity.TbEndereco;
import br.com.ztec.projeto_aurora.entity.TbPerfil;
import br.com.ztec.projeto_aurora.entity.TbPermissao;
import br.com.ztec.projeto_aurora.entity.TbPermissaoLista;
import br.com.ztec.projeto_aurora.entity.TbPessoa;
import br.com.ztec.projeto_aurora.entity.TbTelefone;
import br.com.ztec.projeto_aurora.entity.TbUsuario;

import java.util.EnumSet;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenerateDDL {
    public static void main(String[] args) {
        try {
            // Criando o EntityManagerFactory com o persistence.xml
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto_aurora");

            // Criando o service registry e configurando o Hibernate Dialect
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySetting("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect")
                    .applySetting("hibernate.connection.driver_class", "oracle.jdbc.OracleDriver")
                    .applySetting("hibernate.connection.url", "jdbc:oracle:thin:@//192.168.0.108:1521/XEPDB1")
                    .applySetting("hibernate.connection.username", "ROOT")
                    .applySetting("hibernate.connection.password", "root")
                    .build();

            // Construindo o Metadata a partir do persistence.xml
            MetadataSources metadataSources = new MetadataSources(serviceRegistry);

            // Aqui adicionamos as entidades manualmente
            metadataSources.addAnnotatedClass(TbContato.class); // Adicione suas entidades aqui
            metadataSources.addAnnotatedClass(TbDocumento.class); // Adicione suas entidades aqui
            metadataSources.addAnnotatedClass(TbEmail.class); // Adicione suas entidades aqui
            metadataSources.addAnnotatedClass(TbEndereco.class); // Adicione suas entidades aqui
            metadataSources.addAnnotatedClass(TbPerfil.class); // Adicione suas entidades aqui
            metadataSources.addAnnotatedClass(TbPermissao.class); // Adicione suas entidades aqui
            metadataSources.addAnnotatedClass(TbPessoa.class); // Adicione suas entidades aqui
            metadataSources.addAnnotatedClass(TbTelefone.class); // Adicione suas entidades aqui
            metadataSources.addAnnotatedClass(TbUsuario.class); // Adicione suas entidades aqui
            metadataSources.addAnnotatedClass(TbPermissaoLista.class); // Adicione suas entidades aqui

            Metadata metadata = metadataSources.buildMetadata();

            // Exportação do esquema para um arquivo SQL
            SchemaExport schemaExport = new SchemaExport();
            schemaExport.setDelimiter(";");
            schemaExport.setFormat(true);
            schemaExport.setOutputFile("output.sql");

            // Executando a exportação
            schemaExport.execute(EnumSet.of(TargetType.SCRIPT), SchemaExport.Action.CREATE, metadata);

            System.out.println("Arquivo SQL gerado com sucesso!");

            // Fechando o EntityManagerFactory
            emf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
