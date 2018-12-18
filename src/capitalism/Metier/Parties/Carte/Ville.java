/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Carte;

import capitalism.Controlleurs.Controlleur_apercuVille;

/**
 *
 * @author Damien
 */
public class Ville {

    private String nom;
    private int nbEmplacements;
    private Controlleur_apercuVille controlleur;

//---------- CONSTRUCTEURS -----------------------------------------------------
    
    public Ville(String nom, int nbEmplacements) {
        this.nom = nom;
        this.nbEmplacements = nbEmplacements;
    }
    
//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------
    
    public int getNbUsines() {
            // TODO - implement Ville.getNbUsines
            throw new UnsupportedOperationException();
    }

    public int getNbEntreprise() {
            // TODO - implement Ville.getNbEntreprise
            throw new UnsupportedOperationException();
    }
    
    public String getNom() {
        return nom;
    }

    public int getNbEmplacements() {
        return nbEmplacements;
    }
    
    public void setControlleur(Controlleur_apercuVille _controlleur) {
        this.controlleur = _controlleur;
    }

//------------------------------------------------------------------------------
    
}