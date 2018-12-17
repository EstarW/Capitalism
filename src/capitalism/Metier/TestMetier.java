/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier;

import capitalism.Metier.Parties.Carte.Coordonnee;
import capitalism.Metier.Parties.Entreprises.Joueur;
import capitalism.Metier.Parties.Produit;

/**
 *
 * @author dj715494
 */
public class TestMetier {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        jeu.newGame("Test");
        System.out.println(jeu.getPartie().getNom());
        jeu.getPartie().ajouteEntreprise(new Joueur("Toto",jeu.getPartie()));
        jeu.getPartie().setJoueurDefaut();
        jeu.getPartie().ConstruireUsineProduit(Produit.PC, "UsineTest", new Coordonnee(6,0));
        System.out.println(jeu.getPartie().getJoueurCourant().getListeUsines().get(0).getNom());
        System.out.println(jeu.getPartie().getJoueurCourant().getListeUsines().get(0).getProprietaire().getNom());
    }
    
}
