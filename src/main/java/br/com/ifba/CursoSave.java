/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba;

import br.com.ifba.curso.view.CursoListar;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
/**
 *
 * @author Italo
 */

/**
 * Classe principal do projeto.
 * @SpringBootApplication → inicializa todos os Beans do Spring.
 */
@SpringBootApplication
public class CursoSave {
    
    public static void main(String[] args) {

        // headless(false) → necessário para aplicações desktop com Swing
        ConfigurableApplicationContext context =
            new SpringApplicationBuilder(CursoSave.class)
                .headless(false)
                .run(args);

        // Pega o Bean do CursoListar gerenciado pelo Spring
        // Assim o @Autowired funciona corretamente!
        javax.swing.SwingUtilities.invokeLater(() -> {
            CursoListar tela = context.getBean(CursoListar.class);
            tela.setVisible(true);
        });
    }
    
}
