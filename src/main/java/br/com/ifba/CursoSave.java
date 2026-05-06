/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba;

import br.com.ifba.curso.view.CursoListar;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javax.swing.SwingUtilities;
/**
 *
 * @author Italo
 */

/**
 * Classe principal do projeto.
 * Por enquanto apenas inicializa a aplicação.
 * A lógica de salvar será implementada nas próximas aulas.
 */
public class CursoSave {
    // Lê o persistence.xml e inicializa a conexão com o banco
    // O nome "gerenciamento_curso" é o mesmo do persistence-unit no XML
    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("gerenciamento_curso");

    // Cria o EntityManager a partir da factory
    private static final EntityManager entityManager =
            entityManagerFactory.createEntityManager();

    /**
     * Retorna o EntityManager para ser usado nas outras classes
     * @return 
     */
    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public static void main(String[] args) {

        // Abre a tela principal da aplicação
        SwingUtilities.invokeLater(() -> {
            new CursoListar().setVisible(true);
        });
    }
}
