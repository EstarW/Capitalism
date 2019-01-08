/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Controlleurs.ControlleursIHM.NecessaireDeSurvie;

import javafx.scene.control.Label;

/**
 *
 * @author Beelzed
 */
public class NecessaireDeSurvieMenuContextuelController {
    private static Label nomUsine;
    private static Label nomEntreprise;
    private static Label nomProduction;

        

    public static Label getNomUsine() {
        return nomUsine;
    }

    public static void setNomUsine(Label nomUsine) {
        NecessaireDeSurvieMenuContextuelController.nomUsine = nomUsine;
    }

    public static Label getNomEntreprise() {
        return nomEntreprise;
    }

    public static void setNomEntreprise(Label nomEntreprise) {
        NecessaireDeSurvieMenuContextuelController.nomEntreprise = nomEntreprise;
    }

    public static Label getNomProduction() {
        return nomProduction;
    }

    public static void setNomProduction(Label nomProduction) {
        NecessaireDeSurvieMenuContextuelController.nomProduction = nomProduction;
    }
    
}
