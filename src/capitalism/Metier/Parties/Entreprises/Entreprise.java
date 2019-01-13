/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Entreprises;

import capitalism.Metier.Parties.Contrats.Contrat;
import capitalism.Metier.Parties.Usines.Usine;
import capitalism.Metier.Parties.Usines.Enum.MatierePremiere;
import capitalism.Metier.Parties.Partie;
import capitalism.Metier.Parties.Usines.Enum.Produit;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Damien
 * Classe représentant les entreprises du jeu
 */
public abstract class Entreprise implements Serializable{

    protected String bilanComptable;
    protected String nom;
    protected int argent;
    protected Partie partie;
    protected HashMap<MatierePremiere,Integer> MatieresPremieres;
    protected HashMap<Produit, Integer> Produits;
    protected ArrayList<Usine> listeUsines;
    protected ArrayList<Contrat> listeContrat;
    protected ArrayList<Contrat> listeContratAttente;
//---------- CONSTRUCTEURS -----------------------------------------------------
    
    public Entreprise(String nom, Partie partie) {
        this.bilanComptable = "";
        this.argent=10000;
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
        this.listeContrat = new ArrayList();
        this.listeContratAttente = new ArrayList();
        
    }

//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------

    public String getBilanComptable() {
        return bilanComptable;
    }

    public ArrayList<Contrat> getListeContrat() {
        return listeContrat;
    }

    public ArrayList<Contrat> getListeContratAttente() {
        return listeContratAttente;
    }

    
    
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
    
    public Usine getUsineByName(String name){
        Usine u = null;
        for (Usine usi : this.getListeUsines()){
            if (usi.getNom().equals(name)){
                u = usi;
            }
        }
        
        return u;
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
        
        public void retireArgent(int qte){
            this.argent -= qte;
        }
        
        public void addArgent(int qte){
            this.argent+= qte;
        }
        
        public void ajouteProduit(Produit p, int qte){
            this.Produits.replace(p, this.Produits.get(p)+qte);
        }
        
        public void ajouteMatierePremiere(MatierePremiere mp, int qte){
            this.MatieresPremieres.replace(mp, this.MatieresPremieres.get(mp)+qte);
        }
        
        public void addToBilan(String ligne){
            this.bilanComptable += ligne + "\n";
        }
        
        public String getBilan(){
            return this.bilanComptable;
        }

    @Override
    public String toString() {
        return nom ;
    }
        
    public void addContratEnAttente(Contrat c){
        this.listeContratAttente.add(c);
    }
    public void addContrat(Contrat c){
        this.listeContratAttente.remove(c);
        this.listeContrat.add(c);
    }
    
    public void annulerContrat(Contrat c){
        this.listeContratAttente.remove(c);
    }
        
}