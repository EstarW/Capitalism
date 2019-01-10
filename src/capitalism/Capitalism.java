/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism;

import capitalism.IHM.WindowsCode.Accueil;
import capitalism.Metier.Jeu;
import java.io.IOException;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javax.swing.JFrame;

/**
 *
 * @author Azelat
 */
public class Capitalism extends Application {
    
    private final double scaleX = 1;
    private final double scaleY = 1;
    private Accueil a;
    private Jeu j;



    @Override
    public void start(Stage primaryStage) throws IOException {
        JFrame test = new test();
        test.setVisible(true);
        j = new Jeu();
        a = new Accueil(j);
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
