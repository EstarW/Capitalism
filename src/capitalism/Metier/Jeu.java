package capitalism.Metier;

import capitalism.Metier.Parties.Partie;
import java.io.IOException;

/**
 *
 * @author Beelzed
 */
public class Jeu {
    private Partie partie;

//---------- CONSTRUCTEURS -----------------------------------------------------
    
    public Jeu() {
        this.partie=null;
    }
    
//------------------------------------------------------------------------------
    
//---------- GETEUR/SETEUR -----------------------------------------------------
    
    public Partie getPartie() {
        return partie;
    }
    
//------------------------------------------------------------------------------

    public void nouvellePartie(String pseudo) throws IOException{
        this.partie = new Partie();
        this.partie.newPlayer(pseudo);
        this.partie.getMap().chargerFichier("Carte.txt");
    }
    
}
