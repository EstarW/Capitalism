/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capitalism.Metier.Parties;

import capitalism.Metier.Jeu;
import capitalism.Metier.Parties.Carte.Map;
import capitalism.Metier.Parties.Entreprises.Entreprise;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author Damien
 */
public class Partie {

    private final Jeu jeu;
    private String nom;
    private int tour;
    private Map map;
    private ArrayList<Entreprise> listeEnt;
    private boolean jouer;
    
//---------- CONSTRUCTEURS -----------------------------------------------------

    /**
     * Constructeur pour créer une nouvelle partie
     * @param jeu 
     * @param nom 
     */
    public Partie(Jeu jeu, String nom) {
        this.jeu = jeu;
        this.nom = nom;
        this.listeEnt = new ArrayList();
        this.tour=0;
        this.map=null;
        this.jouer=true;
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

    public Jeu getJeu() {
        return jeu;
    }

    public String getNom() {
        return nom;
    }

    public boolean isJouer() {
        return jouer;
    }

    public void setJouer(boolean jouer) {
        this.jouer = jouer;
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
        Sauvegarde save = new Sauvegarde(this.nom);
        save.save(this);
    }
    
    public void chargerPartie(){
        Sauvegarde save = new Sauvegarde(this.getNom());
        this.tour=save.getTour();
        this.listeEnt=save.getListeEnt();
        this.map=save.getMap();
    }
    
    /**
     * Procédure de déroulement d'une partie
     * @return Faux si le jeu s'arrete
     */
    public boolean jouer(){
        while(jouer){
            if (this.getTour()==0){
                // TODO - creation de la map
                
                // TODO - creation des joueurs
                
                this.augmenterTour();
            }
            //On affiche l'ecran principal
            //On fait jouer les joueurs l'un après l'autre
            for(Entreprise e : this.getListeEnt()){
                //Chaque joueur fait les actions qu'il peut faire puis passe son tour
            }
            //On passe le tour pour tout le monde
            this.augmenterTour();
        }
        return jouer;
    }
}