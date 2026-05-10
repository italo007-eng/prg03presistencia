/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.view;

import br.com.ifba.curso.dao.CursoDao;
import br.com.ifba.curso.dao.CursoIDao;
import br.com.ifba.curso.entity.Curso;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Italo
 */
/**
 * Tela de cadastro e edição de Curso.
 * Usada tanto para criar um novo curso quanto para editar um existente.
 */
public class CursoForm extends JFrame{
     // Campos do formulário
    private JTextField campoNome;
    private JTextField campoCodigo;
    private JCheckBox checkAtivo;
    private JButton btnSalvar;
    private JButton btnCancelar;

    // Curso que está sendo editado (null se for novo)
    private final Curso cursoParaEditar;

    // Referência para a tela de listagem (para atualizar após salvar)
    private final CursoListar telaListar;

    /**
     * Construtor — recebe um curso para editar (ou null para criar novo)
     * @param telaListar
     * @param cursoParaEditar
     */
    public CursoForm(CursoListar telaListar, Curso cursoParaEditar) {
        this.telaListar = telaListar;
        this.cursoParaEditar = cursoParaEditar;

        configurarJanela();
        inicializarComponentes();

        // Se estiver editando, preenche os campos com os dados do curso
        if (cursoParaEditar != null) {
            preencherCampos();
        }
    }

    private void configurarJanela() {
        setTitle(cursoParaEditar == null ? "Novo Curso" : "Editar Curso");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));
        getRootPane().setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
    }

    private void inicializarComponentes() {

        // Campo Nome
        add(new JLabel("Nome:"));
        campoNome = new JTextField();
        add(campoNome);

        // Campo Código do Curso
        add(new JLabel("Código do Curso:"));
        campoCodigo = new JTextField();
        add(campoCodigo);

        // CheckBox Ativo
        add(new JLabel("Ativo:"));
        checkAtivo = new JCheckBox();
        add(checkAtivo);

        // Botão Salvar
        btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> salvarCurso());
        add(btnSalvar);

        // Botão Cancelar
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose()); // Fecha apenas esta janela
        add(btnCancelar);
    }

    /**
     * Preenche os campos com os dados do curso sendo editado
     */
    private void preencherCampos() {
        campoNome.setText(cursoParaEditar.getNome());
        campoCodigo.setText(cursoParaEditar.getCodigoCurso());
        checkAtivo.setSelected(cursoParaEditar.isAtivo());
    }

    /**
     * Salva ou atualiza o curso no banco de dados.
     * Usa persist (novo) ou merge (edição).
     * Inclui tratamento de exceções.
     */
    private void salvarCurso() {

        // Validação básica dos campos
        if (campoNome.getText().isEmpty() || campoCodigo.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this,
            "Preencha todos os campos!", "Atenção",
            JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Usa o CursoDao em vez do EntityManager diretamente
    CursoIDao cursoDao = new CursoDao();

    try {
        if (cursoParaEditar == null) {
            // NOVO CURSO
            Curso novoCurso = new Curso();
            novoCurso.setNome(campoNome.getText());
            novoCurso.setCodigoCurso(campoCodigo.getText());
            novoCurso.setAtivo(checkAtivo.isSelected());

            cursoDao.save(novoCurso); // DAO faz o persist

        } else {
            // EDIÇÃO
            cursoParaEditar.setNome(campoNome.getText());
            cursoParaEditar.setCodigoCurso(campoCodigo.getText());
            cursoParaEditar.setAtivo(checkAtivo.isSelected());

            cursoDao.update(cursoParaEditar); // DAO faz o merge
        }

        JOptionPane.showMessageDialog(this,
            "Curso salvo com sucesso!", "Sucesso",
            JOptionPane.INFORMATION_MESSAGE);

        telaListar.carregarCursos();
        dispose();

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this,
            "Erro ao salvar: " + ex.getMessage(), "Erro",
            JOptionPane.ERROR_MESSAGE);
    }
    }
}
