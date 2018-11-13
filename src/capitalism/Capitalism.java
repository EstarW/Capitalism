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
import capitalism.Metier.Parties.Carte.Map;
import capitalism.Metier.Parties.Carte.Parseur.ParseurMap;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Azelat
 */
public class Capitalism extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Jeu j = new Jeu();
        Map map = new Map(j);
        ParseurMap p = new ParseurMap("test.txt", map);
        StackPane root = new StackPane();   
        Scene scene = new Scene(root, 1200, 800);
        BoutonMenuList bl = new BoutonMenuList();
        ListeCase l = new ListeCase();
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
