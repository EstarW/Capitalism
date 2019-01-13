/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.WindowsCode;

import capitalism.Capitalism;
import capitalism.Controlleurs.ControlleursIHM.MenuContratController;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Beelzed
 */
public class MenuContrat {
    private  Game g;
    private MenuContratController mc;
    
    public MenuContrat(Game ga) throws IOException {
        
        MenuContratController.setG(ga);
        this.g = ga;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Capitalism.class.getResource("IHM/Windows/MenuContrat.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Menu de contrat");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        this.mc = new MenuContratController();
    }
    
}
