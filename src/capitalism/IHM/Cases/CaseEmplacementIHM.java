/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Cases;

import capitalism.Game;
import capitalism.IHM.WindowsCode.MenuContextuel;
import capitalism.IHM.WindowsCode.MenuCreationUsine;
import capitalism.Metier.Parties.Carte.Map;
import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Metier.Parties.Entreprises.Joueur;
import capitalism.Metier.Parties.Partie;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
public class CaseEmplacementIHM extends CaseIHM {
    
    private double X;
    private double Y;
    private double ligne;
    private double colonne;
    private boolean state;
    private boolean dialog;
    private MenuContextuel m;
    private MenuCreationUsine m2;
    private Rectangle rec;
    private Image img;
    private ImageView imgv;
    private Image img2;
    private ImageView imgv2;
    private Entreprise j;
    private Game g;
    private Map map;
    
    public CaseEmplacementIHM(double X, double Y, Entreprise j, Map map, Game g) throws IOException {
        super(X, Y);
        this.j = j;
        this.g = g;
        this.map = map;
        rec = new Rectangle(50,50,Color.GREY);
        rec.setStroke(Color.rgb(0,0,0, 0.5));
        rec.setStrokeWidth(1);
        rec.setX(X*50);
        rec.setY(Y*50);
        state = false;
        dialog = false;
        ligne = X;
        colonne = Y;
        this.getChildren().add(rec);
        
        FileInputStream inputstream = new FileInputStream("..\\Capitalism\\src\\capitalism\\Resources\\Sprites\\Neige.png"); 
        img = new Image(inputstream); 
        imgv = new ImageView(img);
        imgv.setX(X*50);
        imgv.setY(Y*50);
        this.getChildren().add(imgv);
        
        FileInputStream inputstream2 = new FileInputStream("..\\Capitalism\\src\\capitalism\\Resources\\Sprites\\EmplacementUsine.png"); 
        img2 = new Image(inputstream2); 
        imgv2 = new ImageView(img2);
        imgv2.setX(X*50);
        imgv2.setY(Y*50);
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
                    Logger.getLogger(CaseEmplacementIHM.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                try {
                    m2 = new MenuCreationUsine(this, j, map, this.g);
                } catch (IOException ex) {
                    Logger.getLogger(CaseEmplacementIHM.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CaseEmplacementIHM.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public boolean getState(){
        return state;
    }
    
    public void setState(boolean s) throws FileNotFoundException{
        state = s;
        if(state == true){
            this.getChildren().remove(imgv2);
            FileInputStream inputstream2 = new FileInputStream("..\\Capitalism\\src\\capitalism\\Resources\\Sprites\\UsineRouge1.png"); 
            img2 = new Image(inputstream2); 
            imgv2 = new ImageView(img2);
            imgv2.setX(ligne*50);
            imgv2.setY(colonne*50);
            this.getChildren().add(imgv2);
        }
    }
    
    
}
