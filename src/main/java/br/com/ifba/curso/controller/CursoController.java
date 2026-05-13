/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.CursoIService;
import br.com.ifba.curso.service.CursoService;
import br.com.ifba.infrastructure.controller.GenericController;
/**
 *
 * @author Italo
 */
/**
 * Controller específico do Curso.
 * Recebe chamadas da View e repassa para o CursoService.
 * Não contém regras de negócio.
 */
public class CursoController extends GenericController<Curso>
        implements CursoIController {
    
    /**
     * Construtor — passa o CursoService para o GenericController
     */
    public CursoController() {
        super(new CursoService());
    }
}
