/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Controlleurs.ControlleursIHM;

import capitalism.Capitalism;
import capitalism.Controlleurs.Controlleur_CreationPartie;
import capitalism.IHM.WindowsCode.Game;
import capitalism.Metier.Parties.Partie;
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Azelat
 */
public class CreationPartieController implements Initializable {

    @FXML
    private TextField textField_pseudo;
    @FXML
    private TextField textField_nomEntreprise;
    @FXML
    private Button bouton_retour;
    @FXML
    private Button bouton_valider;
    @FXML
    private ImageView imageView_logo;
    
    private Game game;
    private Capitalism cap;
    private Partie p;
    
    private Controlleur_CreationPartie controlleur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    
    public String getPseudo()
    {
        return this.textField_pseudo.getCharacters().toString();
    }
    
    
    public String getEntreprise()
    {
        return this.textField_nomEntreprise.getCharacters().toString();
    }
    
    public void setControlleur(Controlleur_CreationPartie _controlleur){
        this.controlleur = _controlleur;
    }
    @FXML
    private void handleButtonStartGameAction(ActionEvent event) throws IOException, Throwable {
        if(!this.textField_pseudo.getCharacters().toString().isEmpty() && !this.textField_nomEntreprise.getCharacters().toString().isEmpty())
        {
            if(textField_pseudo.getCharacters().toString().length() > 16)
            {
                System.out.println("Trop long");
            }
            else
            {
                game = new Game(getEntreprise(), getPseudo());
                Stage stage = (Stage) bouton_valider.getScene().getWindow();
                stage.close();
                
            }
        }
        else
        {
            System.out.println("Nope");
        }        
    }
   
    @FXML    
    private void handleButtonGoBackAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(new File("src/capitalism/IHM/Windows/Accueil.fxml").toURI().toURL());
        Scene scene = new Scene(fxmlLoader.load(), 630, 400);
        Stage s = new Stage();
        s.setTitle("Capitalism - Accueil");
        s.setResizable(false);
        s.setScene(scene);
        s.show(); 
        
        Stage stage = (Stage) bouton_retour.getScene().getWindow();
        stage.close();
    }
    
}
