/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.controller.GenericController;
import org.springframework.stereotype.Controller;
/**
 *
 * @author Italo
 */
/**
 * Controller específico do Curso.
 *
 * @Controller → Bean do Spring na camada Controller.
 */
@Controller
public class CursoController extends GenericController<Curso>
        implements CursoIController {
    
        // Métodos específicos do Curso podem ser adicionados aqui

}
