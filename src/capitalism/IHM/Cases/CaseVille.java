/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Cases;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Azelat
 */
public class CaseVille extends Case{
  
    
    private double X;
    private double Y;
    
    
    public CaseVille(double X, double Y) {
        super(X, Y);
        Rectangle rec = new Rectangle(50,50,Color.LIGHTGREY);
        rec.setStroke(Color.ANTIQUEWHITE);
        rec.setStrokeWidth(1);
        rec.setX(X);
        rec.setY(Y);
        this.getChildren().add(rec);
        
        
        this.setOnMouseEntered(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                rec.setFill(Color.rgb(0,0,0,0.2));
            }
        });
        this.setOnMouseExited(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                rec.setFill(Color.ANTIQUEWHITE);
            }
        });
        this.setOnMouseEntered(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                // Afficher le nom de la ville
            }
        });
    }
    
    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public void setX(double X) {
        this.X = X;
    }

    public void setY(double Y) {
        this.Y = Y;
    }    
    
}
