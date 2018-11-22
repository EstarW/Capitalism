/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.WindowsCode;

import java.io.File;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Azelat
 */
public class GererUsine extends Parent{
    
    
    public GererUsine() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(new File("src/capitalism/IHM/Windows/GererUsine.fxml").toURI().toURL()); 
        AnchorPane node = fxmlLoader.load();
        node.setTranslateX(0);
        node.setTranslateY(0);
        this.getChildren().add(node);
    }
    
    public void ShowWindow()
    {
        this.setVisible(true);
    }
    
    public void HideWindow()
    {
        this.setVisible(false);
    }
}
