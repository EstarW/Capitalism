/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism;

import capitalism.Metier.Jeu;
import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Azelat
 */
public class Capitalism extends Application {
    
    private double scaleX = 1;
    private double scaleY = 1;



    @Override
    public void start(Stage primaryStage) throws IOException {
    
        FXMLLoader fxmlLoader = new FXMLLoader(new File("src/capitalism/IHM/Windows/Accueil.fxml").toURI().toURL()); 
        Scene scene = new Scene(fxmlLoader.load(), 630, 400);
        primaryStage.setTitle("Capitalism - Accueil");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
