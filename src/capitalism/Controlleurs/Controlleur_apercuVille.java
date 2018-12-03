/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Controlleurs;

import capitalism.IHM.Windows.ApercuVilleController;
import capitalism.Metier.Parties.Carte.Ville;


/**
 *
 * @author hedhie
 */
public class Controlleur_apercuVille {
    private Ville model;
    private ApercuVilleController vue;
    //---------- CONSTRUCTEURS -----------------------------------------------------

    public Controlleur_apercuVille(Ville _model, ApercuVilleController _vue){
        //Initialisation
        this.model = _model;
        this.vue = _vue;
        //lie le controlleur au modele
        this.model.setControlleur(this);
    }
}
