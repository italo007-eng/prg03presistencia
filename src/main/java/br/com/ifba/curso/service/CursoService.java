/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.service.GenericService;
import br.com.ifba.infrastructure.util.StringUtil;
import org.springframework.stereotype.Service;
/**
 *
 * @author Italo
 */

/**
 * Service específico do Curso.
 *
 * @Service → Bean do Spring na camada Service.
 * Aqui ficam as regras de negócio do Curso.
 */
@Service
public class CursoService extends GenericService<Curso>
        implements CursoIService {
    
    @Override
    public Curso save(Curso curso) {
        if (StringUtil.isNullOrEmpty(curso.getNome())) {
            throw new RuntimeException("O nome não pode ser vazio!");
        }
        if (!StringUtil.hasMinLength(curso.getNome(), 3)) {
            throw new RuntimeException("O nome deve ter pelo menos 3 caracteres!");
        }
        if (StringUtil.isNullOrEmpty(curso.getCodigoCurso())) {
            throw new RuntimeException("O código não pode ser vazio!");
        }
        return dao.save(curso);
    }

    @Override
    public Curso update(Curso curso) {
        if (StringUtil.isNullOrEmpty(curso.getNome())) {
            throw new RuntimeException("O nome não pode ser vazio!");
        }
        if (!StringUtil.hasMinLength(curso.getNome(), 3)) {
            throw new RuntimeException("O nome deve ter pelo menos 3 caracteres!");
        }
        if (StringUtil.isNullOrEmpty(curso.getCodigoCurso())) {
            throw new RuntimeException("O código não pode ser vazio!");
        }
        return dao.update(curso);
    }
    
}
