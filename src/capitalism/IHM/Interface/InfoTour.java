/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Interface;

import capitalism.Metier.Parties.Partie;
import javafx.scene.Parent;
import javafx.scene.control.Label;

/**
 *
 * @author Azelat
 */
public class InfoTour extends Parent {
 
    private Partie p;
    private String tour;
    
    public InfoTour(Partie p){
        this.p = p;
        this.tour = Integer.toString(p.getTour());
        Label l = new Label("Tour: "+tour);
        l.setScaleX(2);
        l.setScaleY(2);
        l.setLayoutX(20);
        l.setLayoutY(130);
        this.getChildren().add(l);
    }
}
