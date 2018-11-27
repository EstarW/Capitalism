/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Windows;

import capitalism.Game;
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
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Azelat
 */
public class EcranDeChargementDeLaPartieController implements Initializable {

    @FXML
    private ListView<?> listView_1;
    @FXML
    private ListView<?> listView_2;
    @FXML
    private ListView<?> listView_3;
    @FXML
    private Button bouton_charger_1;
    @FXML
    private Button bouton_charger_2;
    @FXML
    private Button bouton_effacer_2;
    @FXML
    private Button bouton_charger_3;
    @FXML
    private Button bouton_effacer_3;
    @FXML
    private ImageView imageView_1;
    @FXML
    private ImageView imageView_2;
    @FXML
    private ImageView imageView_3;
    @FXML
    private Button bouton_effacer_1;
    @FXML
    private Button bouton_retour;
    
    private Game game;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML    
    private void handleButtonLoadGameAction(ActionEvent event) throws IOException {
        game = new Game();
        Stage stage = (Stage) bouton_charger_1.getScene().getWindow();
        stage.close();
    }
    
    @FXML    
    private void handleButtonGoBackAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(new File("src/capitalism/IHM/Windows/Accueil.fxml").toURI().toURL());
        Scene scene = new Scene(fxmlLoader.load(), 630, 400);
        Stage s = new Stage();
        s.setTitle("Capitalism - Accueil");
        s.setResizable(false);
        s.setScene(scene);
        s.show();
        
        Stage stage = (Stage) bouton_retour.getScene().getWindow();
        stage.close();
    }
    
}
