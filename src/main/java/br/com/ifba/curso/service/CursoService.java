/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.dao.CursoDao;
import br.com.ifba.curso.dao.CursoIDao;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.service.GenericService;
import br.com.ifba.infrastructure.util.StringUtil;
/**
 *
 * @author Italo
 */
/**
 * Service específico do Curso.
 * Aqui ficam as regras de negócio do Curso.
 * Usa o StringUtil para validações.
 */
public class CursoService extends GenericService<Curso>
        implements CursoIService {
    
    /**
     * Construtor — passa o CursoDao para o GenericService
     */
    public CursoService() {
        super(new CursoDao());
    }

    /**
     * Salva um curso após validar as regras de negócio
     */
    @Override
    public Curso save(Curso curso) {
        // REGRA 1: Nome não pode ser vazio
        if (StringUtil.isNullOrEmpty(curso.getNome())) {
            throw new RuntimeException("O nome do curso não pode ser vazio!");
        }

        // REGRA 2: Nome deve ter pelo menos 3 caracteres
        if (!StringUtil.hasMinLength(curso.getNome(), 3)) {
            throw new RuntimeException("O nome deve ter pelo menos 3 caracteres!");
        }

        // REGRA 3: Código do curso não pode ser vazio
        if (StringUtil.isNullOrEmpty(curso.getCodigoCurso())) {
            throw new RuntimeException("O código do curso não pode ser vazio!");
        }

        // Se passou nas validações, salva via DAO
        return dao.save(curso);
    }

    /**
     * Atualiza um curso após validar as regras de negócio
     * @param curso
     */
    @Override
    public Curso update(Curso curso) {
        // Mesmas validações do save
        if (StringUtil.isNullOrEmpty(curso.getNome())) {
            throw new RuntimeException("O nome do curso não pode ser vazio!");
        }

        if (!StringUtil.hasMinLength(curso.getNome(), 3)) {
            throw new RuntimeException("O nome deve ter pelo menos 3 caracteres!");
        }

        if (StringUtil.isNullOrEmpty(curso.getCodigoCurso())) {
            throw new RuntimeException("O código do curso não pode ser vazio!");
        }

        return dao.update(curso);
    }
    
}
