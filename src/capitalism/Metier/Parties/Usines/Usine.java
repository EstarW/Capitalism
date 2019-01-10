/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Usines;

import capitalism.Metier.Parties.Usines.Enum.TypeUsine;
import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Metier.Parties.Carte.Cases.Case;
import capitalism.Metier.Parties.Carte.Cases.CaseEmplacement;
import java.io.Serializable;

/**
 *
 * @author Damien
 */
public abstract class Usine implements Serializable{

    protected String nom;
    protected Entreprise proprietaire;
    protected Case emplacement;
    
//---------- CONSTRUCTEURS -----------------------------------------------------
    
    public Usine(String nom, Entreprise proprietaire, Case c) {
        this.nom=nom;
        this.proprietaire=proprietaire;
        this.emplacement = c;
        this.proprietaire.addUsine(this);
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
    
    
    public abstract TypeUsine type();
    
    public abstract void produire();

    public void dissoudre() {
        this.proprietaire.getListeUsines().remove(this);
        CaseEmplacement c = (CaseEmplacement) this.emplacement;
        c.dissoudreUsine();
    }
}