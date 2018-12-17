/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capitalism.Controlleurs;

import capitalism.Controlleurs.ControlleursIHM.CréationUsineController;
import capitalism.Controlleurs.ControlleursIHM.GererUsineController;
import capitalism.Metier.Parties.Produit;
import capitalism.Metier.Parties.Usines.Usine;

/**
 *
 * @author hedhie
 */
public class Controlleur_Usines {
    
    private Usine model;
    private CréationUsineController vue;
    //---------- CONSTRUCTEURS -----------------------------------------------------

    public Controlleur_Usines(Usine _model, CréationUsineController _vue){
        //Initialisation
        this.model = _model;
        this.vue = _vue;
        //lie le controlleur au modele
        this.model.setControlleur(this);
    }
    
//------------------------------------------------------------------------------

    
}
