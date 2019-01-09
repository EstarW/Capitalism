/*
 * Merci à M. Simmonet pour cette classe issue du projet de Graphes du S2
 */
package capitalism.Metier.Parties.Carte;

import java.io.Serializable;

/**
 * Coordonnées
 * @author Matthieu
 */
public class Coordonnee implements Serializable{

    private final int ligne;                                                    //Numéro de la ligne
    private final int colonne;                                                  //Numéro de la colonne
    
//---------- CONSTRUCTEURS -----------------------------------------------------

    public Coordonnee(int _ligne,int _colonne) {
        this.ligne = _ligne;                            
        this.colonne = _colonne;
    }
    
//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------

    //Renvoie le numéro de la ligne
    public int getLigne() {
        return this.ligne;
    }
    
    //Renvoie le numéro de la colonne
    public int getColonne() {
        return this.colonne;
    }

//------------------------------------------------------------------------------

    //Affichage
    @Override
    public String toString() {
        return this.ligne + "/" + this.colonne;
    }
    
    //Fct de Hashage pour les HashMap et les TreeMap
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.ligne;
        hash = 59 * hash + this.colonne;
        return hash;
    }

    //Fct d'égalité
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coordonnee other = (Coordonnee) obj;
        if (this.ligne != other.ligne) {
            return false;
        }
        if (this.colonne != other.colonne) {
            return false;
        }
        return true;
    }

    //Renvoie la somme de la coordonnées courantes avec c
    public Coordonnee add(Coordonnee c) {
        return new Coordonnee(this.ligne+c.ligne,this.colonne+c.colonne);
    }
    
}