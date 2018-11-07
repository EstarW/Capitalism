/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Entreprises;

import capitalism.Metier.Parties.Partie;
import java.io.FileNotFoundException;

/**
 *
 * @author Damien
 */
public class Joueur extends Entreprise {

//---------- CONSTRUCTEURS -----------------------------------------------------
    
    /**
     * 
     * @param nom
     * @param jeu
     */

    public Joueur(String nom, Partie partie) {
        super(nom, partie);
    }
    
//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------
    
    
    
//------------------------------------------------------------------------------
    
    public void sauvegarder() throws FileNotFoundException{
        this.getPartie().savePartie();
    }
}