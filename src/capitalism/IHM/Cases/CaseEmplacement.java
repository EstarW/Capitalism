/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Cases;

import java.io.File;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Azelat
 */
public class CaseEmplacement extends Case {
    
    private double X;
    private double Y;
    private int state;
    private Stage s;
    private Scene scene;
    
    public CaseEmplacement(double X, double Y) throws IOException {
        super(X, Y);
        Rectangle rec = new Rectangle(50,50,Color.GREY);
        rec.setStroke(Color.rgb(0,0,0, 0.5));
        rec.setStrokeWidth(1);
        rec.setX(X);
        rec.setY(Y);
        state = 0;
        this.getChildren().add(rec);
        
        FXMLLoader fxmlLoader = new FXMLLoader(new File("src/capitalism/IHM/Windows/MenuContextuelInGame.fxml").toURI().toURL());
        scene = new Scene(fxmlLoader.load(), 630, 400);
        s = new Stage();
        s.setTitle("Capitalism - Visualisation d'usine");
        s.setResizable(false);
        s.setScene(scene);
           
                    
        this.setOnMouseEntered((MouseEvent me) -> {
            rec.setFill(Color.rgb(0,0,0,0.8)); 
        });
        
        this.setOnMouseExited((MouseEvent me) -> {
            rec.setFill(Color.GREY);
        });
        
        this.setOnMouseClicked((MouseEvent me) -> {
            s.show(); 
        });
    }
    
    
    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public void setX(double X) {
        this.X = X;
    }

    public void setY(double Y) {
        this.Y = Y;
    }
    
    
}
