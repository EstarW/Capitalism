/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capitalism.Metier.Parties;

import capitalism.Metier.Parties.Carte.Map;
import capitalism.Metier.Parties.Entreprises.Entreprise;
import java.util.ArrayList;
import capitalism.Metier.Parties.Carte.Cases.Case;
import capitalism.Metier.Parties.Carte.Coordonnee;
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
    private Entreprise joueurCourant;
    
//---------- CONSTRUCTEURS -----------------------------------------------------

    /**
     * Constructeur pour créer une nouvelle partie
     * @param nom
     * @throws java.io.IOException
     */
    public Partie(String nom){// throws IOException {
        this.nom = nom;
        this.listeEnt = new ArrayList();
        this.tour=0;
        this.map= new Map();
        this.joueurCourant=null;
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
   
    public void setJoueurDefaut(){
        this.joueurCourant = listeEnt.get(0);
    }
    public Case getCase(Coordonnee cord){
        return this.map.getCase(cord);
    }

    public Entreprise getJoueurCourant() {
        return joueurCourant;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setJoueurCourant(Entreprise joueurCourant) {
        this.joueurCourant = joueurCourant;
    }
    
//------------------------------------------------------------------------------
    
}