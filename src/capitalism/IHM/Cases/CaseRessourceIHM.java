/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Cases;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Azelat
 */
public class CaseRessourceIHM extends CaseIHM{
    
    private double X;
    private double Y;
    private double ligne;
    private double colonne;
    
    public CaseRessourceIHM(double X, double Y) {
        super(X, Y);
        Rectangle rec = new Rectangle(50,50,Color.CORNFLOWERBLUE);
        rec.setStroke(Color.rgb(0,0,0, 0.5));
        rec.setStrokeWidth(1);
        this.X = this.getX();
        this.Y = this.getY();
        rec.setX(X*50);
        rec.setY(Y*50);
        this.getChildren().add(rec);
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }
    
    public double getLigne(){
        return ligne;
    }
    
    public double getColonne(){
        return colonne;
    }

    public void setX(double X) {
        this.X = X*50;
    }

    public void setY(double Y) {
        this.Y = Y*50;
    }
    
}
