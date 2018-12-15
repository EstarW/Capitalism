/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier;

import capitalism.Metier.Parties.Partie;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Beelzed
 */
public class Jeu {
    private Partie partie;

    public Jeu() {
        this.partie=null;
    }
    
    public void newGame(String name){
        try {
            this.partie = new Partie(name);
        } catch (IOException ex) {
            Logger.getLogger(Jeu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Jeu(Partie partie) {
        this.partie = partie;
    }
    
    public void supPartie(){
        this.partie = null;
    }

    public Partie getPartie() {
        return partie;
    }
    
    
}
