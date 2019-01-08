/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Entreprises;

import capitalism.Metier.Parties.Usines.Usine;
import capitalism.Metier.Parties.Usines.Enum.MatierePremiere;
import capitalism.Metier.Parties.Partie;
import capitalism.Metier.Parties.Usines.Enum.Produit;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Damien
 * Classe représentant les entreprises du jeu
 */
public abstract class Entreprise {

    protected String nom;
    protected int argent;
    protected Partie partie;
    protected HashMap<MatierePremiere,Integer> MatieresPremieres;
    protected HashMap<Produit, Integer> Produits;
    protected ArrayList<Usine> listeUsines;

//---------- CONSTRUCTEURS -----------------------------------------------------
    
    public Entreprise(String nom, Partie partie) {
        this.argent=100000;
        this.partie=partie;
        this.nom=nom;   
        this.MatieresPremieres = new HashMap();
        for(MatierePremiere m : MatierePremiere.values()){
            this.MatieresPremieres.put(m, 0);
        }
        this.Produits = new HashMap();
        for(Produit m : Produit.values()){
            this.Produits.put(m, 0);
        }
        this.listeUsines = new ArrayList();
        
        
    }

//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------

    public String getNom() {
        return nom;
    }

    public int getArgent() {
        return argent;
    }

    public Partie getPartie() {
        return partie;
    }

    public HashMap<Produit, Integer> getProduitsPossedees() {
        return this.Produits;
    }

    public ArrayList<Usine> getListeUsines() {
        return listeUsines;
    }
    
    public HashMap<MatierePremiere, Integer> getMatieresPremieresPossedees() {
        return this.MatieresPremieres;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }
    
    public void addUsine(Usine u){
        this.listeUsines.add(u);
    }
//------------------------------------------------------------------------------
        public void afficheRessources(){
        for(MatierePremiere mp : this.MatieresPremieres.keySet()){
            System.out.println("key :" + mp + " nb : " + this.MatieresPremieres.get(mp));
        }
        for(Produit p : this.Produits.keySet()){
            System.out.println("key :" + p + " nb : " +this.Produits.get(p));
        }
    }
}