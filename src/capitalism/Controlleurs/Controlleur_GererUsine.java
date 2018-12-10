/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Controlleurs;

import capitalism.IHM.Windows.GererUsineController;
import capitalism.Metier.Parties.Usines.Usine;


/**
 *
 * @author hedhie
 */
public class Controlleur_GererUsine {
    private Usine model;
    private GererUsineController vue;
    //---------- CONSTRUCTEURS -----------------------------------------------------

    public Controlleur_GererUsine(Usine _model, GererUsineController _vue){
        //Initialisation
        this.model = _model;
        this.vue = _vue;
        //lie le controlleur au modele
        //this.model.setControlleur(this);
    }
}
