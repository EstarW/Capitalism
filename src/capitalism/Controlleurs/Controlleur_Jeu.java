/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capitalism.Controlleurs;

import capitalism.IHM.WindowsCode.Game;
import capitalism.Metier.Jeu;
import java.io.IOException;

/**
 *
 * @author Damien
 */
public class Controlleur_Jeu {
    
    Jeu modele;
    Game view;

//---------- CONSTRUCTEURS -----------------------------------------------------

    public Controlleur_Jeu(Jeu _modele){
        this.modele=_modele;
    }

//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------

    public Jeu getModele() {
        return modele;
    }

    public void setModele(Jeu modele) {
        this.modele = modele;
    }

    public Game getView() {
        return view;
    }

    public void setView(Game view) {
        this.view = view;
    }

//------------------------------------------------------------------------------

    public void nouvellePartie(String pseudo) throws IOException{
        modele.nouvellePartie(pseudo);
    }
    
    public void newTurn(){
        this.modele.getPartie().passerTour();
        
    }

}
