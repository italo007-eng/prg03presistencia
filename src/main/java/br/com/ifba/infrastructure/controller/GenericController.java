/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.controller;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import br.com.ifba.infrastructure.service.GenericIService;
import java.util.List;

/**
 *
 * @author Italo
 */
/**
 * Classe genérica da camada Controller.
 * Recebe chamadas da View e repassa para o Service.
 * Não contém regras de negócio — só faz a ponte entre View e Service.
 * @param <Entity>
 */
public abstract class GenericController<Entity extends PersistenceEntity>
        implements GenericIController<Entity> {
    
     // Referência ao Service genérico
    protected GenericIService<Entity> service;

    /**
     * Construtor — recebe o Service específico da entidade
     * @param service
     */
    public GenericController(GenericIService<Entity> service) {
        this.service = service;
    }

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
