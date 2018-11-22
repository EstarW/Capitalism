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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import static javafx.scene.input.KeyCode.*;
import javafx.scene.layout.AnchorPane;
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
    private double X;
    private double Y;
    private double mapX;
    private double mapY;

    @Override
    public void start(Stage primaryStage) throws IOException {
        
        
        Map m = new Map();
        m.chargerFichier("Carte.txt");
        ArrayList<Case> listeCase = m.getListeCases();
        ListeCase l = new ListeCase(m, listeCase);
        BoutonMenuList bl = new BoutonMenuList();
        Bandeau b = new Bandeau();

        
        Pane root = new Pane(); 
        StackPane bandeau = new StackPane();
        StackPane menu = new StackPane();
        StackPane map = new StackPane();
        

        Scene scene = new Scene(root, 1200, 800);
   
        
        
        map.getChildren().add(l);

        menu.getChildren().add(bl);
        bandeau.getChildren().add(b);
        root.getChildren().add(map);  
        root.getChildren().add(bandeau);
        root.getChildren().add(menu);  
        
        
        primaryStage.setTitle("Capitalisme");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        scene.setOnMouseClicked(event -> {
            this.mapX = map.getTranslateX();
            this.mapY = map.getTranslateY();
            System.out.println(mapX);
        });
        
        scene.setOnMouseDragged(event -> {   
            map.setTranslateX(event.getX()-600);
            map.setTranslateY(event.getY()-400);
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
