/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Usines;

import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Metier.Parties.Carte.Cases.Case;

/**
 *
 * @author Damien
 */
public abstract class Usine {

    private String nom;
    private Entreprise proprietaire;
    protected Case emplacement;
    
//---------- CONSTRUCTEURS -----------------------------------------------------
    
    public Usine(String nom, Entreprise proprietaire, Case c) {
        this.nom=nom;
        this.proprietaire=proprietaire;
        this.emplacement = c;
    }
    
//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------

    public String getNom() {
        return nom;
    }

    public abstract String getProdName();
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public Entreprise getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Entreprise proprietaire) {
        this.proprietaire = proprietaire;
    }

    public void setEmplacement(Case emplacement) {
        this.emplacement = emplacement;
    }
    
    public Case getEmplacement() {
        return emplacement;
    }
    
//------------------------------------------------------------------------------
    
}