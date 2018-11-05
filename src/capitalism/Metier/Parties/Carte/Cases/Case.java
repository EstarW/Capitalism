/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Carte.Cases;

import capitalism.Metier.Parties.Carte.Map;

/**
 *
 * @author Matthieu
 * @author Damien
 */
public abstract class Case {
    
    private int ligne;                                                          //ligne de la case
    private int colonne;                                                        //colonne de la case 
    private Map map;                                                            //Map du jeu
    
    
//---------- CONSTRUCTEURS -----------------------------------------------------
    public Case(int _ligne,int _colonne,Map _map) {
        //Initialisation
        this.ligne = _ligne;
        this.colonne = _colonne;
        this.map = _map;
    }
//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------

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