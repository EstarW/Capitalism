/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Contrats;

import capitalism.Metier.Parties.Entreprises.Entreprise;
import java.io.Serializable;

/**
 *
 * @author Damien
 */
public abstract class Contrat implements Serializable{
    
    private Entreprise entSource;
    private Entreprise entDestinataire;
    private int duree;
    private String nom;

//---------- CONSTRUCTEURS -----------------------------------------------------
    
    /**
    * 
    * @param entSource
    * @param entDestinataire
    * @param duree
    */
    public Contrat(String nom, Entreprise entSource, Entreprise entDestinataire, int duree) {       
       this.duree=duree;
       this.entDestinataire=entDestinataire;
       this.entSource=entSource;
       this.entSource.addContratEnAttente(this);
       this.nom = nom;
       this.entDestinataire.addContratEnAttente(this);
    }

//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------
    
    public abstract TypeContrat getTypeContrat();

    public Entreprise getEntSource() {
        return entSource;
    }

    public void setEntSource(Entreprise entSource) {
        this.entSource = entSource;
    }

    public Entreprise getEntDestinataire() {
        return entDestinataire;
    }

    public void setEntDestinataire(Entreprise entDestinataire) {
        this.entDestinataire = entDestinataire;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
    
//------------------------------------------------------------------------------

    @Override
    public String toString() {
        return nom;
    }
    
}