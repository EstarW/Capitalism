/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.WindowsCode;

import capitalism.Capitalism;
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
public class ApercuVille extends Parent{

    @FXML
    private AnchorPane rootPane;
    
    public ApercuVille() throws IOException
    {
        rootPane = new AnchorPane();
                FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Capitalism.class.getResource("IHM/Windows/AperçuVille.fxml"));
        Parent root = loader.load();

        
        Scene scene = new Scene(root, 630, 400);
        Stage stage = new Stage();
        stage.setTitle("Aperçu de la ville");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}
