/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Controlleurs.ControlleursIHM.NecessaireDeSurvie;

import capitalism.IHM.Cases.CaseEmplacementIHM;
import capitalism.IHM.WindowsCode.Game;
import capitalism.Metier.Parties.Carte.Cases.Case;
import capitalism.Metier.Parties.Carte.Cases.CaseEmplacement;

/**
 *
 * @author Beelzed
 */
public class NecessaireDeSurvieCreationUsineController {
    private static Game game;
    private static Case casee;
    private static CaseEmplacementIHM caseIHM;

    public static CaseEmplacementIHM getCaseIHM() {
        return caseIHM;
    }

    public static void setCaseIHM(CaseEmplacementIHM caseIHM) {
        NecessaireDeSurvieCreationUsineController.caseIHM = caseIHM;
    }
    
    
    public static void setGame(Game g){
        game = g;
    }
    
    public static void setCasee(Case c){
        casee = c;
    }
    
    public static Game getGame(){
        return game;
    }
    
    public static Case getCaseEmp(){
        return casee;
    }
    
    
}
