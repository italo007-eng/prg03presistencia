/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
/**
 *
 * @author Italo
 */
/**
 * Classe base para todas as entidades do sistema.
 * Contém apenas o ID, que é comum a todas as entidades.
 * 
 * @MappedSuperclass → indica que esta classe não é uma tabela,
 * mas seus atributos serão herdados pelas subclasses.
 */
@MappedSuperclass
public class PersistenceEntity {
    // Chave primária comum a todas as entidades
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
