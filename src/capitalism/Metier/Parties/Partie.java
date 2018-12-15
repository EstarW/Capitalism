/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capitalism.Metier.Parties;

import capitalism.Metier.Parties.Carte.Map;
import capitalism.Metier.Parties.Entreprises.Entreprise;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import capitalism.Controlleurs.Controlleur_Jeu;
import capitalism.Metier.Parties.Carte.Cases.Case;
import capitalism.Metier.Parties.Carte.Coordonnee;
import capitalism.Metier.Parties.Usines.Usine;
import java.io.IOException;

/**
 *
 * @author Damien
 */
public class Partie {

    private final String nom;
    private int tour;
    private Map map;
    private ArrayList<Entreprise> listeEnt;
    private Controlleur_Jeu controlleur;
    private Entreprise joueurCourant;
    
//---------- CONSTRUCTEURS -----------------------------------------------------

    /**
     * Constructeur pour créer une nouvelle partie
     * @param nom
     * @throws java.io.IOException
     */
    public Partie(String nom) throws IOException {
        this.nom = nom;
        this.listeEnt = new ArrayList();
        this.tour=0;
        this.map= new Map();
        map.chargerFichier("Carte.txt");
    }

//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------

    public int getTour() {
        return tour;
    }

    public Map getMap() {
        return map;
    }

    public ArrayList<Entreprise> getListeEnt() {
        return listeEnt;
    }

    public String getNom() {
        return nom;
    }
    
    public void setControlleur(Controlleur_Jeu _controlleur){
        this.controlleur = _controlleur;
    }
   
    public void setJoueurDefaut(){
        this.joueurCourant = listeEnt.get(0);
    }
    public Case getCase(Coordonnee cord){
        return this.map.getCase(cord);
    }

    public Entreprise getJoueurCourant() {
        return joueurCourant;
    }

    public Controlleur_Jeu getControlleur() {
        return controlleur;
    }

//------------------------------------------------------------------------------

    /**
     * 
     * @param entreprise
     */
    public void removeEntreprise(Entreprise entreprise) {
        if (this.listeEnt.contains(entreprise)){
            this.listeEnt.remove(entreprise);
        }
    }
    
    /**
     * 
     * @param e 
     */
    public void ajouteEntreprise(Entreprise e){
        if(!this.listeEnt.contains(e)){
            this.listeEnt.add(e);
        }
    }

    /**
     * 
     */
    public void augmenterTour(){
        this.tour++;
    }
    
    /**
     * 
     * @throws FileNotFoundException 
     */
    public void savePartie() throws FileNotFoundException{
        throw new UnsupportedOperationException();
    }
    
    public void chargerPartie(){
        throw new UnsupportedOperationException();
    }
    
    public void ConstruireUsineProduit(Produit prod, String nom, Coordonnee cord){
        this.joueurCourant.creerUsineProduit(getCase(cord), prod, nom);  
    }
    
    public void ConstruireUsineRessource(MatierePremiere prod, String nom, Coordonnee cord){
        this.joueurCourant.creerUsineRessource(getCase(cord), prod, nom);  
    }
    
    public void passerTour(){
        for(Entreprise e : this.listeEnt){
            for (Usine u : e.getListeUsines()){
                u.produire();
            }
        }
    }
}