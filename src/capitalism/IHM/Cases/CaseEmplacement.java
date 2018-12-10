/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Cases;

import capitalism.IHM.WindowsCode.MenuContextuel;
import capitalism.IHM.WindowsCode.MenuCreationUsine;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Azelat
 */
public class CaseEmplacement extends Case {
    
    private double X;
    private double Y;
    private boolean state;
    private boolean dialog;
    private MenuContextuel m;
    private MenuCreationUsine m2;
    private Rectangle rec;
    private Image img;
    private ImageView imgv;
    private Image img2;
    private ImageView imgv2;
    
    
    public CaseEmplacement(double X, double Y) throws IOException {
        super(X, Y);
        rec = new Rectangle(50,50,Color.GREY);
        rec.setStroke(Color.rgb(0,0,0, 0.5));
        rec.setStrokeWidth(1);
        rec.setX(X);
        rec.setY(Y);
        state = false;
        dialog = false;
        this.getChildren().add(rec);
        
        FileInputStream inputstream = new FileInputStream("..\\Capitalism\\src\\capitalism\\Resources\\Sprites\\Neige.png"); 
        img = new Image(inputstream); 
        imgv = new ImageView(img);
        imgv.setX(X);
        imgv.setY(Y);
        this.getChildren().add(imgv);
        
        FileInputStream inputstream2 = new FileInputStream("..\\Capitalism\\src\\capitalism\\Resources\\Sprites\\EmplacementUsine.png"); 
        img2 = new Image(inputstream2); 
        imgv2 = new ImageView(img2);
        imgv2.setX(X);
        imgv2.setY(Y);
        this.getChildren().add(imgv2);
        
           
                    
        this.setOnMouseEntered((MouseEvent me) -> {
            rec.setFill(Color.rgb(0,0,0,0.8)); 
        });
        
        this.setOnMouseExited((MouseEvent me) -> {
            rec.setFill(Color.GREY);
        });
        
        this.setOnMouseClicked((MouseEvent me) -> {
            if(state){
                try {
                    m = new MenuContextuel(this);
                } catch (IOException ex) {
                    Logger.getLogger(CaseEmplacement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                try {
                    m2 = new MenuCreationUsine(this);
                } catch (IOException ex) {
                    Logger.getLogger(CaseEmplacement.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CaseEmplacement.class.getName()).log(Level.SEVERE, null, ex);
                }

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
    
    public boolean getState(){
        return state;
    }
    
    public void setState(boolean s){
        state = s;
        if(state = true){
            rec.setFill(Color.RED);
        }
    }
    
    
}
