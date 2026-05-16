/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.view;

import br.com.ifba.curso.controller.CursoIController;
import br.com.ifba.curso.entity.Curso;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author Italo
 */
/**
 * Tela de cadastro e edição de Curso.
 * @Component → Bean gerenciado pelo Spring.
 * @Scope("prototype") → cria uma nova instância cada vez que for chamado.
 */
public class CursoForm extends JFrame{
    // Recebido por parâmetro — não precisa de @Autowired
    private CursoIController cursoController;

    private JTextField campoNome;
    private JTextField campoCodigo;
    private JCheckBox checkAtivo;
    private JButton btnSalvar;
    private JButton btnCancelar;

    private final Curso cursoParaEditar;
    private final CursoListar telaListar;

    /**
     * Construtor — recebe o controller, a tela e o curso para editar
     * @param telaListar
     * @param cursoParaEditar
     * @param cursoController
     */
    public CursoForm(CursoListar telaListar, Curso cursoParaEditar,
                     CursoIController cursoController) {
        this.telaListar = telaListar;
        this.cursoParaEditar = cursoParaEditar;
        this.cursoController = cursoController; // recebe pronto!

        configurarJanela();
        inicializarComponentes();

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
        add(new JLabel("Nome:"));
        campoNome = new JTextField();
        add(campoNome);

        add(new JLabel("Código do Curso:"));
        campoCodigo = new JTextField();
        add(campoCodigo);

        add(new JLabel("Ativo:"));
        checkAtivo = new JCheckBox();
        add(checkAtivo);

        btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> salvarCurso());
        add(btnSalvar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        add(btnCancelar);
    }

    private void preencherCampos() {
        campoNome.setText(cursoParaEditar.getNome());
        campoCodigo.setText(cursoParaEditar.getCodigoCurso());
        checkAtivo.setSelected(cursoParaEditar.isAtivo());
    }

    private void salvarCurso() {
        if (campoNome.getText().isEmpty() || campoCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Preencha todos os campos!", "Atenção",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            if (cursoParaEditar == null) {
                Curso novoCurso = new Curso();
                novoCurso.setNome(campoNome.getText());
                novoCurso.setCodigoCurso(campoCodigo.getText());
                novoCurso.setAtivo(checkAtivo.isSelected());
                cursoController.save(novoCurso);
            } else {
                cursoParaEditar.setNome(campoNome.getText());
                cursoParaEditar.setCodigoCurso(campoCodigo.getText());
                cursoParaEditar.setAtivo(checkAtivo.isSelected());
                cursoController.update(cursoParaEditar);
            }

            JOptionPane.showMessageDialog(this,
                "Curso salvo com sucesso!", "Sucesso",
                JOptionPane.INFORMATION_MESSAGE);

            telaListar.carregarCursos();
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                ex.getMessage(), "Erro",
                JOptionPane.ERROR_MESSAGE);
        }
    }
}
