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
import capitalism.Metier.Parties.Carte.Coordonnee;

/**
 *
 * @author Beelzed
 */
public class NecessaireDeSurvieCreationUsineController {
    private static CaseEmplacementIHM caseIHM;

    public static CaseEmplacementIHM getCaseIHM() {
        return caseIHM;
    }

    public static void setCaseIHM(CaseEmplacementIHM caseIHM) {
        NecessaireDeSurvieCreationUsineController.caseIHM = caseIHM;
    }
    
    
    
}
