/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Interface;

import capitalism.Controlleurs.Controlleur_CreationPartie;
import capitalism.Metier.Parties.Entreprises.Joueur;
import capitalism.Metier.Parties.Partie;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**
 *
 * @author Azelat
 */
public class InfoPartie extends Parent {
        
    private Partie p;
    private Joueur j;
    private Label argent;
    
    public InfoPartie(Partie p, Joueur j){
        this.p = p;
        this.j = j;

        Label l = new Label("Pseudo: "+j.getNom());
        l.setTextFill(Color.WHITESMOKE);
        l.setScaleX(3);
        l.setScaleY(3);
        l.setLayoutX(150);
        
        Label l2 = new Label("Entreprise: "+p.getNom());
        l2.setTextFill(Color.WHITESMOKE);
        l2.setScaleX(3);
        l2.setScaleY(3);
        l2.setLayoutX(550);
        
        argent = new Label("Argent: "+j.getArgent());
        argent.setTextFill(Color.WHITESMOKE);
        argent.setScaleX(3);
        argent.setScaleY(3);
        argent.setLayoutX(950);        
  
        this.setLayoutY(200);
        this.getChildren().add(l);
        this.getChildren().add(l2);
        this.getChildren().add(argent);
    }
    
}
