/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Windows;

import capitalism.Game;
import java.io.IOException;
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
public class AccueilController implements Initializable {

    @FXML
    private Button bouton_nouvellePartie;
    @FXML
    private Button bouton_chargerPartie;
    @FXML
    private Button bouton_option;
    @FXML
    private Button bouton_quitter;
    
    private Game game;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void handleButtonNewGameAction(ActionEvent event) throws IOException, Throwable {
        System.out.println("NouvellePartie");
        game = new Game();
        Stage stage = (Stage) bouton_nouvellePartie.getScene().getWindow();
        stage.close();
    }
   
    @FXML    
    private void handleButtonLoadGameAction(ActionEvent event) {
        System.out.println("ChargerPartie");
    }
  
    @FXML    
    private void handleButtonOptionAction(ActionEvent event) {
        System.out.println("Option");
    }
    
    @FXML    
    private void handleButtonQuitGameAction(ActionEvent event) {
        System.out.println("Quitter le jeu");
        System.exit(0);
    }
   

    
}
