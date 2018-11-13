/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Cases;

import static capitalism.Metier.Parties.Carte.Cases.TypeCase.*;
import capitalism.Metier.Parties.Carte.Coordonnee;
import capitalism.Metier.Parties.Carte.Map;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.Parent;

/**
 *
 * @author Azelat
 */
public class ListeCase extends Parent{
    
    private Map map;
    private Case Case;
    private HashMap<Coordonnee, capitalism.Metier.Parties.Carte.Cases.Case> hashMapCase;
    private ArrayList<capitalism.Metier.Parties.Carte.Cases.Case> listeCases;
    private Case[] MapCase;
    
    public ListeCase(){
        this.listeCases = new ArrayList<>();
        this.hashMapCase = new HashMap<>();

        
        this.hashMapCase = map.getHashMapCases();
        this.listeCases = map.getListeCases();
        for(int i=0; i<listeCases.size(); i++)
        {
            if (map.getListeCases().get(i).getType() == CaseEau)
            {
                MapCase[i] = new CaseEau(200, 150);
            } 
            if (map.getListeCases().get(i).getType() == CaseVille)
            {
                MapCase[i] = new CaseVille(250, 150);
            }
            if (map.getListeCases().get(i).getType() == CaseEmplacement)
            {
                MapCase[i] = new CaseEmplacement(300, 150);              
            }
            if (map.getListeCases().get(i).getType() == CaseTerre)
            {
                MapCase[i] = new CaseTerre(350, 150);             
            }
            if (map.getListeCases().get(i).getType() == CaseVilleEmplacement)
            {
                MapCase[i] = new CaseVilleEmplacement(450, 150);            
            }
            if (map.getListeCases().get(i).getType() == CaseRessource)  
            {
                MapCase[i] = new CaseRessource(500, 150);            
            }

        }
        
        
        
        
        for(Case Case: MapCase)
        {
            this.getChildren().add(Case);    
        }
    }
}
    