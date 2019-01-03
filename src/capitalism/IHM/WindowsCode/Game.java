/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.WindowsCode;


import capitalism.IHM.Cases.ListeCase;
import capitalism.IHM.Interface.Bandeau;
import capitalism.IHM.Interface.BoutonMenuList;
import capitalism.IHM.Interface.InfoPartie;
import capitalism.IHM.Interface.InfoTour;
import capitalism.Metier.Parties.Carte.Cases.Case;
import capitalism.Metier.Parties.Carte.Map;
import capitalism.Metier.Parties.Entreprises.Joueur;
import capitalism.Metier.Parties.Partie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;

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
    
    private Pane root;
    private StackPane inft;
    private InfoTour infot;
    
    private StackPane infp;
    private InfoPartie infop;
    
    private Partie p;
    private Joueur j;
    

    
    
    public Game(String eName, String pName) throws IOException
    {
        
        /*p = new Partie();
        p.ajouteEntreprise(new Joueur(eName,p));
        p.setJoueurDefaut();
        p.augmenterTour();*/
        Map m = new Map();
        m.chargerFichier("Carte.txt");
        ArrayList<Case> listeCase = m.getListeCases();
        
        
        
        ListeCase liste = new ListeCase(m, listeCase, p.getJoueurCourant(), this);
        BoutonMenuList bl = new BoutonMenuList(p, this);
        Bandeau b = new Bandeau();
        infop = new InfoPartie(p, p.getJoueurCourant());
        infot = new InfoTour(p);


        root = new Pane(); 
        StackPane bandeau = new StackPane();
        StackPane menu = new StackPane();
        StackPane map = new StackPane();
        infp = new StackPane();
        inft = new StackPane();
        
        infp.setPickOnBounds(false);
        inft.setPickOnBounds(false);
        menu.setPickOnBounds(false);
        bandeau.setPickOnBounds(false);


        Scene scene = new Scene(root, 1200, 800);
        Stage stage = new Stage();

        map.getChildren().add(liste);
        menu.getChildren().add(bl);
        bandeau.getChildren().add(b);
        infp.getChildren().add(infop);
        inft.getChildren().add(infot);

        
        root.getChildren().add(map);
        root.getChildren().add(bandeau);
        root.getChildren().add(menu);  
        root.getChildren().add(infp);
        root.getChildren().add(inft);
        
        
        map.setTranslateX(map.getTranslateX()-1500);

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
            
            if(event.getCode().equals(ESCAPE)) 
            {
                try {
                    MenuJeu mj = new MenuJeu();
                } catch (IOException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
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
    

    public Partie getP() {
        return p;
    }
    
    public void refreshTour(){
 
        inft.getChildren().remove(infot);
        root.getChildren().remove(inft);
        
        infot = new InfoTour(p);
        
        inft.getChildren().add(infot);
        root.getChildren().add(inft);
        
        infp.getChildren().remove(infop);
        root.getChildren().remove(infp); 
        infop = new InfoPartie(p, p.getJoueurCourant());
        infp.getChildren().add(infop);
        root.getChildren().add(infp);        
    }
}
