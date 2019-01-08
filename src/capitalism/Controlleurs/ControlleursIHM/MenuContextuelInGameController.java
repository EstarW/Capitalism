/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Controlleurs.ControlleursIHM;

import capitalism.Controlleurs.ControlleursIHM.NecessaireDeSurvie.NecessaireDeSurvieMenuContextuelController;
import capitalism.IHM.Cases.CaseEmplacementIHM;
import capitalism.IHM.Cases.CaseIHM;
import capitalism.Metier.Parties.Carte.Cases.Case;
import capitalism.Metier.Parties.Carte.Cases.CaseEmplacement;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Azelat
 */
public class MenuContextuelInGameController implements Initializable {

    @FXML
    private Label label_usine;
    @FXML
    private Label label_entreprise;
    @FXML
    private Label label_production;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        NecessaireDeSurvieMenuContextuelController.setNomEntreprise(this.label_entreprise);
        NecessaireDeSurvieMenuContextuelController.setNomUsine(this.label_usine);
        NecessaireDeSurvieMenuContextuelController.setNomProduction(this.label_production);

    }    
    
    public void setCase(CaseEmplacementIHM c){
       CaseEmplacement cEmp = (CaseEmplacement) c.getCc().getModele();
       System.out.println("occupation : "+  cEmp.estOccupe());
        NecessaireDeSurvieMenuContextuelController.getNomEntreprise().setText(cEmp.getUsine().getProprietaire().getNom());
        NecessaireDeSurvieMenuContextuelController.getNomUsine().setText(cEmp.getUsine().getNom());
        NecessaireDeSurvieMenuContextuelController.getNomProduction().setText(cEmp.getUsine().getProdName());
    }
    
}
