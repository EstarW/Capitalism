/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.WindowsCode;

import capitalism.Controlleurs.ControlleursIHM.AccueilController;
import capitalism.Metier.Jeu;
import java.io.File;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Azelat
 */
public class Accueil {
    
    private Jeu j;
    private AccueilController a;
    
    public Accueil(Jeu j) throws IOException{
        
        this.j = j;
        FXMLLoader fxmlLoader = new FXMLLoader(new File("src/capitalism/IHM/Windows/Accueil.fxml").toURI().toURL()); 
        Scene scene = new Scene(fxmlLoader.load(), 630, 400);
        Stage stage = new Stage();
        stage.setTitle("Capitalism - Accueil");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
        a = new AccueilController();
        a.setJeu(j);
    }
}
