/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.dao.GenericIDao;
/**
 *
 * @author Italo
 */
/**
 * Interface específica do Curso.
 * Herda todos os métodos CRUD do GenericIDao.
 * Aqui podem ser adicionados métodos específicos do Curso
 * que não existem no GenericIDao (ex: findByNome).
 */
public interface CursoIDao extends GenericIDao<Curso> {
    // Métodos específicos do Curso podem ser adicionados aqui futuramente
    // Exemplo: public Curso findByNome(String nome);
}
