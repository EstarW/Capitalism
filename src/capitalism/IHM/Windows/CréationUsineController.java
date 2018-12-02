/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Windows;

import capitalism.Game;
import capitalism.IHM.Cases.Case;
import capitalism.IHM.Cases.ListeCase;
import com.sun.jnlp.ApiDialog.DialogResult;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Azelat
 */
public class CréationUsineController implements Initializable {

    @FXML
    private TextField textArea_nom;
    @FXML
    private ComboBox<?> comboBox_production;
    @FXML
    private Button bouton_valider;
    @FXML
    private Button bouton_annuler;
    
    private boolean state = false;
    private boolean dialog = false;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public Case getCase(){   
        return null;
    }
    
    public String getProd()
    {
        return this.comboBox_production.getValue().toString();
    }
    
    
    public String getName()
    {
        return this.textArea_nom.getCharacters().toString();
    }
    
    @FXML
    private void handleButtonActionValider(ActionEvent event) throws IOException, Throwable {
        if(!this.textArea_nom.getCharacters().toString().isEmpty())
        {
            Stage stage = (Stage) textArea_nom.getScene().getWindow();
            stage.close();
            state = true;
            dialog = true;
            
        }
        else
        {
            System.out.println("Nope");
        }        
    }
   
    @FXML    
    private void handleButtonActionAnnuler(ActionEvent event) throws IOException {       
        Stage stage = (Stage) textArea_nom.getScene().getWindow();
        stage.close();
        state = false;
        dialog = false;
    }
    
    public boolean getState(){
        return state;
    }
    
    public boolean getDialog(){
        return dialog;
    }
    
}
