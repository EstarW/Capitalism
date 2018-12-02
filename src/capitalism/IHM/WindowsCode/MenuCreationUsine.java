/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.WindowsCode;

import capitalism.IHM.Cases.CaseEmplacement;
import capitalism.IHM.Windows.CréationUsineController;
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
public class MenuCreationUsine {
    
    private Stage s2;
    private Scene menuCreationUsine;
    private CaseEmplacement c;
    
    public MenuCreationUsine(CaseEmplacement c) throws MalformedURLException, IOException, InterruptedException{
        FXMLLoader fxmlLoader = new FXMLLoader(new File("src/capitalism/IHM/Windows/créationUsine.fxml").toURI().toURL());
        menuCreationUsine = new Scene(fxmlLoader.load(), 630, 400);
        s2 = new Stage();
        s2.setTitle("Création d'usine");
        s2.setResizable(false);
        s2.setScene(menuCreationUsine);
        s2.show();
        this.c = c;
    }
    
}
