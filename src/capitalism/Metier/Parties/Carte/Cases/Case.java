/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Carte.Cases;

import capitalism.Controlleurs.Controlleur_Case;
import capitalism.Metier.Parties.Carte.Map;
import java.io.Serializable;

/**
 *
 * @author Matthieu
 * @author Damien
 */
public abstract class Case implements Serializable{
    
    private final int ligne;                                                          //ligne de la case
    private final int colonne;                                                        //colonne de la case 
    private final Map map;                                                            //Map du jeu
    private transient Controlleur_Case controlleur;
    
//---------- CONSTRUCTEURS -----------------------------------------------------
    public Case(int _ligne,int _colonne,Map _map) {
        //Initialisation
        this.ligne = _ligne;
        this.colonne = _colonne;
        this.map = _map;
        this.controlleur = null;
    }
//------------------------------------------------------------------------------
    

//---------- GETEUR/SETEUR -----------------------------------------------------
    public void setControlleur(Controlleur_Case controlleur) {
        this.controlleur = controlleur;
    }
    
    public Controlleur_Case getControlleur() {
            return controlleur;
        }
    //Renvoie la carte du jeu
    public Map getMap() {
        return this.map;
    }
    
    //Renvoie la ligne de la case
    public int getLigne() {
        return this.ligne;
    }
    
    //Renvoie la colonne de la case
    public int getColonne() {
        return this.colonne;
    }
    
    //Renvoie le type de la case
    public abstract TypeCase getType(); 
    
}