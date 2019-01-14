/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Contrats;

import capitalism.Metier.Parties.Entreprises.Entreprise;
import java.io.Serializable;
import javafx.scene.control.Alert;

/**
 *
 * @author Damien
 */
public abstract class Contrat implements Serializable{
    
    protected Entreprise entSource;
    protected Entreprise entDestinataire;
    protected int duree;
    protected String nom;
    protected int prix;

//---------- CONSTRUCTEURS -----------------------------------------------------
    
    /**
    * 
    * @param entSource
    * @param entDestinataire
    * @param duree
    */
    public Contrat(String nom, Entreprise entSource, Entreprise entDestinataire, int duree, int p) {       
       this.duree=duree;
       this.prix = p;
       this.entDestinataire=entDestinataire;
       this.entSource=entSource;
       this.entSource.addContratEnAttente(this);
       this.nom = nom;
       this.entDestinataire.addContratEnAttente(this);
    }

//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------
    
    public abstract TypeContrat getTypeContrat();

    public String getNom() {
        return nom;
    }

    public int getPrix() {
        return prix;
    }

    
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

    public void annuler() {
        this.entDestinataire.annulerContrat(this);
        this.entSource.annulerContrat(this);
        this.entSource.getPartie().getListeContrat().remove(this);
    }
    
    public void refuser(){
        this.annuler();
        if(this.entSource.equals(this.entSource.getPartie().getJoueurCourant())){
            Alert alertProd = new Alert(Alert.AlertType.INFORMATION);
            alertProd.setTitle("Contrat refusé ! ");
            alertProd.setHeaderText("Un de vos contrats a été refusé");
            alertProd.setContentText("Votre contrat " + this.nom + " a été refusé par l'entreprise "+ this.entDestinataire + " !");
            alertProd.show();
        }
       
    }
    
    public void accepter(){
        this.entSource.getPartie().getListeContrat().add(this);
        this.entDestinataire.addContrat(this);
        this.entSource.addContrat(this);
        this.entDestinataire.getListeContratAttente().remove(this);
        this.entSource.getListeContratAttente().remove(this);
        if(this.entSource.equals(this.entSource.getPartie().getJoueurCourant())){
            Alert alertProd = new Alert(Alert.AlertType.INFORMATION);
            alertProd.setTitle("Contrat accepté ! ");
            alertProd.setHeaderText("Un de vos contrats a été accepté");
            alertProd.setContentText("Votre contrat " + this.nom + " a été accepté par l'entreprise "+ this.entDestinataire + " !");
            alertProd.show();
        }
    }
    
    
    public abstract void effectuer();

    public void resilier() {
        this.entDestinataire.getPartie().getListeContrat().remove(this);
        this.entDestinataire.getListeContrat().remove(this);
        this.entSource.getListeContrat().remove(this);
    }
}