/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Windows;

import capitalism.Controlleurs.Controlleur_Jeu;
import capitalism.Controlleurs.Controlleur_Usines;
import capitalism.Metier.Parties.Carte.Cases.Case;
import capitalism.Metier.Parties.Carte.Cases.CaseEmplacement;
import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Metier.Parties.Entreprises.Joueur;
import capitalism.Metier.Parties.MatierePremiere;
import capitalism.Metier.Parties.Produit;
import capitalism.Metier.Parties.Usines.Usine;
import capitalism.Metier.Parties.Usines.UsineMatierePremiere;
import capitalism.Metier.Parties.Usines.UsineProduit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
    private Controlleur_Jeu cu;
    private Case c;
    private boolean check;
    private Entreprise e;
    private Joueur j;
    

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
        this.AddProd(Produit.Meubles);
        this.AddProd(Produit.PlaqueMetal);
        
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
    
    
    public void setCase(Case c)
    {
        this.c = c;
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
    private void handleValiderActionButton(ActionEvent event) {
        
        if(!this.textField_nom.getCharacters().toString().isEmpty())
        {
            if(this.matiereCheck() && !this.produitCheck())
            {
                //Creation de l'usine ressource
            }
            else if(this.produitCheck() && !this.matiereCheck())
            {
                //Creation de l'usine produit

            }
            
            Stage stage = (Stage) textField_nom.getScene().getWindow();
            stage.close();
            
        }
        else
        {
            System.out.println("Nope");
        }
    }

    @FXML
    private void handleAnnulerActionButton(ActionEvent event) {
        Stage s = (Stage) bouton_annuler.getScene().getWindow();
        s.close();
    }
    
}
