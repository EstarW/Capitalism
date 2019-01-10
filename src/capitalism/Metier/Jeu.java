package capitalism.Metier;

import capitalism.Capitalism;
import capitalism.Controlleurs.Controlleur_Jeu;
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
    private transient Controlleur_Jeu controlleur;
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
        this.partie = new Partie(this);
        this.partie.newPlayer(pseudo);
        this.partie.addIA();
        this.partie.getMap().chargerFichier("capitalism/Carte.txt");
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public Controlleur_Jeu getControlleur() {
        return controlleur;
    }

    public void setControlleur(Controlleur_Jeu controlleur) {
        this.controlleur = controlleur;
    }
    
    
}
