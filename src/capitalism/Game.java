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
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import static javafx.scene.input.KeyCode.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Azelat
 */
public class Game {
 
    
    private double scaleX = 1;
    private double scaleY = 1;
    
    private double xOffset = 0;
    private double yOffset = 0;
    
    private Stage echap;
    private Scene echapScene;
    
    public Game() throws IOException
    {
        Map m = new Map();
        m.chargerFichier("Carte.txt");
        ArrayList<Case> listeCase = m.getListeCases();
        ListeCase liste = new ListeCase(m, listeCase);
        BoutonMenuList bl = new BoutonMenuList();
        Bandeau b = new Bandeau();


        Pane root = new Pane(); 
        StackPane bandeau = new StackPane();
        StackPane menu = new StackPane();
        StackPane map = new StackPane();

        menu.setPickOnBounds(false);
        bandeau.setPickOnBounds(false);


        Scene scene = new Scene(root, 1200, 800);
        Stage stage = new Stage();

        map.getChildren().add(liste);

        menu.getChildren().add(bl);
        bandeau.getChildren().add(b);

        root.getChildren().add(map);
        root.getChildren().add(bandeau);
        root.getChildren().add(menu);  

        map.setTranslateX(map.getTranslateX()-1500);

        stage.setTitle("Capitalisme");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        
        FXMLLoader fxmlLoader = new FXMLLoader(new File("src/capitalism/IHM/Windows/Menu_echap.fxml").toURI().toURL());
        echapScene = new Scene(fxmlLoader.load(), 630, 400);
        echap = new Stage();
        echap.setTitle("Menu");
        echap.setResizable(false);
        echap.setScene(echapScene);


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
            
            if(event.getCode().equals(ESCAPE)) // Temporaire. En attente du menu en jeu.
            {
                echap.show(); 
                //stage.close();
            }
        });    
        
        
            map.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = map.getTranslateX() - event.getScreenX();
                yOffset = map.getTranslateY() - event.getScreenY();
            }
        });  
            
            map.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                map.setTranslateX(event.getScreenX() + xOffset);
                map.setTranslateY(event.getScreenY() + yOffset);
            }           
        });        
    }
}
