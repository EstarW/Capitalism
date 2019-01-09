/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Controlleurs.ControlleursIHM.NecessaireDeSurvie;

import capitalism.IHM.WindowsCode.Game;
import capitalism.Metier.Jeu;

/**
 *
 * @author Beelzed
 */
public class NecessaireDeSurvieSauvegarde {
    private static Jeu j;

    public static Jeu getJ() {
        return j;
    }

    public static void setJ(Jeu j) {
        NecessaireDeSurvieSauvegarde.j = j;
    }
    
    
}
