/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism;

import capitalism.IHM.Cases.ListeCase;
import capitalism.IHM.Interface.Bandeau;
import capitalism.IHM.Interface.BoutonMenuList;
import capitalism.Metier.Parties.Carte.Cases.Case;
import capitalism.Metier.Parties.Carte.Map;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Azelat
 */
public class Capitalism extends Application {
    
    private double scaleX = 1;
    private double scaleY = 1;

    @Override
    public void start(Stage primaryStage) throws IOException {
        
        
        Map m = new Map();
        m.chargerFichier("Carte.txt");
        ArrayList<Case> listeCase = m.getListeCases();
        ListeCase l = new ListeCase(m, listeCase);
        BoutonMenuList bl = new BoutonMenuList();
        Bandeau b = new Bandeau();

        
        Pane root = new StackPane(); 
        Pane menu = new Pane();
        Pane map = new Pane();
        Scene scene = new Scene(root, 1200, 800);
        
        map.getChildren().add(l);

        menu.getChildren().add(bl);
        menu.getChildren().add(b);
        root.getChildren().add(map);             
        root.getChildren().add(menu);   
        primaryStage.setTitle("Capitalisme");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        scene.setOnMouseClicked(event -> {
            map.setTranslateX(event.getX());
            map.setTranslateY(event.getY());
            event.consume();
        });
        
        
        scene.setOnMouseDragged(event -> {
            map.setTranslateX(event.getX());
            map.setTranslateY(event.getY());
            event.consume();
        });
        
        scene.setOnKeyPressed(event -> {
            if(event.getCode().equals(E))
            {
                if(scaleX < 3 && scaleY < 3)
                {
                    scaleX += 0.2;
                    scaleY += 0.2;
                    map.setScaleX(scaleX);
                    map.setScaleY(scaleY);
                }
            }
            if(event.getCode().equals(A))
            {
                if(scaleX > 0.3 && scaleY > 0.3)
                {
                    scaleX -= 0.2;
                    scaleY -= 0.2;
                    map.setScaleX(scaleX);
                    map.setScaleY(scaleY);
                }
            }
            

        });
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
