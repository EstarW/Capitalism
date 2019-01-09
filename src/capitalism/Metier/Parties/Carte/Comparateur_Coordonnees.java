/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Carte;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Comparateur de coordonnées
 * @author Matthieu
 */
public class Comparateur_Coordonnees implements Comparator<Coordonnee>, Serializable {

    @Override
    public int compare(Coordonnee o1, Coordonnee o2) {
        int val = 1;
        if(o1.getLigne() < o2.getLigne()) {
            val = -1;
        }
        else if(o1.getLigne() == o2.getLigne() && o1.getColonne() < o2.getColonne()) {
            val = -1;
        }
        else if(o1.getLigne() == o2.getLigne() && o1.getColonne() == o2.getColonne()) {
            val = 0;
        }
        return val;
    }
}