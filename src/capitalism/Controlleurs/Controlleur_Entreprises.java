/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capitalism.Controlleurs;

import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Metier.Parties.Entreprises.Joueur;
import capitalism.IHM.Windows.AccueilController;
import capitalism.IHM.Windows.ApercuVilleController;
import capitalism.IHM.Windows.CreationPartieController;
import capitalism.IHM.Windows.EcranDeChargementDeLaPartieController;
import capitalism.IHM.Windows.GererUsineController;
import capitalism.IHM.Windows.MenuContextuelInGameController;
import capitalism.IHM.Windows.Menu_echapController;


/**
 *
 * @author hedhie
 */
public class Controlleur_Entreprises {
    
    private Entreprise model;
            
    
    //---------- CONSTRUCTEURS -----------------------------------------------------

    public Controlleur_Entreprises(Entreprise _model){
        //Initialisation
        this.model=_model;
        //lie le controlleur au modele
        this.model.setControlleur(this);
    }
//----------------------------------------------------------------------------------
    
}
