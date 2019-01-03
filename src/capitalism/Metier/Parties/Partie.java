package capitalism.Metier.Parties;

import capitalism.Metier.Parties.Carte.Map;
import capitalism.Metier.Parties.Entreprises.Entreprise;
import java.util.ArrayList;
import capitalism.Metier.Parties.Carte.Cases.Case;
import capitalism.Metier.Parties.Carte.Coordonnee;

/**
 *
 * @author Damien
 */
public class Partie {

    private int tour;
    private Map map;
    private ArrayList<Entreprise> listeEnt;
    private Entreprise joueurCourant;
    
//---------- CONSTRUCTEURS -----------------------------------------------------

    /**
     * Constructeur pour créer une nouvelle partie
     */
    public Partie(){
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