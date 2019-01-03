/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Cases;

import static capitalism.IHM.Cases.TypeCase.CaseVille;
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
    
    private final ArrayList<CaseIHM> listeCases;
    
    public ListeCase(Game g) throws IOException{

        listeCases = new ArrayList<>();
        
        for(Case c : g.getP().getMap().getListeCases())
        {
            if (c.getType().equals(CaseEau))
            {
                CaseIHM cIHM = new CaseEauIHM(c);
                listeCases.add(cIHM);
                this.getChildren().add(cIHM);
            } 
            if (c.getType().equals(CaseVille))
            {
                CaseIHM cIHM = new CaseVilleIHM(c);
                listeCases.add(cIHM);
                this.getChildren().add(cIHM);
            }
            if (c.getType().equals(CaseEmplacement))
            {
                CaseIHM cIHM = new CaseEmplacementIHM(c);
                listeCases.add(cIHM);
                this.getChildren().add(cIHM);
            }
            if (c.getType().equals(CaseTerre))
            {
                CaseIHM cIHM = new CaseTerreIHM(c); 
                listeCases.add(cIHM);
                this.getChildren().add(cIHM);
            }
            /*if (c.getType().equals(CaseVilleEmplacement))
            {
                CaseIHM cIHM = new CaseVilleEmplacementIHM(c); 
                listeCases.add(cIHM);
                this.getChildren().add(cIHM);
            }*/
            if (c.getType().equals(CaseRessource))  
            {
                CaseIHM cIHM = new CaseRessourceIHM(c); 
                listeCases.add(cIHM);
                this.getChildren().add(cIHM);
            }
        }
        
        //this.getChildren().add(listeCases);
    }
}
    