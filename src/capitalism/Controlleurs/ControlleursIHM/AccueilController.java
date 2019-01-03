/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Controlleurs.ControlleursIHM;

import capitalism.IHM.WindowsCode.ChargementPartie;
import capitalism.IHM.WindowsCode.CreationPartie;
import capitalism.Metier.Jeu;
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
    
    private Jeu j;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void handleButtonNewGameAction(ActionEvent event) throws IOException, Throwable {
        Jeu jeu = this.getJeu();
        CreationPartie c = new CreationPartie(jeu);
        
        Stage stage = (Stage) bouton_nouvellePartie.getScene().getWindow();
        stage.close();
    }
   
    @FXML    
    private void handleButtonLoadGameAction(ActionEvent event) throws IOException {
        Jeu jeu = this.getJeu();
        ChargementPartie c = new ChargementPartie(jeu);
        
        Stage stage = (Stage) bouton_nouvellePartie.getScene().getWindow();
        stage.close();
    }
  
    @FXML    
    private void handleButtonOptionAction(ActionEvent event) {
        System.out.println("Option");
    }
    
    @FXML    
    private void handleButtonQuitGameAction(ActionEvent event) {
        System.exit(0);
    }
    
    public void setJeu(Jeu j) {
        this.j = j;
    }
    
    public Jeu getJeu(){
        return j;
    }
    
}
