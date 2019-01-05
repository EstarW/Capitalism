/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Cases;

import capitalism.IHM.WindowsCode.Game;
import capitalism.Metier.Parties.Carte.Cases.Case;
import static capitalism.Metier.Parties.Carte.Cases.TypeCase.*;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.Parent;


/**
 *
 * @author Azelat
 */
public class ListeCase extends Parent{
    
    private ArrayList<CaseIHM> listeCases;
    
    public ListeCase(Game g) throws IOException{

        listeCases = new ArrayList<>();
        for(Case c : g.getP().getMap().getListeCases())
        {
            CaseIHM cIHM = null;
            switch(c.getType()){
                case CaseEau:
                    cIHM = new CaseEauIHM(c);
                    listeCases.add(cIHM);
                break;
                    
                case CaseVille:
                    cIHM = new CaseVilleIHM(c);
                    listeCases.add(cIHM);
                break;
                    
                case CaseEmplacement:
                    cIHM = new CaseEmplacementIHM(c);
                    listeCases.add(cIHM);
                break;
                
                case CaseTerre:
                    cIHM = new CaseTerreIHM(c); 
                    listeCases.add(cIHM);
                break;
                
                default:
                    System.out.println("Nope");
                break;
            }
        }
        
        System.out.println(listeCases);
        
        for(CaseIHM cIHM : listeCases){
            System.out.println("Case: "+cIHM.getX()+" : "+cIHM.getY());
            this.getChildren().add(cIHM);
        }
        
        // POURQUOI ELLE APPARAIT PAS ALORS CETTE PUTE !!!!!!!!!dsnjuifhbzefgzedgazeuicvgesddgzecgzdfgzdefugyize
    }
}
    