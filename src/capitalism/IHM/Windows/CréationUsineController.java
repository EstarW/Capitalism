/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Windows;

import capitalism.Metier.Parties.MatierePremiere;
import capitalism.Metier.Parties.Produit;
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
    
    private ToggleGroup group = new ToggleGroup();
    

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
        
        button_produit.setToggleGroup(group);
        button_produit.setSelected(true);
        button_matiere.setToggleGroup(group);
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
    
    @FXML
    private void handleValiderActionButton(ActionEvent event) {
        
        if(!this.textField_nom.getCharacters().toString().isEmpty() && !(this.comboBox_produit.getValue() == null))
        {
            /*if(this.comboBox_production.getValue() == prod.Acier || this.comboBox_production.getValue() == prod.Bois)
            {
                usine = new UsineMatierePremiere(this.textArea_nom.getCharacters().toString(), j, c, this.comboBox_production.getValue()); 
                cu = new Controlleur_Usines(usine, this);
                //cu = new Controlleur_Usines(this.comboBox_production.getValue(), this.textArea_nom.getCharacters().toString());
            }
            if(this.comboBox_production.getValue() == prod.Cagettes || this.comboBox_production.getValue() == prod.PlaqueMetal || this.comboBox_production.getValue() == prod.Conserves || this.comboBox_production.getValue() == prod.Meubles){
                cu = new Controlleur_Usines(usine, this);
            }*/
            
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
