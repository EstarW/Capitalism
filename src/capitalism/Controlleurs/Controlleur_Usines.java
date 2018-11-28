/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capitalism.Controlleurs;

import capitalism.Metier.Parties.Usines.Usine;

/**
 *
 * @author hedhie
 */
public class Controlleur_Usines {
    
    private Usine model;
    //---------- CONSTRUCTEURS -----------------------------------------------------

    public Controlleur_Usines(Usine _model){
        //Initialisation
        this.model = _model;
        //lie le controlleur au modele
        this.model.setControlleur(this);
    }
    
//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------

    

//------------------------------------------------------------------------------
    
}
