/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Controlleurs.ControlleursIHM.NecessaireDeSurvie;

import capitalism.IHM.WindowsCode.Game;

/**
 *
 * @author Beelzed
 */
public class NecessaireDeSurvieGestion {
    private static Game g;

    public static Game getG() {
        return g;
    }

    public static void setG(Game g) {
        NecessaireDeSurvieGestion.g = g;
        System.out.println("salut");
    }
    
    
}
