package capitalism.Metier.Parties;

import capitalism.Metier.Jeu;
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
    private transient Jeu jeu;
//---------- CONSTRUCTEURS -----------------------------------------------------

    /**
     * Constructeur pour créer une nouvelle partie
     */
    public Partie(Jeu j){
        this.listeEnt = new ArrayList();
        this.listeIA = new ArrayList();
        this.tour=0;
        this.map= new Map(this);
        this.joueurCourant=null;
        this.jeu = j;
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

    public Jeu getJeu() {
        return jeu;
    }

    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }
    
    public Entreprise getEntrepByName(String nom){
        Entreprise e = new IA("test",this);
        for(Entreprise ent:this.listeEnt){
            if (ent.getNom().equals(nom)){
                e = ent;
            }
        }
        return e;
    }
//------------------------------------------------------------------------------
    
    public void newPlayer(String nom){
        this.listeEnt.add(new Joueur(nom, this));
    }
    
    public void addIA(){
        IA ent = new IA("PlantesVertesCorp",this);
        IA ia2 = new IA("TiltMasterCoorp",this);
        IA i3 = new IA("GreenPtutCorp",this);
        IA ia4 = new IA("FloweyCorp",this);
        this.listeEnt.add(ent);
        this.listeIA.add(ent);        
        this.listeEnt.add(ia2);
        this.listeIA.add(ia2);       
        this.listeEnt.add(i3);
        this.listeIA.add(i3);
        this.listeEnt.add(ia4);
        this.listeIA.add(ia4);
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