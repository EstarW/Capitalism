/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Interface;

import capitalism.IHM.WindowsCode.Game;
import static capitalism.IHM.Interface.Type.*;
import capitalism.IHM.WindowsCode.Gestion;
import capitalism.IHM.WindowsCode.MenuJeu;
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

        if(type == MenuGestion)
        {
            FileInputStream inputstream = new FileInputStream("..\\Capitalism\\src\\capitalism\\Resources\\Sprites\\picto_usine.png"); 
            img = new Image(inputstream); 
            imgv = new ImageView(img);
            imgv.setLayoutX(X);
            imgv.setLayoutY(Y);
            this.getChildren().add(imgv);
        }


        this.setLayoutX(posX);
        this.setLayoutY(posY+650);
        this.getChildren().add(c);

        
        
        this.setOnMouseEntered(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                c.setFill(Color.LIGHTGREY);
            }
        });
        
        this.setOnMouseExited(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                c.setFill(Color.rgb(0,0,0,0.7));
            }
        });
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
            //PASSE PAR UN CONTROLLEUR BORDEL
            //FAUDRAIT DEJA QU'IL SOIT BIEN ECRIT MDR !
            //p.augmenterTour();
            //p.passerTour();
            //PASSE PAR UN CONTROLLEUR BORDEL
            System.out.println("Tour: "+p.getTour());
            game.refreshTour();
        }
        /*if(type == MenuListe)
        {
            m.afficherMenu(type);
            System.out.println(type);
        }*/
        if(type == MenuGestion)
        {
            g = new Gestion(this.game);
        }
        /*if(type == MenuContrat)
        {
            m.afficherMenu(type);
            System.out.println(type);
        }*/
    }
    

}
