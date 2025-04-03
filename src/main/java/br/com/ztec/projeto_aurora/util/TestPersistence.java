package br.com.ztec.projeto_aurora.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestPersistence {
    public static void main(String[] args) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto_aurora");
            System.out.println("EntityManagerFactory criado com sucesso!");
            emf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
