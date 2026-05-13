/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.infrastructure.service;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import java.util.List;
/**
 *
 * @author Italo
 */
/**
 * Interface genérica da camada Service.
 * Define as operações de negócio básicas para qualquer entidade.
 * @param <Entity>
 */
public interface GenericIService<Entity extends PersistenceEntity> {
     /**
     * Salva uma entidade após validar as regras de negócio
     * @param obj
     * @return 
     */
    public abstract Entity save(Entity obj);

    /**
     * Atualiza uma entidade após validar as regras de negócio
     * @param obj
     * @return 
     */
    public abstract Entity update(Entity obj);

    /**
     * Remove uma entidade
     * @param obj
     */
    public abstract void delete(Entity obj);

    /**
     * Retorna todas as entidades
     * @return 
     */
    public abstract List<Entity> findAll();

    /**
     * Busca uma entidade pelo ID
     * @param id
     * @return 
     */
    public abstract Entity findById(Long id);
}
