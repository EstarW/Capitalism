/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Controlleurs.ControlleursIHM;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Azelat
 */
public class GererUsineController implements Initializable {

    @FXML
    private Button bouron_dissoudre;
    @FXML
    private Button bouton_vendre;
    @FXML
    private Button bouton_ameliorer;
    @FXML
    private Button bouton_modifierNom;
    @FXML
    private Button bouton_modifierProd;
    @FXML
    private Label label_nom;
    @FXML
    private Label label_prod;
    @FXML
    private Label label_materiauxBrut;
    @FXML
    private Label label_materiauxRaffines;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
