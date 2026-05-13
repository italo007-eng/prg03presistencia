/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.service.GenericIService;
/**
 *
 * @author Italo
 */
/**
 * Interface específica do Service de Curso.
 * Herda todas as operações do GenericIService.
 * Métodos específicos do Curso podem ser adicionados aqui.
 */
public interface CursoIService extends GenericIService<Curso> {
     // Métodos específicos do Curso podem ser adicionados aqui
    // Exemplo: public List<Curso> findByAtivo(boolean ativo);
}
