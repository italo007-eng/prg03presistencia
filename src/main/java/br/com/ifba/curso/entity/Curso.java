/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.entity;
// Importações das anotações JPA (Jakarta Persistence)
import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serializable;
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
public class Curso extends PersistenceEntity implements Serializable {
    
    
    /**
     * Nome do curso — não pode ser nulo
     */
    @Column(name = "nome", nullable = false)
    private String nome;

    /**
     * Código único do curso — não pode ser nulo nem repetido
     */
    @Column(name = "codigo_curso", nullable = false, unique = true)
    private String codigoCurso;

    /**
     * Indica se o curso está ativo
     */
    @Column(name = "ativo")
    private boolean ativo;

    // ===== GETTERS E SETTERS =====

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
