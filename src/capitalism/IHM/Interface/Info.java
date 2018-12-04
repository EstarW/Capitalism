/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Interface;

import capitalism.Controlleurs.Controlleur_CreationPartie;
import javafx.scene.Parent;
import javafx.scene.control.Label;

/**
 *
 * @author Azelat
 */
public class Info extends Parent {
    
    
    public Info(){
        Label l = new Label("Azelat");
        l.setScaleX(3);
        l.setScaleY(3);
        l.setLayoutX(100);
        this.setLayoutY(200);
        this.getChildren().add(l);
    }
}
