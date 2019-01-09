package capitalism.Metier.Parties;

import capitalism.Metier.Parties.Carte.Map;
import capitalism.Metier.Parties.Entreprises.Entreprise;
import java.util.ArrayList;
import capitalism.Metier.Parties.Carte.Cases.Case;
import capitalism.Metier.Parties.Carte.Coordonnee;
import capitalism.Metier.Parties.Entreprises.IA.IA;
import capitalism.Metier.Parties.Entreprises.Joueur;
import capitalism.Metier.Parties.Usines.Enum.TypeUsine;
import capitalism.Metier.Parties.Usines.Usine;
import java.io.Serializable;

/**
 *
 * @author Damien
 */
public class Partie implements Serializable{

    private int tour;
    private Map map;
    private ArrayList<Entreprise> listeEnt;
    private ArrayList<IA> listeIA;
    private Entreprise joueurCourant;
    
//---------- CONSTRUCTEURS -----------------------------------------------------

    /**
     * Constructeur pour créer une nouvelle partie
     */
    public Partie(){
        this.listeEnt = new ArrayList();
        this.listeIA = new ArrayList();
        this.tour=0;
        this.map= new Map(this);
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
    
    public void newPlayer(String nom){
        this.listeEnt.add(new Joueur(nom, this));
    }
    
    public void addIA(){
        IA ent = new IA("Salut",this);
        this.listeEnt.add(ent);
        this.listeIA.add(ent);
    }

    public void passerTour() {
        for(IA ia : this.listeIA ){
            ia.joue();
        }
        for(Entreprise en : this.listeEnt){
            for(Usine u : en.getListeUsines()){
                u.produire();
            }
            int a= en.getArgent();
            a =- 5000;
            System.out.println(en.getArgent());
        }
        this.joueurCourant.afficheRessources();
        this.tour++;
    }
}