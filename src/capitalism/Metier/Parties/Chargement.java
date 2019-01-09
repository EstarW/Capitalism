/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties;

import capitalism.Metier.Jeu;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author Beelzed
 */
public class Chargement {
    
    private String path;
    private Jeu j;

    public Chargement(String path) {
        this.path = path;
    }
    
    
    
        /**
     * Méthode permettant le chargement du fichier de sauvegarde Highscore contenant les informations des meilleurs scores du jeu
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public void loadMe() throws FileNotFoundException, IOException, ClassNotFoundException {
        try {
            FileInputStream file = new FileInputStream(path);
            ObjectInputStream os = new ObjectInputStream(file);
            Sauvegarde load = (Sauvegarde) os.readObject();
            this.j = load.getG();
        } catch (FileNotFoundException e) {
            
        }
    }

    public Jeu getJ() {
        return j;
    }

    
}
