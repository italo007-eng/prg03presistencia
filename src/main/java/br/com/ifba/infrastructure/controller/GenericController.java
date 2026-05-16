/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.controller;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import br.com.ifba.infrastructure.service.GenericIService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Italo
 */
/**
 * Classe genérica Controller.
 *
 * @param <Entity>
 * @Controller → Bean do Spring na camada Controller.
 * @Autowired → Spring injeta o Service automaticamente.
 */
@Controller
public abstract class GenericController<Entity extends PersistenceEntity>
        implements GenericIController<Entity> {
    
     @Autowired
    protected GenericIService<Entity> service;

    @Override
    public Entity save(Entity entity) {
        return service.save(entity);
    }

    @Override
    public Entity update(Entity entity) {
        return service.update(entity);
    }

    @Override
    public void delete(Entity entity) {
        service.delete(entity);
    }

    @Override
    public List<Entity> findAll() {
        return service.findAll();
    }

    @Override
    public Entity findById(Long id) {
        return service.findById(id);
    }
}
