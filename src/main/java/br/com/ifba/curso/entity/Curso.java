/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.entity;
// Importações das anotações JPA (Jakarta Persistence)
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/**
 *
 * @author Italo
 */
/**
 * Classe que representa a entidade Curso no banco de dados.
 * 
 * @Entity  → Indica ao Hibernate que essa classe será persistida no banco
 * @Table   → Define o nome da tabela no banco (será "cursos")
 */
@Entity
@Table(name = "cursos")
public class Curso {
     /**
     * @Id             → Define este atributo como chave primária
     * @GeneratedValue → O banco gera o valor automaticamente (auto increment)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * @Column → Define o nome da coluna, e que não pode ser nulo
     */
    @Column(name = "nome", nullable = false)
    private String nome;

    /**
     * Código único do curso — não pode ser nulo nem repetido
     */
    @Column(name = "codigo_curso", nullable = false, unique = true)
    private String codigoCurso;

    /**
     * Indica se o curso está ativo ou não
     */
    @Column(name = "ativo")
    private boolean ativo;

    // ========================
    // MÉTODOS GETTERS E SETTERS
    // ========================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
