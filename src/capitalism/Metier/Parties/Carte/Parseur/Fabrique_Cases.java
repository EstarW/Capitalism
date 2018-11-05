/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Carte.Parseur;

import capitalism.Metier.Parties.Carte.Cases.Case;
import capitalism.Metier.Parties.Carte.Cases.CaseEau;
import capitalism.Metier.Parties.Carte.Cases.CaseEmplacement;
import capitalism.Metier.Parties.Carte.Cases.CaseRessource;
import capitalism.Metier.Parties.Carte.Cases.CaseTerre;
import capitalism.Metier.Parties.Carte.Cases.CaseVille;
import capitalism.Metier.Parties.Carte.Cases.TypeCase;
import capitalism.Metier.Parties.Carte.Map;

/**
 * Fabrique des cases
 * @author Matthieu
 */
public class Fabrique_Cases {

    //singleton
    private static Fabrique_Cases instance;
    
//---------- CONSTRUCTEURS -----------------------------------------------------
    private Fabrique_Cases() {
    }
//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------
    public static Fabrique_Cases get(Map _map) {
        if(instance == null) {
            instance = new Fabrique_Cases();
        }
        return instance;
    }
//------------------------------------------------------------------------------

    //construction d'une case
    public static Case construireCase(TypeCase type,int ligne,int colonne,Map map) {
        Case nouvelleCase = null;
        switch(type) {
            case CaseEau: nouvelleCase = new CaseEau(ligne, colonne, map);
            break;
            case CaseEmplacement: nouvelleCase = new CaseEmplacement(ligne, colonne, map);
            break;
            case CaseRessource: nouvelleCase = new CaseRessource(ligne, colonne, map);
            break;
            case CaseTerre: nouvelleCase = new CaseTerre(ligne, colonne, map);
            break;
            case CaseVille: nouvelleCase = new CaseVille(ligne, colonne, map);
            break;
        }
        return nouvelleCase;
    }
}