/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Controlleurs.ControlleursIHM;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Azelat
 */
public class Menu_echapController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleActionButtonSaveGame(ActionEvent event) {
        System.out.println("Sauvegarder");
    }

    @FXML
    private void handleActionButtonLoadGame(ActionEvent event) {
        System.out.println("Charger");
    }

    @FXML
    private void handleActionButtonOption(ActionEvent event) {
        System.out.println("Options");
    }

    @FXML
    private void handleActionButtonQuit(ActionEvent event) {
        System.exit(0);
    }
    
}
