/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier;

import capitalism.Metier.Parties.Partie;

/**
 *
 * @author Beelzed
 */
public class Jeu {
    private Partie partie;

    public Jeu() {
    }
    
    public void newGame(String name){
        this.partie = new Partie(name);
    }

    public Jeu(Partie partie) {
        this.partie = partie;
    }
    
    
}
