/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Cases;

import static capitalism.Metier.Parties.Carte.Cases.TypeCase.*;
import capitalism.Metier.Parties.Carte.Map;
import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Metier.Parties.Entreprises.Joueur;
import capitalism.Metier.Parties.Partie;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.Parent;


/**
 *
 * @author Azelat
 */
public class ListeCase extends Parent{
    
    private Map map;
    private CaseIHM Case;
    private ArrayList<capitalism.Metier.Parties.Carte.Cases.Case> listeCases;
    private CaseIHM[] MapCase;
    private int ligne;
    private int colonne;
    private Entreprise j;
    
    public ListeCase(Map m, ArrayList<capitalism.Metier.Parties.Carte.Cases.Case> listeCase, Entreprise j) throws IOException{

        this.listeCases = listeCase;
        this.map = m;
        this.j = j;

        /*this.hashMapCase = map.getHashMapCases();*/

        for(int i=0; i<listeCases.size(); i++)
        {
            if (listeCases.get(i).getType().equals(CaseEau))
            {
                colonne = listeCases.get(i).getColonne();
                ligne = listeCases.get(i).getLigne();
                CaseIHM c = new CaseEauIHM(colonne, ligne);

                this.getChildren().add(c);

            } 
            if (listeCases.get(i).getType().equals(CaseVille))
            {
                colonne = listeCases.get(i).getColonne();
                ligne = listeCases.get(i).getLigne();
                CaseIHM c = new CaseVilleIHM(colonne, ligne);

                this.getChildren().add(c);

            }
            if (listeCases.get(i).getType().equals(CaseEmplacement))
            {
                colonne = listeCases.get(i).getColonne();
                ligne = listeCases.get(i).getLigne();
                CaseIHM c = new CaseEmplacementIHM(colonne, ligne, this.j, m);

                this.getChildren().add(c);

            }
            if (listeCases.get(i).getType().equals(CaseTerre))
            {
                colonne = listeCases.get(i).getColonne();
                ligne = listeCases.get(i).getLigne();
                CaseIHM c = new CaseTerreIHM(colonne, ligne); 

                this.getChildren().add(c);

            }
            if (listeCases.get(i).getType().equals(CaseVilleEmplacement))
            {
                colonne = listeCases.get(i).getColonne();
                ligne = listeCases.get(i).getLigne();
                CaseIHM c = new CaseVilleEmplacementIHM(colonne, ligne); 

                this.getChildren().add(c);

            }
            if (listeCases.get(i).getType().equals(CaseRessource))  
            {
                colonne = listeCases.get(i).getColonne();
                ligne = listeCases.get(i).getLigne();
                CaseIHM c = new CaseRessourceIHM(colonne, ligne); 

                this.getChildren().add(c);

            }
        }
    }
}
    