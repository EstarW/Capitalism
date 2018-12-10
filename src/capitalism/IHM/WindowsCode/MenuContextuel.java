/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.WindowsCode;

import capitalism.IHM.Cases.CaseEmplacementIHM;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Azelat
 */
public class MenuContextuel {

    private Scene menuContextuel;
    private Stage s1;
    private CaseEmplacementIHM c;
    
    public MenuContextuel(CaseEmplacementIHM c) throws IOException, MalformedURLException{
        FXMLLoader fxmlLoader = new FXMLLoader(new File("src/capitalism/IHM/Windows/MenuContextuelInGame.fxml").toURI().toURL());
        menuContextuel = new Scene(fxmlLoader.load(), 630, 400);
        s1 = new Stage();
        s1.setTitle("Capitalism - Visualisation d'usine");
        s1.setResizable(false);
        s1.setScene(menuContextuel);
        s1.show();
        this.c = c;
    }
}
