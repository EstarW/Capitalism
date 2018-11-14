/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Interface;

import capitalism.IHM.*;
import static capitalism.IHM.Interface.Type.*;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.rgb;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
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
    private Menu m;
    
    Text libelle;
    
    public Bouton(float X, float Y, float R, String nom, Type type){    
        
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


        /*libelle.setContent(nom);
        libelle.setFill(Color.BLACK);
        libelle.setTranslateX(posX);
        libelle.setTranslateY(posY);*/
  
        this.getChildren().add(c);        
       
        this.setTranslateX(posX);
        this.setTranslateY(posY);
        
        
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

    public Text getLibelle() {
        return libelle;
    }
    
    
    public void afficherMenu(Type type){
        m = new Menu();
        if(type == MenuJeu)
        {
            m.afficherMenu(type);
            System.out.println(type);
        }
        if(type == MenuListe)
        {
            m.afficherMenu(type);
            System.out.println(type);
        }
        if(type == MenuGestion)
        {
            m.afficherMenu(type);
            System.out.println(type);
        }
        if(type == MenuContrat)
        {
            m.afficherMenu(type);
            System.out.println(type);
        }
    }
    

}
