/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Contrats;

import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Controlleurs.Controlleur_Contrats;

/**
 *
 * @author Damien
 */
public abstract class Contrat {
    
    private Entreprise entSource;
    private Entreprise entDestinataire;
    private int duree;
    private Controlleur_Contrats controlleur;

//---------- CONSTRUCTEURS -----------------------------------------------------
    
    /**
    * 
    * @param entSource
    * @param entDestinataire
    * @param duree
    */
    public Contrat(Entreprise entSource, Entreprise entDestinataire, int duree) {
       this.duree=duree;
       this.entDestinataire=entDestinataire;
       this.entSource=entSource;
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
    
    public void setControlleur(Controlleur_Contrats _controlleur){
        this.controlleur = _controlleur;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
    
//------------------------------------------------------------------------------
    
}