/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Carte.Parseur;

import capitalism.Metier.Parties.Carte.Cases.Case;
import capitalism.Metier.Parties.Carte.Cases.TypeCase;
import capitalism.Metier.Parties.Carte.Map;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Damien
 */
public class ParseurMap {
    
    private final String adresseFichier;
    private Map map;
    
//---------- CONSTRUCTEURS -----------------------------------------------------
    
    public ParseurMap(String adresseFichier, Map map) {
        this.adresseFichier = adresseFichier;
        this.map = map;
    }
    
//------------------------------------------------------------------------------

    //Lance le parsage du fichier
    public void lecture() throws FileNotFoundException, IOException {
        
        //ouverture du fichier en lecture
        File file = new File(this.adresseFichier);
        BufferedReader fichier = new BufferedReader(new FileReader(file));
        
        //Lecture ligne à ligne
        String ligne;
        int numLigne = 0;
        while((ligne = fichier.readLine()) != null){
            //parsage de la ligne
            this.parseLigne(numLigne, ligne);
            numLigne++;
        }
    }
    
    //Parse le fichier
    public void parseLigne(int numLigne,String ligne){
        //lecture caractère par caractère de la ligne et création de la case adaptée
        for(int numColonne = 0; numColonne < ligne.length(); numColonne++) {
            char c = ligne.charAt(numColonne);
            
            //creation de la case
            Case nouvelleCase = null;
            switch(c) {
                case 'E' : nouvelleCase = Fabrique_Cases.construireCase(TypeCase.CaseEau, numLigne, numColonne,this.map); break;
                case 'U' : nouvelleCase = Fabrique_Cases.construireCase(TypeCase.CaseEmplacement, numLigne, numColonne,this.map); break;
                case 'R' : nouvelleCase = Fabrique_Cases.construireCase(TypeCase.CaseRessource, numLigne, numColonne,this.map); break;
                case 'V' : nouvelleCase = Fabrique_Cases.construireCase(TypeCase.CaseVille, numLigne, numColonne,this.map); break;
                default : nouvelleCase = Fabrique_Cases.construireCase(TypeCase.CaseTerre, numLigne, numColonne,this.map); break;
            }
            this.map.setCase(numLigne, numColonne, nouvelleCase);
        }
    }
}
