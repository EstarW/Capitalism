/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.WindowsCode;

import capitalism.Capitalism;
import capitalism.Controlleurs.ControlleursIHM.AccueilController;
import capitalism.Metier.Jeu;
import capitalism.test;
import java.io.File;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
        //FXMLLoader fxmlLoader = new FXMLLoader(new File("../src/capitalism/IHM/Windows/Accueil.fxml").toURI().toURL()); 
        //Parent root = FXMLLoader.load(test.class.getResource("/IHM/Windows/Accueil.fmxl"));
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Capitalism.class.getResource("IHM/Windows/Accueil.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 630, 400);
        Stage stage = new Stage();
        stage.setTitle("Capitalism - Accueil");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
        a = new AccueilController();
        a.setJeu(j);
    }
}
