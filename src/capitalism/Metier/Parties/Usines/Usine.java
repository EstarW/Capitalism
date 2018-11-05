/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Usines;

import capitalism.Metier.Parties.Entreprises.Entreprise;

/**
 *
 * @author Damien
 */
public abstract class Usine {

    private String nom;
    private Entreprise proprietaire;

//---------- CONSTRUCTEURS -----------------------------------------------------
    
    /**
     * 
     * @param nom
     * @param proprietaire
     */
    public Usine(String nom, Entreprise proprietaire) {
        this.nom=nom;
        this.proprietaire=proprietaire;
    }
    
//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Entreprise getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Entreprise proprietaire) {
        this.proprietaire = proprietaire;
    }
    
//------------------------------------------------------------------------------
    
    /**
     * 
     * @param nouveauNom
     */
    public void changerNom(String nouveauNom) {
            // TODO - implement Usine.changerNom
            throw new UnsupportedOperationException();
    }

    public void vendre() {
            // TODO - implement Usine.vendre
            throw new UnsupportedOperationException();
    }

    public abstract void produire();

    /**
     * 
     * @param nouveauProprietaire
     */
    public void vendreUsine(Entreprise nouveauProprietaire) {
            // TODO - implement Usine.vendreUsine
            throw new UnsupportedOperationException();
    }

}