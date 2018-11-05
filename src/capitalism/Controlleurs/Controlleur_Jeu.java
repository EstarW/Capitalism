/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capitalism.Controlleurs;

import capitalism.Metier.Jeu;
import capitalism.Metier.Type_ActionEcranJeu;

/**
 *
 * @author Damien
 */
public class Controlleur_Jeu {

    private Jeu modele;
    //private ? vue
    
    
//---------- CONSTRUCTEURS -----------------------------------------------------

    public Controlleur_Jeu(Jeu _modele){
        //Initialisation
        this.modele = _modele;
        //lie le controlleur au modele
        this.modele.setControlleur(this);
    }

//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------

    

//------------------------------------------------------------------------------
    /**
     * 
     * @return L'action du joueur
     */
    public Type_ActionEcranJeu affichageEcranJeu(){
        Type_ActionEcranJeu choix = null;
        //renvoyer le choix du joueur
        return choix;
    }
    
    public String ecranChargerPartie(){
        String res = null;
        //renvoyer le nom de la partie à charger
        return res;
    }
    
}
