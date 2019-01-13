/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.WindowsCode;

import capitalism.Capitalism;
import capitalism.Controlleurs.ControlleursIHM.Menu_echapController;
import capitalism.Metier.Jeu;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 *
 * @author Beelzed
 */
public class Options {

    public Options() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Capitalism.class.getResource("IHM/Windows/Options.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 180, 90);
        Stage stage = new Stage();
        stage.setTitle("Menu de contrat");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    
    
}
