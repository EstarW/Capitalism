/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capitalism.Controlleurs;

import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Metier.Parties.Entreprises.Joueur;
import capitalism.Controlleurs.ControlleursIHM.AccueilController;
import capitalism.Controlleurs.ControlleursIHM.ApercuVilleController;
import capitalism.Controlleurs.ControlleursIHM.CreationPartieController;
import capitalism.Controlleurs.ControlleursIHM.EcranDeChargementDeLaPartieController;
import capitalism.Controlleurs.ControlleursIHM.GererUsineController;
import capitalism.Controlleurs.ControlleursIHM.MenuContextuelInGameController;
import capitalism.Controlleurs.ControlleursIHM.Menu_echapController;
import javafx.scene.layout.StackPane;


/**
 *
 * @author hedhie
 */
public class Controlleur_Entreprises {
    
    private Entreprise model;
    private StackPane vue;
            
    
    //---------- CONSTRUCTEURS -----------------------------------------------------

    public Controlleur_Entreprises(Entreprise _model, StackPane _vue){
        //Initialisation
        this.model=_model;
        this.vue = _vue;
        //lie le controlleur au modele
        this.model.setControlleur(this);
    }
//----------------------------------------------------------------------------------
    
}
