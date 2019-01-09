/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Cases;

import capitalism.Controlleurs.Controlleur_Case;
import capitalism.Metier.Parties.Carte.Cases.Case;
import java.io.Serializable;
import javafx.scene.Parent;

/**
 *
 * @author Corentin
 */
public abstract class CaseIHM extends Parent implements Serializable{
    
    private int X;
    private int Y;
    private Case c;
    private Controlleur_Case cc;
    
    public CaseIHM(Case c){
        this.cc = new Controlleur_Case(c,this);
        this.X = c.getColonne();
        this.Y = c.getLigne();
        this.c = c;     
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
    
    public int getLigne(){
        return c.getLigne();
    }
    
    public int getColonne(){
        return c.getColonne();
    }     
    
    public Case getCase(){
        return c;
    }

    public Case getC() {
        return c;
    }

    public Controlleur_Case getCc() {
        return cc;
    }


    
    
}
