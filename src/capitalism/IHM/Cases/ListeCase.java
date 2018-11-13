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
import java.util.Iterator;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 *
 * @author Azelat
 */
public class ListeCase extends Parent{
    
    private double movex;
    private double movey;
    private Map map;
    private Case Case;
    private HashMap<Coordonnee, capitalism.Metier.Parties.Carte.Cases.Case> hashMapCase;
    private ArrayList<capitalism.Metier.Parties.Carte.Cases.Case> listeCases;
    private Case[] MapCase;
    
    public ListeCase(){
        this.listeCases = new ArrayList<>();
        this.hashMapCase = new HashMap<>();
        /*ListeCase = new Case[]{
            new CaseEau(200, 150),
            new CaseEau(250, 150),
            new CaseEau(300, 150),
            new CaseEau(350, 150),
            new CaseTerre(200, 200),
            new CaseTerre(250, 200),
            new CaseTerre(300, 200),
            new CaseEmplacement(350, 200)
        };*/
        
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
        
        /*Iterator it = hashMapCase.entrySet().iterator();
        while(it.hasNext())
        {
        }*/
    }
}
    