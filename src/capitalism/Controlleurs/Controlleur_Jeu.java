/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capitalism.Controlleurs;

import capitalism.Metier.Parties.Partie;
import capitalism.IHM.Windows.MenuContextuelInGameController;
import javafx.scene.layout.AnchorPane;
/**
 *
 * @author Damien
 */
public class Controlleur_Jeu {

    //private ? vue
    private Partie model;
    private AnchorPane vue;
    
//---------- CONSTRUCTEURS -----------------------------------------------------

    public Controlleur_Jeu(Partie _model, AnchorPane _vue){
        //Initialisation
        this.model =_model;
        this.vue = _vue;
        
        //lie le controlleur au modele
        //this.model.setControlleur(this);
    }

//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------

    

//------------------------------------------------------------------------------
    
    
    
}
