/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Controlleurs.ControlleursIHM;

import capitalism.IHM.WindowsCode.Accueil;
import capitalism.IHM.WindowsCode.Game;
import capitalism.Metier.Jeu;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private static Jeu j;

    

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
                Jeu jeu = this.getJeu();
                game = new Game(getEntreprise(), getPseudo(), j);
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
        Accueil a = new Accueil(j);
        
        Stage stage = (Stage) bouton_retour.getScene().getWindow();
        stage.close();
    }

    public void setJeu(Jeu j) {
        this.j = j;
    }
    
    public Jeu getJeu(){
        return j;
    }
    
}
