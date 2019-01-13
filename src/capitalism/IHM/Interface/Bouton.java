/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Interface;

import capitalism.Capitalism;
import capitalism.Controlleurs.ControlleursIHM.NecessaireDeSurvie.NecessaireDeSurvieGestion;
import capitalism.IHM.WindowsCode.Game;
import static capitalism.IHM.Interface.Type.*;
import capitalism.IHM.WindowsCode.Gestion;
import capitalism.IHM.WindowsCode.MenuContrat;
import capitalism.IHM.WindowsCode.MenuJeu;
import capitalism.IHM.WindowsCode.MenuVente;
import capitalism.Metier.Parties.Partie;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 *
 * @author Azelat
 */
public class Bouton extends Parent {
    
    
    private float posX;
    private float posY;
    private float rad;
    private String nom;
    private Type type; 
    private Parent root;
    private Gestion g;
    private MenuJeu j;
    private Label label;
    private Partie p;
    private Game game;
    private Image img;
    private ImageView imgv;
    
    public Bouton(float X, float Y, float R, String nom, Type type, Game game, Partie p) throws FileNotFoundException{    
        
        this.p = p;
        this.game = game;
        this.nom = nom;
        this.posX = X;
        this.posY = Y;
        this.rad = R;
        this.type = type;
        Circle c = new Circle();
        c.setRadius(rad);
        c.setFill(Color.rgb(0,0,0,0.7));
        c.setStroke(Color.BLACK);
        c.setStrokeWidth(2);
        this.setLayoutX(posX);
        this.setLayoutY(posY+650);
        this.getChildren().add(c);
        this.addImage(type);
        this.setOnMouseEntered(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                c.setFill(Color.GREY);
            }
        });
        
        this.setOnMouseExited(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                c.setFill(Color.rgb(0,0,0,0.7));
            }
        });   
    }
  
    
    private void addImage(Type type){
        if(type == MenuGestion)
        {
            img = new Image(Capitalism.class.getResourceAsStream("Resources/Sprites/picto_usine.png")); 
            imgv = new ImageView(img);
            imgv.setLayoutX(-25);
            imgv.setLayoutY(-25);
            this.getChildren().add(imgv);
        }
        if(type == PasserTour)
        {
            img = new Image(Capitalism.class.getResourceAsStream("Resources/Sprites/PassTour.png")); 
            imgv = new ImageView(img);
            imgv.setLayoutX(-25);
            imgv.setLayoutY(-25);
            this.getChildren().add(imgv);            
        }
        if(type == MenuListe)
        {
            img = new Image(Capitalism.class.getResourceAsStream("Resources/Sprites/VentePicto.png")); 
            imgv = new ImageView(img);
            imgv.setLayoutX(-25);
            imgv.setLayoutY(-25);
            this.getChildren().add(imgv);               
        }
        if(type == MenuContrat)
        {
            img = new Image(Capitalism.class.getResourceAsStream("Resources/Sprites/ContratPicto.png")); 
            imgv = new ImageView(img);
            imgv.setLayoutX(-25);
            imgv.setLayoutY(-25);
            this.getChildren().add(imgv);                
        }     
    }
    
    public Type getType(){
        return type;
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public float getRad() {
        return rad;
    }
    

    public String getNom() {
        return nom;
    }

    public Label getLibelle() {
        return label;
    }
    
    
    public void afficherMenu(Type type) throws IOException{
       // m = new Menu();
        if(type == PasserTour)
        {
            p.getTour();
            System.out.println("Tour: "+p.getTour());
            game.refreshTour();
        }
       if(type == MenuListe)
        {
            MenuVente mv = new MenuVente(this.game);
        }
        if(type == MenuGestion)
        {
            NecessaireDeSurvieGestion.setG(this.game);
            g = new Gestion(this.game);
                    
        }
        if(type == MenuContrat)
        {
            MenuContrat mc = new MenuContrat(this.game);
            
        }
    }
    

}
