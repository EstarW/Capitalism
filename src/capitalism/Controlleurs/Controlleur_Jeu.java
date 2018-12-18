/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capitalism.Controlleurs;

import capitalism.IHM.WindowsCode.Game;
import capitalism.Controlleurs.ControlleursIHM.EcranDeChargementDeLaPartieController;
/**
 *
 * @author Damien
 */
public class Controlleur_Jeu {

    //private ? vue
    private Game model;
    private EcranDeChargementDeLaPartieController vue;
    
//---------- CONSTRUCTEURS -----------------------------------------------------

    //COMMENT TU PEUX AVOIR LE MODELE DANS LA PARTIE IHM ?????????????
    //LA VUE C'EST PAS UN AUTRE CONTROLLEUR
    //ET QUI A ECRIT CETTE MERDE PUTAIN ?!!!
    public Controlleur_Jeu(Game _model, EcranDeChargementDeLaPartieController _vue){
        //Initialisation
        this.model =_model;
        this.vue = _vue;
        //dedigado;
        //lie le controlleur au modele
        this.model.setControlleur(this);
    }

//------------------------------------------------------------------------------
    
}
