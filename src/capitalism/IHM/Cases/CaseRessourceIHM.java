/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Cases;

import capitalism.Metier.Parties.Carte.Cases.Case;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Azelat
 */
public class CaseRessourceIHM extends CaseIHM{
    
    public CaseRessourceIHM(Case c) {
        super(c);
        Rectangle rec = new Rectangle(50,50,Color.CORNFLOWERBLUE);
        rec.setStroke(Color.rgb(0,0,0, 0.5));
        rec.setStrokeWidth(1);
        rec.setX(this.getX()*50);
        rec.setY(this.getY()*50);
        this.getChildren().add(rec);
    }
    
}
