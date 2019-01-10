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
 * @author Azelat
 */
public class MenuJeu extends Parent implements Serializable{

    @FXML
    private final AnchorPane rootPane;
    private Menu_echapController controller;
    private Jeu jeu;
    
    public MenuJeu(Jeu jeu) throws IOException
    {
        rootPane = new AnchorPane();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Capitalism.class.getResource("IHM/Windows/menu_echap.fxml"));
        Parent root = loader.load();
        this.jeu = jeu;
        
        Scene scene = new Scene(root, 630, 400);
        Stage stage = new Stage();
        stage.setTitle("Menu");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        controller = new Menu_echapController();
        controller.setJeu(jeu);
        controller.setWindow(stage);
    }    

    public Jeu getJeu() {
        return jeu;
    }

    
}
