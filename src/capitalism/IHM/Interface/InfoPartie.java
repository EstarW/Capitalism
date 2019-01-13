/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Interface;

import capitalism.Metier.Parties.Entreprises.Entreprise;
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
    private Entreprise j;
    private Label argent;
    
    public InfoPartie(Partie p, Entreprise j){
        this.p = p;
        this.j = j;
       
        Label l2 = new Label("Entreprise: "+j.getNom());
        l2.setTextFill(Color.WHITESMOKE);
        l2.setScaleX(3);
        l2.setScaleY(3);
        l2.setLayoutX(500);
        
        argent = new Label("Argent: "+j.getArgent()+"$");
        argent.setTextFill(Color.WHITESMOKE);
        argent.setScaleX(3);
        argent.setScaleY(3);
        argent.setLayoutX(950);        
  
        this.setLayoutY(200);
        this.getChildren().add(l2);
        this.getChildren().add(argent);
    }
    
}
