/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.WindowsCode;

import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Azelat
 */
public class MenuJeu extends Parent {

    @FXML
    private final AnchorPane rootPane;
    
    public MenuJeu() throws IOException
    {
        rootPane = new AnchorPane();
        FXMLLoader fxmlLoader = new FXMLLoader(new File("src/capitalism/IHM/Windows/menu_echap.fxml").toURI().toURL()); 

        
        Scene scene = new Scene(fxmlLoader.load(), 630, 400);
        Stage stage = new Stage();
        stage.setTitle("Menu");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }    
}
