/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Controlleurs.ControlleursIHM;

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
    }    
    
    public void setCase(Case c){
       CaseEmplacement cEmp = (CaseEmplacement) c;
       this.label_usine.setText(cEmp.getUsine().toString());
       this.label_entreprise.setText(cEmp.getUsine().getProprietaire().toString());
       this.label_production.setText(cEmp.getUsine().getProdName());
    }
    
}
