/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capitalism.Metier.Parties;

import capitalism.Metier.Parties.Carte.Map;
import capitalism.Metier.Parties.Entreprises.Entreprise;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Damien
 */
public class Sauvegarde {

    private final String path;
    
    
//---------- CONSTRUCTEURS -----------------------------------------------------

    public Sauvegarde(String path) {
        this.path = path+".txt";    //modifier le path pour correspondre au dossier où seront placer les saves
    }

//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------



//------------------------------------------------------------------------------
    
    public void save(Partie partie) throws FileNotFoundException{
        //Ecrire les infos
        PrintWriter writer = new PrintWriter(this.path);
        writer.print(partie.getNom()+";"+partie.getTour());
        for(Entreprise e : partie.getListeEnt()){
            writer.print(";"+e.toString());         // TODO - Rédaction des toString des classes Entreprises, Usines, Contrats
        }
        writer.close();
    }
    
    public int getTour(){
        int res=0;
        //Extraire le nb tour de la chaine
        return res;
    }
    
    public Map getMap(){
        Map res=null;
        //Parser la string de la map
        return res;
    }
    
    public ArrayList<Entreprise> getListeEnt(){
        ArrayList<Entreprise> listeEnt = new ArrayList();
        //Parser la string de la liste
        return listeEnt;
    }
    
    public void supprimeSave(){
        File fichier = new File(this.path);
        fichier.delete();
    }
}
