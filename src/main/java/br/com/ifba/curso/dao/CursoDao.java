/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.dao.GenericDao;
/**
 *
 * @author Italo
 */

/**
 * DAO específico do Curso.
 * Herda todos os métodos CRUD do GenericDao (save, update, delete, findAll, findById).
 * Não precisa reescrever nenhum método que já existe no GenericDao!
 * 
 * Só adiciona métodos específicos do Curso que não existem no GenericDao.
 */
public class CursoDao extends GenericDao<Curso> implements CursoIDao {
    // Os métodos save, update, delete, findAll e findById
    // já estão implementados no GenericDao!
    // Adicione aqui apenas métodos específicos do Curso.
}
