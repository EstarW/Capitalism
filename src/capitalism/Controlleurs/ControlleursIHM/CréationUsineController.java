/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Controlleurs.ControlleursIHM;

import capitalism.Controlleurs.ControlleursIHM.NecessaireDeSurvie.NecessaireDeSurvieCreationUsineController;
import capitalism.IHM.Cases.CaseEmplacementIHM;
import capitalism.Metier.Parties.Carte.Cases.CaseEmplacement;
import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Metier.Parties.Entreprises.Joueur;
import capitalism.Metier.Parties.Usines.Enum.MatierePremiere;
import capitalism.Metier.Parties.Usines.Enum.Produit;
import capitalism.Metier.Parties.Usines.Usine;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Azelat
 */
public class CréationUsineController implements Initializable {

    @FXML
    private TextField textField_nom;
    @FXML
    private Button bouton_valider;
    @FXML
    private Button bouton_annuler;
    @FXML
    private ComboBox<Produit> comboBox_produit;
    @FXML
    private ComboBox<MatierePremiere> comboBox_matiere;
    @FXML 
    private RadioButton button_produit;
    @FXML
    private RadioButton button_matiere;
    
    private Usine usine;
    private boolean check;
    private Entreprise e;
    private Joueur j;
    private CaseEmplacementIHM cIHM;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.AddMp(MatierePremiere.Bois);
        this.AddMp(MatierePremiere.Cereales);
        this.AddMp(MatierePremiere.Metal);
        this.AddMp(MatierePremiere.Nourriture);
        
        this.AddProd(Produit.Acier);
        this.AddProd(Produit.Cagettes);
        this.AddProd(Produit.Conserves);
        
        this.AddProd(Produit.Medicaments);
        this.AddProd(Produit.Meubles);
        this.AddProd(Produit.PC);

        check = false;

    }   
    
    public void setJoueur(Joueur j)
    {
        this.j = j;
    }
    
    public void setEntreprise(Entreprise e)
    {
        this.e = e;
    }
    
    public void AddProd(Produit p){
        comboBox_produit.getItems().add(p);       
    }
    
    public void AddMp(MatierePremiere mp){
        comboBox_matiere.getItems().add(mp);
    }    
    
    
    public Produit getProd()
    {
        return this.comboBox_produit.getValue();
    }
    
    public MatierePremiere getMat()
    {
        return this.comboBox_matiere.getValue();
    }
    
    
    public String getName()
    {
        return this.textField_nom.getCharacters().toString();
    }
    
    
    public void setCaseIHM(CaseEmplacementIHM c)
    {
        this.cIHM = c;
        NecessaireDeSurvieCreationUsineController.setCaseIHM(c);
    }  
    
    public CaseEmplacementIHM getCaseIHM()
    {
        return cIHM;
    }
    
    public boolean matiereCheck()
    {
        boolean res = false;
        if(comboBox_matiere.getValue() != null)
            res = true;
        else
            res = false;
        return res;
    }
    
    public boolean produitCheck()
    {
        boolean res = false;
        if(comboBox_produit.getValue() != null)
            res = true;
        else
            res = false;
        return res;
    }
    
    
    @FXML
    private void handleValiderActionButton(ActionEvent event) throws FileNotFoundException {
        
        CaseEmplacementIHM cIHM2 =  NecessaireDeSurvieCreationUsineController.getCaseIHM();
        
        if(!this.textField_nom.getCharacters().toString().isEmpty())
        {
            if(this.matiereCheck() && !this.produitCheck())
            {
                //Creation de l'usine ressource
                cIHM2.construireUsineMatierePremiere(this.comboBox_matiere.getValue(), this.textField_nom.getText());
                cIHM2.setState();
                CaseEmplacement cEmp = (CaseEmplacement) cIHM2.getC();
            }
            else if(this.produitCheck() && !this.matiereCheck())
            {
                //Creation de l'usine produit
                cIHM2.construireUsineProduit(this.comboBox_produit.getValue(), this.textField_nom.getText());
                cIHM2.setState();
                CaseEmplacement cEmp = (CaseEmplacement) cIHM2.getC();
            }
            System.out.println("Coord : Ligne : " + cIHM2.getCase().getLigne() + " Colonne : " +  cIHM2.getCase().getColonne());
            Stage stage = (Stage) textField_nom.getScene().getWindow();
            cIHM2.getC().getMap().getPartie().getJeu().getControlleur().getView().refreshAffichage();
            stage.close();
            
        }
        else
        {
            Alert alertProd = new Alert(Alert.AlertType.INFORMATION);
            alertProd.setTitle("Erreur de création d'usine !");
            alertProd.setHeaderText("Nom d'usine non saisie !");
            alertProd.setContentText("Assurez vous d'avoir bien sélectionné un nom pour votre usine.");
            alertProd.show();
        }
    }

    @FXML
    private void handleAnnulerActionButton(ActionEvent event) {
        Stage s = (Stage) bouton_annuler.getScene().getWindow();
        s.close();
    }     
    
}
