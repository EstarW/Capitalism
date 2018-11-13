/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Carte;

import capitalism.Metier.Parties.Carte.Cases.Case;
import capitalism.Metier.Jeu;
import capitalism.Metier.Parties.Carte.Parseur.ParseurMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Damien
 */
public class Map {

    private Jeu jeu;
    private HashMap<Coordonnee,Case> hashMapCases;
    private ArrayList<Case> listeCases;

//---------- CONSTRUCTEURS -----------------------------------------------------
    
    public Map(Jeu jeu) {
        this.jeu = jeu;
        this.hashMapCases = new HashMap();
        this.listeCases = new ArrayList();
    }

//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------
    
    public Jeu getJeu() {
        return jeu;
    }

    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }

    public HashMap<Coordonnee, Case> getHashMapCases() {
        return hashMapCases;
    }

    public void setHashMapCases(HashMap<Coordonnee, Case> hashMapCases) {
        this.hashMapCases = hashMapCases;
    }

    public ArrayList<Case> getListeCases() {
        return listeCases;
    }

    public void setListeCases(ArrayList<Case> listeCases) {
        this.listeCases = listeCases;
    }
    
    public void setCase(int numLigne, int numColonne, Case c){
        this.hashMapCases.put(new Coordonnee(numLigne,numColonne), c);
        this.listeCases.add(c);
    }
    
//------------------------------------------------------------------------------
    public void chargerFichier(String adresseFichier) throws IOException {
        ParseurMap parseur = new ParseurMap(adresseFichier,this);
        parseur.lecture();
    }
}