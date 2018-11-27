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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Azelat
 */
public class Menu_echapController implements Initializable {

    @FXML
    private Button SaveGame;
    @FXML
    private Button LoadGame;
    @FXML
    private Button Options;
    @FXML
    private Button Leave;
    
    private boolean closeGame = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonSaveGameAction(ActionEvent event) {
        
    }

    @FXML
    private void handleButtonLoadGameAction(ActionEvent event) {
        
    }

    @FXML
    private void handleButtonOptionsGameAction(ActionEvent event) {
        
    }

    @FXML
    private void handleButtonLeaveGameAction(ActionEvent event) {
        System.exit(0);
    }

    
}
