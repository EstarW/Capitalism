/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.WindowsCode;

import capitalism.Capitalism;
import capitalism.Controlleurs.ControlleursIHM.EcranVenteController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author yv066840
 */
public class MenuVente {

    private Game g;
    private EcranVenteController controller;
    
    public MenuVente(Game game) throws IOException {
        this.g = g;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Capitalism.class.getResource("IHM/Windows/EcranVente.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 700, 500);
        Stage stage = new Stage();
        stage.setTitle("Menu de vente");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
        this.controller = new EcranVenteController();
    }
    
}
