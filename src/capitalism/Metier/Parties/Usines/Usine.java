/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Usines;

import capitalism.Metier.Parties.Carte.Cases.CaseEmplacement;
import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Controlleurs.Controlleur_Usines;

/**
 *
 * @author Damien
 */
public abstract class Usine {

    private String nom;
    private Entreprise proprietaire;
    private CaseEmplacement emplacement;
    private Controlleur_Usines controlleur;
//---------- CONSTRUCTEURS -----------------------------------------------------
    
    /**
     * 
     * @param nom
     * @param proprietaire
     */
    public Usine(String nom, Entreprise proprietaire, CaseEmplacement emplacement) {
        this.nom=nom;
        this.proprietaire=proprietaire;
        this.emplacement = emplacement;
        emplacement.setUsine(this);
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
    
    public void setControlleur(Controlleur_Usines _controlleur){
        this.controlleur = _controlleur;
    }
    
//------------------------------------------------------------------------------
    
    /**
     * 
     * @param nouveauNom
     */
    public void changerNom(String nouveauNom) {
            // TODO - implement Usine.changerNom
            this.nom = nouveauNom;
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
            this.proprietaire = nouveauProprietaire;
    }

}