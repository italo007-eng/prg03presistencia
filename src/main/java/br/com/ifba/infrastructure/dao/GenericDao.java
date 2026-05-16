/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Italo
 */
/**
 * Classe genérica DAO.
 *
 * @param <Entity>
 * @Repository → Bean do Spring na camada DAO.
 * @PersistenceContext → Spring injeta o EntityManager automaticamente.
 * @Transactional → Spring gerencia as transações automaticamente.
 */
@Repository
@SuppressWarnings("unchecked")
public class GenericDao<Entity extends PersistenceEntity> implements GenericIDao<Entity> {
    
    // Spring injeta automaticamente — não precisa mais de EntityManagerFactory!
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    @Transactional
    public Entity save(Entity entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    @Transactional
    public Entity update(Entity entity) {
        entityManager.merge(entity);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Entity entity) {
        entity = findById(entity.getId());
        entityManager.remove(entity);
    }

    @Override
    public List<Entity> findAll() {
        return entityManager
            .createQuery("from " + getTypeClass().getName())
            .getResultList();
    }

    @Override
    public Entity findById(Long id) {
        return (Entity) entityManager.find(getTypeClass(), id);
    }

    /**
     * Retorna o tipo da classe genérica em execução.
     * Exemplo: CursoDao → retorna Curso.class
     * @return 
     */
    protected Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>)
            ((ParameterizedType) this.getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
        return clazz;
    }
}
