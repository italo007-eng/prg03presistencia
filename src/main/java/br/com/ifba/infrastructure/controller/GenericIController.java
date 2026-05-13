/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.infrastructure.controller;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import java.util.List;
/**
 *
 * @author Italo
 */

/**
 * Interface genérica da camada Controller.
 * O Controller recebe as requisições da View e repassa para o Service.
 * @param <Entity>
 */
public interface GenericIController<Entity extends PersistenceEntity> {
    /**
     * Recebe a entidade da View e manda para o Service salvar
     * @param obj
     * @return 
     */
    public abstract Entity save(Entity obj);

    /**
     * Recebe a entidade da View e manda para o Service atualizar
     * @param obj
     * @return 
     */
    public abstract Entity update(Entity obj);

    /**
     * Recebe a entidade da View e manda para o Service remover
     * @param obj
     */
    public abstract void delete(Entity obj);

    /**
     * Solicita ao Service a lista de todas as entidades
     * @return 
     */
    public abstract List<Entity> findAll();

    /**
     * Solicita ao Service uma entidade pelo ID
     * @param id
     * @return 
     */
    public abstract Entity findById(Long id);
}
