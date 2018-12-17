/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Cases;

import javafx.scene.Parent;

/**
 *
 * @author Corentin
 */
public abstract class CaseIHM extends Parent {
    
    private double X;
    private double Y;    
    private double ligne;
    private double colonne;
    
    
    public CaseIHM(double X, double Y){
        this.X = X*50;
        this.Y = Y*50;
        this.ligne = X;
        this.colonne = Y;
       
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public void setX(double X) {
        this.X = X*50;
    }

    public void setY(double Y) {
        this.Y = Y*50;
    }
    
    public double getLigne(){
        return ligne;
    }
    
    public double getColonne(){
        return colonne;
    }
    
    
    
    
}
