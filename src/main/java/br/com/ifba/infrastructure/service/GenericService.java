/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.service;

import br.com.ifba.infrastructure.dao.GenericIDao;
import br.com.ifba.infrastructure.entity.PersistenceEntity;
import java.util.List;
/**
 *
 * @author Italo
 */
/**
 * Classe genérica da camada Service.
 * Faz a ponte entre a View/Controller e o DAO.
 * Aqui ficam as regras de negócio comuns a todas as entidades.
 * @param <Entity>
 */
public abstract class GenericService<Entity extends PersistenceEntity>
        implements GenericIService<Entity> {
    
    // Referência ao DAO genérico
    // Cada Service específico vai fornecer o seu DAO
    protected GenericIDao<Entity> dao;

    /**
     * Construtor — recebe o DAO específico da entidade
     * @param dao
     */
    public GenericService(GenericIDao<Entity> dao) {
        this.dao = dao;
    }

    @Override
    public Entity save(Entity entity) {
        return dao.save(entity);
    }

    @Override
    public Entity update(Entity entity) {
        return dao.update(entity);
    }

    @Override
    public void delete(Entity entity) {
        dao.delete(entity);
    }

    @Override
    public List<Entity> findAll() {
        return dao.findAll();
    }

    @Override
    public Entity findById(Long id) {
        return dao.findById(id);
    }
    
}
