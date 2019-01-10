/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.WindowsCode;

import capitalism.Capitalism;
import capitalism.Controlleurs.ControlleursIHM.ListeUsineJoueur2Controller;
import capitalism.Controlleurs.ControlleursIHM.NecessaireDeSurvie.NecessaireDeSurvieGestion;
import java.io.File;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Azelat
 */
public class Gestion extends Parent {
 
    private final AnchorPane rootPane;
    private ListeUsineJoueur2Controller controller;
    private Game g;
    public Gestion(Game g) throws IOException
    {
        rootPane = new AnchorPane();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Capitalism.class.getResource("IHM/Windows/listeUsineJoueur2.fxml"));
        Parent root = loader.load();
        this.g = g;
        NecessaireDeSurvieGestion.setG(g);
        ListeUsineJoueur2Controller.setGame(g);
        Scene scene = new Scene(root, 630, 400);
        Stage stage = new Stage();
        stage.setTitle("Liste d'Usine");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();  
        this.controller = new ListeUsineJoueur2Controller();
        
        
    }
}
