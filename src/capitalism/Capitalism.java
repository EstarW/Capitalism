/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism;

import capitalism.IHM.Cases.ListeCase;
import capitalism.IHM.Interface.Bandeau;
import capitalism.IHM.Interface.BoutonMenuList;
import capitalism.Metier.Jeu;
import capitalism.Metier.Parties.Carte.Cases.Case;
import capitalism.Metier.Parties.Carte.Map;
import capitalism.Metier.Parties.Carte.Parseur.ParseurMap;
import capitalism.Metier.Parties.Partie;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Azelat
 */
public class Capitalism extends Application {
    
    private double X;
    private double Y;
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        Jeu j = new Jeu();
        j.newGame();
        Map m = j.getPartie().getMap();
        m.chargerFichier("Carte.txt");
        /*System.out.println(j.getPartie().getMap().getListeCases());*/
        ArrayList<Case> listeCase = j.getPartie().getMap().getListeCases();
        Pane root = new Pane(); 
        Scene scene = new Scene(root, 1200, 800);
        BoutonMenuList bl = new BoutonMenuList();
        
        ListeCase l = new ListeCase(j, m, listeCase);
        root.getChildren().add(l);
        Bandeau b = new Bandeau();
        root.getChildren().add(bl); 
        root.getChildren().add(b);
        
        primaryStage.setTitle("Capitalisme");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
