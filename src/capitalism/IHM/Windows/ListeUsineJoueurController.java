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
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Azelat
 */
public class ListeUsineJoueurController implements Initializable {

    @FXML
    private ListView<?> listView_1;
    @FXML
    private ListView<?> listView_2;
    @FXML
    private ListView<?> listView_3;
    @FXML
    private Button boutonGérer_1;
    @FXML
    private Button boutonGérer_2;
    @FXML
    private Button boutonGérer_3;
    
    private AnchorPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    @FXML
    private void handleGestionActionButton(ActionEvent event) throws IOException {
        System.out.println("Gérer Usine");
        rootPane = new AnchorPane();
        FXMLLoader fxmlLoader = new FXMLLoader(new File("src/capitalism/IHM/Windows/GererUsine.fxml").toURI().toURL()); 

        
        Scene scene = new Scene(fxmlLoader.load(), 630, 400);
        Stage stage = new Stage();
        stage.setTitle("Gestion d'Usine");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();          
    }
    
}
