/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Controlleurs.ControlleursIHM;

import capitalism.Controlleurs.ControlleursIHM.NecessaireDeSurvie.NecessaireDeSurvieSauvegarde;
import capitalism.IHM.WindowsCode.Game;
import capitalism.Metier.Jeu;
import capitalism.Metier.Parties.Chargement;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Azelat
 */
public class Menu_echapController implements Initializable {

    private static Window fenetre;
    private static Jeu jeu;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }

    
    @FXML
    private void handleActionButtonSaveGame(ActionEvent event) {
        System.out.println("Sauvegarder");
        
    final FileChooser dialog = new FileChooser(); 
    final File file = dialog.showSaveDialog(fenetre);
    if (file != null) { 
        System.out.println(file.getAbsolutePath());
        Sauvegarde save = new Sauvegarde(file.getAbsolutePath());
            try {
                save.saveMe();
                // Effectuer la sauvegarde. 
            } catch (IOException ex) {
                Logger.getLogger(Menu_echapController.class.getName()).log(Level.SEVERE, null, ex);
            }
    } 
    }

    @FXML
    private void handleActionButtonLoadGame(ActionEvent event) {
        
        //ChargementPartie c = new ChargementPartie(jeu);
        Stage stage = (Stage) this.fenetre;
        final FileChooser dialog = new FileChooser(); 
        final File file = dialog.showOpenDialog(stage);
         if (file != null) { 
        System.out.println(file.getAbsolutePath());
        Chargement load;
        load = new Chargement(file.getAbsolutePath());
            try {
            try {
                load.loadMe();
                NecessaireDeSurvieSauvegarde.setJ(load.getJ());
                jeu.getControlleur().getView().close();
                
                
                jeu.getControlleur().setView(new Game(load.getJ().geteName(), load.getJ()));
                // Effectuer la sauvegarde. 
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
            } catch (IOException ex) {
                Logger.getLogger(Menu_echapController.class.getName()).log(Level.SEVERE, null, ex);
            }        } 
        stage.close();
    }

    @FXML
    private void handleActionButtonOption(ActionEvent event) {
        System.out.println("Options");
    }

    @FXML
    private void handleActionButtonQuit(ActionEvent event) {
        System.exit(0);
    }
    
    public void setWindow(Window w){
        this.fenetre = w;
    }
}
