    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Controlleurs.ControlleursIHM;

import capitalism.Controlleurs.ControlleursIHM.NecessaireDeSurvie.NecessaireDeSurvieSauvegarde;
import capitalism.IHM.WindowsCode.Accueil;
import capitalism.IHM.WindowsCode.Game;
import capitalism.Metier.Jeu;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
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
                    Alert alertName = new Alert(Alert.AlertType.INFORMATION);
                    alertName.setTitle("Erreur de création de partie !");
                    alertName.setHeaderText("Nom trop long !");
                    alertName.setContentText("Votre pseudonyme et votre nom d'Entreprise ne peuvent pas excéder 16 caractères.");
                    alertName.show();
            }
            else
            {
                game = new Game(getEntreprise(), getPseudo(), j);
                NecessaireDeSurvieSauvegarde.setJ(j);
                Stage stage = (Stage) bouton_valider.getScene().getWindow();
                stage.close();
            }
        }
        else
        {
                    Alert alertCrea = new Alert(Alert.AlertType.INFORMATION);
                    alertCrea.setTitle("Erreur de création de partie !");
                    alertCrea.setHeaderText("Champ texte invalide !");
                    alertCrea.setContentText("Assurez vous d'avoir bien saisie vos noms dans chaque champ disponible.");
                    alertCrea.show();
        }        
    }
    
    @FXML
    private void handleButtonSelectImage(ActionEvent event) throws IOException{    
        Stage s = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélection d'image");
        File f = fileChooser.showOpenDialog(s);   

        if (f != null){
            if(f.getAbsolutePath().endsWith(".png") || f.getAbsolutePath().endsWith(".jpg") || f.getAbsolutePath().endsWith(".jpeg")){
                Image image = new Image(f.toURI().toString());
                imageView_logo.setImage(image);
                j.seteImage(f.toURI().toString());
            }
            else{
                    Alert alertExtension = new Alert(Alert.AlertType.INFORMATION);
                    alertExtension.setTitle("Erreur de chargement !");
                    alertExtension.setHeaderText("Extension de fichier invalide !");
                    alertExtension.setContentText("Vous ne pouvez charger que des fichiers .png, .jpg ou .jpeg");
                    alertExtension.show();
            }
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