/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import java.util.List;
/**
 *
 * @author Italo
 */
/**
 * Interface genérica que define as operações básicas de CRUD.
 * Qualquer entidade que herde de PersistenceEntity pode usar.
 * @param <Entity>
 */
public interface GenericIDao<Entity extends PersistenceEntity> {
    
     /**
     * Salva uma entidade no banco de dados
     * @param obj
     * @return 
     */
    public abstract Entity save(Entity obj);

    /**
     * Atualiza uma entidade existente no banco de dados
     * @param obj
     * @return 
     */
    public abstract Entity update(Entity obj);

    /**
     * Remove uma entidade do banco de dados
     * @param obj
     */
    public abstract void delete(Entity obj);

    /**
     * Retorna todas as entidades do banco de dados
     * @return 
     */
    public abstract List<Entity> findAll();

    /**
     * Busca uma entidade pelo seu ID (chave primária)
     * @param id
     * @return 
     */
    public abstract Entity findById(Long id);
}
