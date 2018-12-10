/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Cases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Azelat
 */
public class CaseTerre extends Case{
    
    private double X;
    private double Y;
    private Image img;
    private ImageView imgv;
    
    public CaseTerre(double X, double Y) throws FileNotFoundException {
        super(X, Y);
        Rectangle rec = new Rectangle(50,50,Color.ANTIQUEWHITE);
        rec.setStroke(Color.rgb(0,0,0, 0.5));
        rec.setStrokeWidth(1);
        this.X = this.getX();
        this.Y = this.getY();
        rec.setX(X);
        rec.setY(Y);
        FileInputStream inputstream = new FileInputStream("..\\Capitalism\\src\\capitalism\\Resources\\Sprites\\Plaine.png"); 
        img = new Image(inputstream); 
        imgv = new ImageView(img);
        imgv.setX(X);
        imgv.setY(Y);
        this.getChildren().add(rec);
        this.getChildren().add(imgv);

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
