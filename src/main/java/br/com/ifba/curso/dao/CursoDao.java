/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.dao.GenericDao;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Italo
 */

/**
 * DAO específico do Curso.
 *
 * @Repository → Bean do Spring na camada DAO.
 * Herda todos os métodos CRUD do GenericDao.
 */
@Repository
public class CursoDao extends GenericDao<Curso> implements CursoIDao {
        // Métodos específicos do Curso podem ser adicionados aqui

}
