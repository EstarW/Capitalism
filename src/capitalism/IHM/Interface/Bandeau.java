/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Interface;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Azelat
 */
public class Bandeau extends Parent {
    
    public Bandeau(){
        Rectangle r = new Rectangle(1920, 70, Color.rgb(0,0,0,0.7));
        this.setLayoutY(200);
        this.getChildren().add(r);
    }
}
