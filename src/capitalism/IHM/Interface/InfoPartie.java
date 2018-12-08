/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Interface;

import capitalism.Controlleurs.Controlleur_CreationPartie;
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
    
    public InfoPartie(Partie p){
        this.p = p;
        Label l = new Label(p.getNom());
        l.setTextFill(Color.WHITESMOKE);
        l.setScaleX(3);
        l.setScaleY(3);
        l.setLayoutX(100);
        this.setLayoutY(200);
        this.getChildren().add(l);
    }
}
