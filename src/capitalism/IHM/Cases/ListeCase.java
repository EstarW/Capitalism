/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Cases;

import static capitalism.Metier.Parties.Carte.Cases.TypeCase.*;
import capitalism.Metier.Parties.Carte.Map;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.Parent;


/**
 *
 * @author Azelat
 */
public class ListeCase extends Parent{
    
    private Map map;
    private Case Case;
    private ArrayList<capitalism.Metier.Parties.Carte.Cases.Case> listeCases;
    private Case[] MapCase;
    private int ligne;
    private int colonne;
    
    public ListeCase(Map m, ArrayList<capitalism.Metier.Parties.Carte.Cases.Case> listeCase) throws IOException{

        this.listeCases = listeCase;
        this.map = m;

        /*this.hashMapCase = map.getHashMapCases();*/

        for(int i=0; i<listeCases.size(); i++)
        {
            if (listeCases.get(i).getType().equals(CaseEau))
            {
                colonne = listeCases.get(i).getColonne();
                ligne = listeCases.get(i).getLigne();
                Case c = new CaseEau(colonne*50, ligne*50);

                this.getChildren().add(c);

            } 
            if (listeCases.get(i).getType().equals(CaseVille))
            {
                colonne = listeCases.get(i).getColonne();
                ligne = listeCases.get(i).getLigne();
                Case c = new CaseVille(colonne*50, ligne*50);

                this.getChildren().add(c);

            }
            if (listeCases.get(i).getType().equals(CaseEmplacement))
            {
                colonne = listeCases.get(i).getColonne();
                ligne = listeCases.get(i).getLigne();
                Case c = new CaseEmplacement(colonne*50, ligne*50);

                this.getChildren().add(c);

            }
            if (listeCases.get(i).getType().equals(CaseTerre))
            {
                colonne = listeCases.get(i).getColonne();
                ligne = listeCases.get(i).getLigne();
                Case c = new CaseTerre(colonne*50, ligne*50); 

                this.getChildren().add(c);

            }
            if (listeCases.get(i).getType().equals(CaseVilleEmplacement))
            {
                colonne = listeCases.get(i).getColonne();
                ligne = listeCases.get(i).getLigne();
                Case c = new CaseVilleEmplacement(colonne*50, ligne*50); 

                this.getChildren().add(c);

            }
            if (listeCases.get(i).getType().equals(CaseRessource))  
            {
                colonne = listeCases.get(i).getColonne();
                ligne = listeCases.get(i).getLigne();
                Case c = new CaseRessource(colonne*50, ligne*50); 

                this.getChildren().add(c);

            }
        }
    }
}
    