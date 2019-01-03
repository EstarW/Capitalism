/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Cases;

import capitalism.Metier.Parties.Carte.Cases.Case;
import javafx.scene.Parent;

/**
 *
 * @author Corentin
 */
public abstract class CaseIHM extends Parent {
    
    private int X;
    private int Y;
    private Case c;
    
    
    public CaseIHM(Case c){
        this.X = X*50;
        this.Y = Y*50;
        this.c = c;
       
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void setX(int X) {
        this.X = X*50;
    }

    public void setY(int Y) {
        this.Y = Y*50;
    }
    
    public int getLigne(){
        return c.getLigne();
    }
    
    public int getColonne(){
        return c.getColonne();
    }
    
    
    
    
}
