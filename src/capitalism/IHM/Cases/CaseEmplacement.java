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
public class CaseEmplacement extends Case {
    
    private double X;
    private double Y;
    
    
    public CaseEmplacement(double X, double Y) {
        super(X, Y);
        Rectangle rec = new Rectangle(50,50,Color.GREY);
        rec.setStroke(Color.rgb(0,0,0, 0.5));
        rec.setStrokeWidth(1);
        rec.setX(X);
        rec.setY(Y);
        this.getChildren().add(rec);
        
                    
                    
        this.setOnMouseEntered(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                rec.setFill(Color.rgb(0,0,0,0.8));
            }
        });
        
        this.setOnMouseExited(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                rec.setFill(Color.GREY);
            }
        });
        
        this.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                System.out.println("Ok");
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
