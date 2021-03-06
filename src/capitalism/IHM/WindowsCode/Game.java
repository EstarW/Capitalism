/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.WindowsCode;


import capitalism.Controlleurs.Controlleur_Jeu;
import capitalism.Controlleurs.ControlleursIHM.NecessaireDeSurvie.NecessaireDeSurvieGestion;
import capitalism.Controlleurs.ControlleursIHM.NecessaireDeSurvie.NecessaireDeSurvieSauvegarde;
import capitalism.IHM.Cases.ListeCase;
import capitalism.IHM.Interface.Bandeau;
import capitalism.IHM.Interface.BoutonMenuList;
import capitalism.IHM.Interface.InfoPartie;
import capitalism.IHM.Interface.InfoTour;
import capitalism.Metier.Jeu;
import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Metier.Parties.Partie;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;

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
public class Game implements Serializable{
 
    
    private double scaleX = 1;
    private double scaleY = 1;
    
    private double xOffset = 0;
    private double yOffset = 0;
    
    private final Pane root;
    private final StackPane inft;
    private InfoTour infot;
    
    private final StackPane infp;
    private InfoPartie infop;
    private StackPane map;
    
    private final Jeu jeu;
    private final Controlleur_Jeu control;
    

    
    
    public Game(String eName, String pName, Jeu j) throws IOException
    {
        NecessaireDeSurvieSauvegarde.setJ(j);
        jeu = j;
        control = new Controlleur_Jeu(jeu);
        control.setView(this);
        control.nouvellePartie(pName);
        control.getModele().getPartie().setJoueurDefaut();
        control.getModele().getPartie().setTour(1);
        NecessaireDeSurvieGestion.setG(this);
        ListeCase liste = new ListeCase(this);
        BoutonMenuList bl = new BoutonMenuList(control.getModele().getPartie(), this);
        Bandeau b = new Bandeau();
        infop = new InfoPartie(control.getModele().getPartie(), control.getModele().getPartie().getJoueurCourant());
        infot = new InfoTour(control.getModele().getPartie());


        root = new Pane(); 
        StackPane bandeau = new StackPane();
        StackPane menu = new StackPane();
        map = new StackPane();
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

        map.setTranslateX(-3000);
        map.setTranslateY(-2000);

        stage.setTitle("Capitalisme - "+eName);
        this.jeu.seteName(eName);
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
                    MenuJeu mj = new MenuJeu(this.jeu);
                } catch (IOException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });    
        
        
            map.setOnMousePressed((MouseEvent event) -> {
                xOffset = map.getTranslateX() - event.getScreenX();
                yOffset = map.getTranslateY() - event.getScreenY();
        });  
            
            map.setOnMouseDragged((MouseEvent event) -> {
                map.setTranslateX(event.getScreenX() + xOffset);
                map.setTranslateY(event.getScreenY() + yOffset);
        });        
    }
    

    public Game(String eName, Jeu j) throws IOException{
        
        jeu = j;
        control = new Controlleur_Jeu(jeu);
        control.setView(this);
        NecessaireDeSurvieGestion.setG(this);

        NecessaireDeSurvieSauvegarde.setJ(j);
        ListeCase liste = new ListeCase(this);
        BoutonMenuList bl = new BoutonMenuList(control.getModele().getPartie(), this);
        Bandeau b = new Bandeau();
        infop = new InfoPartie(control.getModele().getPartie(), control.getModele().getPartie().getJoueurCourant());
        infot = new InfoTour(control.getModele().getPartie());


        root = new Pane(); 
        StackPane bandeau = new StackPane();
        StackPane menu = new StackPane();
        map = new StackPane();
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
        
        map.setTranslateX(-3000);
        map.setTranslateY(-2000);

        stage.setTitle("Capitalisme - "+eName);
        this.jeu.seteName(eName);
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
                    MenuJeu mj = new MenuJeu(this.jeu);
                    
                } catch (IOException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });    
        
        
            map.setOnMousePressed((MouseEvent event) -> {
                xOffset = map.getTranslateX() - event.getScreenX();
                yOffset = map.getTranslateY() - event.getScreenY();
        });  
            
            map.setOnMouseDragged((MouseEvent event) -> {
                map.setTranslateX(event.getScreenX() + xOffset);
                map.setTranslateY(event.getScreenY() + yOffset);
        });       
    }
    
    public Controlleur_Jeu getControl(){
        return control;
    }
    
    public Partie getP() {
        return control.getModele().getPartie();
    }
    
    public Entreprise getJCourant(){
        return control.getModele().getPartie().getJoueurCourant();
    }
    
    
    public void refreshTour(){
        control.newTurn();
        inft.getChildren().remove(infot);
        root.getChildren().remove(inft);
        
        infot = new InfoTour(control.getModele().getPartie());
        
        inft.getChildren().add(infot);
        root.getChildren().add(inft);
        
        infp.getChildren().remove(infop);
        root.getChildren().remove(infp); 
        infop = new InfoPartie(control.getModele().getPartie(), control.getModele().getPartie().getJoueurCourant());
        infp.getChildren().add(infop);
        root.getChildren().add(infp);        
    }
    
    public void refreshAffichage(){
        inft.getChildren().remove(infot);
        root.getChildren().remove(inft);
        
        infot = new InfoTour(control.getModele().getPartie());
        
        inft.getChildren().add(infot);
        root.getChildren().add(inft);
        
        infp.getChildren().remove(infop);
        root.getChildren().remove(infp); 
        infop = new InfoPartie(control.getModele().getPartie(), control.getModele().getPartie().getJoueurCourant());
        infp.getChildren().add(infop);
        root.getChildren().add(infp); 
    }

    public void close() {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }
}
