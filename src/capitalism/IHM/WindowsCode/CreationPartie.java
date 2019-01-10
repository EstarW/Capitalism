/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.WindowsCode;

import capitalism.Capitalism;
import capitalism.Controlleurs.ControlleursIHM.CreationPartieController;
import capitalism.Metier.Jeu;
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
public class CreationPartie {
    
    private Jeu j;
    private CreationPartieController c;
    
    public CreationPartie(Jeu j) throws IOException{
        
        this.j = j;
                FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Capitalism.class.getResource("IHM/Windows/CreationPartie.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 630, 400);
        Stage s = new Stage();
        s.setTitle("Capitalism - Création de partie");
        s.setResizable(false);
        s.setScene(scene);
        s.show();      
        
        c = new CreationPartieController();
        c.setJeu(j);
    }
}
