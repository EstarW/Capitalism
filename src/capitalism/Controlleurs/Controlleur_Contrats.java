/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capitalism.Controlleurs;

import capitalism.Metier.Parties.Contrats.Contrat;

/**
 *
 * @author hedhie
 */
public class Controlleur_Contrats {
    
    private Contrat model;
    
    //---------- CONSTRUCTEURS -----------------------------------------------------

    public Controlleur_Contrats(Contrat _model){
        //Initialisation
        this.model = _model;
        //lie le controlleur au modele
        this.model.setControlleur(this);
    }
    
//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------

    

//------------------------------------------------------------------------------
    
}
