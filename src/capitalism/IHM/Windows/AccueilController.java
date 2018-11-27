/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Windows;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void handleButtonNewGameAction(ActionEvent event) throws IOException, Throwable {
        
        FXMLLoader fxmlLoader = new FXMLLoader(new File("src/capitalism/IHM/Windows/CreationPartie.fxml").toURI().toURL());
        Scene scene = new Scene(fxmlLoader.load(), 630, 400);
        Stage s = new Stage();
        s.setTitle("Capitalism - Création de partie");
        s.setResizable(false);
        s.setScene(scene);
        s.show(); 
        
        
        Stage stage = (Stage) bouton_nouvellePartie.getScene().getWindow();
        stage.close();
    }
   
    @FXML    
    private void handleButtonLoadGameAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(new File("src/capitalism/IHM/Windows/EcranDeChargementDeLaPartie.fxml").toURI().toURL());
        Scene scene = new Scene(fxmlLoader.load(), 630, 400);
        Stage s = new Stage();
        s.setTitle("Capitalism - Chargement d'une partie");
        s.setResizable(false);
        s.setScene(scene);
        s.show(); 
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
