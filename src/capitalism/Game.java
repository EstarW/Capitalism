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

import javafx.scene.Scene;
import static javafx.scene.input.KeyCode.*;
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


        stage.setTitle("Capitalisme");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();


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
            if(event.getCode().equals(D))
            {
                map.setTranslateX(map.getTranslateX()+20);
            }
            if(event.getCode().equals(S))
            {
                 map.setTranslateY(map.getTranslateY()+20);               
            }
            if(event.getCode().equals(Z))
            {
                map.setTranslateY(map.getTranslateY()-20);               
            }
            if(event.getCode().equals(Q))
            {
                map.setTranslateX(map.getTranslateX()-20);               
            }


        });        
        
        
    }
}
