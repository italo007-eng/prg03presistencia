/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.service;

import br.com.ifba.infrastructure.dao.GenericIDao;
import br.com.ifba.infrastructure.entity.PersistenceEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Italo
 */

/**
 * Classe genérica Service.
 *
 * @param <Entity>
 * @Service → Bean do Spring na camada Service.
 * @Autowired → Spring injeta o DAO automaticamente.
 * Não precisamos mais fazer "new CursoDao()"!
 */
@Service
public abstract class GenericService<Entity extends PersistenceEntity>
        implements GenericIService<Entity> {
    
    @Autowired
    protected GenericIDao<Entity> dao;

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
