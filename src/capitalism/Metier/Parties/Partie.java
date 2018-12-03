/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capitalism.Metier.Parties;

import capitalism.Controlleurs.Controlleur_CreationPartie;
import capitalism.Metier.Parties.Carte.Map;
import capitalism.Metier.Parties.Entreprises.Entreprise;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import capitalism.Controlleurs.Controlleur_Jeu;

/**
 *
 * @author Damien
 */
public class Partie {

    private final String nom;
    private int tour;
    private Map map;
    private ArrayList<Entreprise> listeEnt;
    private Controlleur_CreationPartie controlleur;
    
//---------- CONSTRUCTEURS -----------------------------------------------------

    /**
     * Constructeur pour créer une nouvelle partie
     * @param nom 
     */
    public Partie(String nom) {
        this.nom = nom;
        this.listeEnt = new ArrayList();
        this.tour=0;
        this.map= new Map();
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
    
    public void setControlleur(Controlleur_CreationPartie _controlleur){
        this.controlleur = _controlleur;
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
}