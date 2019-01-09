package capitalism.Metier;

import capitalism.Metier.Parties.Partie;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author Beelzed
 */
public class Jeu implements Serializable{
    private Partie partie;
    private String eName;
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

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }
    
    
}
