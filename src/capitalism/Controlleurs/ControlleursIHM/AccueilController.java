/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Controlleurs.ControlleursIHM;

import capitalism.Controlleurs.ControlleursIHM.NecessaireDeSurvie.NecessaireDeSurvieSauvegarde;
import capitalism.IHM.WindowsCode.CreationPartie;
import capitalism.IHM.WindowsCode.Game;
import capitalism.Metier.Jeu;
import capitalism.Metier.Parties.Chargement;
import capitalism.Metier.Parties.Entreprises.Joueur;
import capitalism.Metier.Parties.Sauvegarde;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
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
    
    private static Jeu j;
    private Chargement load;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void handleButtonNewGameAction(ActionEvent event) throws IOException, Throwable {
        CreationPartie c = new CreationPartie(j);
        
        Stage stage = (Stage) bouton_nouvellePartie.getScene().getWindow();
        stage.close();
    }
   
    @FXML    
    private void handleButtonLoadGameAction(ActionEvent event) throws IOException {
        Jeu jeu = this.getJeu();
        //ChargementPartie c = new ChargementPartie(jeu);
        Stage stage = (Stage) bouton_nouvellePartie.getScene().getWindow();
        final FileChooser dialog = new FileChooser(); 
        final File file = dialog.showOpenDialog(stage);
         if (file != null) { 
        System.out.println(file.getAbsolutePath());
        this.load = new Chargement(file.getAbsolutePath());
            try {
            try {
                load.loadMe();
                NecessaireDeSurvieSauvegarde.setJ(load.getJ());
                Game game = new Game(load.getJ().geteName(), load.getJ());
                // Effectuer la sauvegarde. 
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
            } catch (IOException ex) {
                Logger.getLogger(Menu_echapController.class.getName()).log(Level.SEVERE, null, ex);
            }        } 
        //Stage stage = (Stage) bouton_nouvellePartie.getScene().getWindow();
        //stage.close();
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
