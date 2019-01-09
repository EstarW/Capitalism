/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capitalism.Metier.Parties;

import capitalism.Controlleurs.ControlleursIHM.NecessaireDeSurvie.NecessaireDeSurvieSauvegarde;
import capitalism.IHM.WindowsCode.Game;
import capitalism.Metier.Jeu;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Damien
 */
public class Sauvegarde implements Serializable{

    private final String path;
    private Jeu g;
    
//---------- CONSTRUCTEURS -----------------------------------------------------

    public Sauvegarde(String path) {
        this.g = NecessaireDeSurvieSauvegarde.getJ();
        this.path = path+".dat";    //modifier le path pour correspondre au dossier où seront placer les saves
    }

//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------



//------------------------------------------------------------------------------
        /**
     * Méthode permettant la sauvegarde du fichier Highscore contenant les informations des meilleurs scores du jeu
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void saveMe() throws IOException {
        FileOutputStream file = new FileOutputStream(path);
        ObjectOutputStream os = new ObjectOutputStream(file);
        os.writeObject(this);
        os.flush();
        os.close();
    }


    public Jeu getG() {
        return g;
    }

    public void setG(Jeu g) {
        this.g = g;
    }

  

 

  
    
}
