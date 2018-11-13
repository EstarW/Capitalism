/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier;

import capitalism.Controlleurs.Controlleur_Jeu;
import capitalism.Metier.Parties.Partie;

/**
 *
 * @author Damien
 */
public class Jeu {

    private Controlleur_Jeu controlleur;
    private Partie partie;
    private boolean enJeu;
    

//---------- CONSTRUCTEURS -----------------------------------------------------
    
    public Jeu() {
        this.controlleur=null;
        this.partie=null;
        this.enJeu=true;
    }
    
//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------

    public Controlleur_Jeu getControlleur() {
        return controlleur;
    }

    public void setControlleur(Controlleur_Jeu controlleur) {
        this.controlleur = controlleur;
    }    

    public Partie getPartie() {
        return partie;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }

    public boolean isEnJeu() {
        return enJeu;
    }

    public void setEnJeu(boolean enJeu) {
        this.enJeu = enJeu;
    }
    
//------------------------------------------------------------------------------
 
    /**
     * 
     */
    public void newGame() {
        String nom=null;
        //afficher l'écran de création de l'entreprise
        this.setPartie(new Partie(this,nom));
    }
    
    /**
     * 
     * @param s
     */
    public void loadGame(String s) {
        this.setPartie(new Partie(this,s));
    }

    public void saveGame() {
            // TODO - implement Jeu.saveGame
            throw new UnsupportedOperationException();
    }

    public void stopGame() {
            // TODO - implement Jeu.stopGame
            throw new UnsupportedOperationException();
    }
}