/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Windows;

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
    }

    @FXML
    private void handleActionButtonLoadGame(ActionEvent event) {
    }

    @FXML
    private void handleActionButtonOption(ActionEvent event) {
    }

    @FXML
    private void handleActionButtonQuit(ActionEvent event) {
        System.exit(0);
    }
    
}
