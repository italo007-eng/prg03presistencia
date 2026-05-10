/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.lang.reflect.ParameterizedType;
import java.util.List;
/**
 *
 * @author Italo
 */
/**
 * Classe genérica que implementa as operações CRUD para qualquer entidade.
 * Usa Generics do Java para funcionar com qualquer classe que
 * herde de PersistenceEntity (ex: Curso, Turma, etc).
 */
@SuppressWarnings("unchecked")
public class GenericDao<Entity extends PersistenceEntity> implements GenericIDao<Entity> {
    // EntityManager compartilhado por todos os DAOs
    protected static EntityManager entityManager;

    // Bloco estático — inicializa a conexão com o banco uma única vez
    static {
        EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("gerenciamento_curso");
        entityManager = factory.createEntityManager();
    }

    /**
     * Salva uma entidade no banco usando persist()
     */
    @Override
    public Entity save(Entity entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    /**
     * Atualiza uma entidade no banco usando merge()
     */
    @Override
    public Entity update(Entity entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    /**
     * Remove uma entidade do banco.
     * Primeiro busca pelo ID, depois remove.
     */
    @Override
    public void delete(Entity entity) {
        // Busca antes de remover (boa prática)
        entity = findById(entity.getId());
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    /**
     * Retorna todos os registros da entidade usando JPQL.
     * O getTypeClass() descobre automaticamente qual é a entidade.
     */
    @Override
    public List<Entity> findAll() {
        return entityManager
            .createQuery("from " + getTypeClass().getName())
            .getResultList();
    }

    /**
     * Busca uma entidade pelo ID (chave primária)
     */
    @Override
    public Entity findById(Long id) {
        return (Entity) entityManager.find(getTypeClass(), id);
    }

    /**
     * Retorna o tipo da classe genérica em execução.
     * Exemplo: se for CursoDao<Curso>, retorna Curso.class
     */
    protected Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>)
            ((ParameterizedType) this.getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
        return clazz;
    }
}
