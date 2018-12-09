/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Windows;

import capitalism.Controlleurs.Controlleur_Usines;
import capitalism.Game;
import capitalism.IHM.Cases.Case;
import capitalism.IHM.Cases.ListeCase;
import capitalism.Metier.Parties.Carte.Cases.CaseEmplacement;
import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Metier.Parties.Entreprises.Joueur;
import capitalism.Metier.Parties.MatierePremiere;
import capitalism.Metier.Parties.Produit;
import capitalism.Metier.Parties.Usines.Usine;
import capitalism.Metier.Parties.Usines.UsineMatierePremiere;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JFrame;

/**
 * FXML Controller class
 *
 * @author Azelat
 */
public class CréationUsineController implements Initializable {

    @FXML
    private TextField textArea_nom;
    @FXML
    private ComboBox<Produit> comboBox_production;
    @FXML
    private Button bouton_valider;
    @FXML
    private Button bouton_annuler;
    
    private Produit prod;
    private Usine usine;
    private Controlleur_Usines cu;
    private Joueur j;
    private MatierePremiere mp;
    
    private boolean state = false;
    private boolean dialog = false;
    
    private CaseEmplacement c;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {     
       /* this.AddMp(mp.Bois);
        this.AddMp(mp.Cereales);
        this.AddMp(mp.Metal);
        this.AddMp(mp.Nourriture);*/
        
        this.AddProd(prod.Acier);
        this.AddProd(prod.Cagettes);
        this.AddProd(prod.Conserves);
        this.AddProd(prod.Meubles);
        this.AddProd(prod.PlaqueMetal);
    }   
    
    public void AddProd(Produit p){
        comboBox_production.getItems().add(p);       
    }
    
    /*public void AddMp(MatierePremiere mp){
        comboBox_production.getItems().add(mp);
    }*/
    
    /*public Case getCase(){   
        return c;
    }*/
    
    public Produit getProd()
    {
        return this.comboBox_production.getValue();
    }
    
    
    public String getName()
    {
        return this.textArea_nom.getCharacters().toString();
    }
    
    @FXML
    private void handleButtonActionValider(ActionEvent event) throws IOException, Throwable {
        if(!this.textArea_nom.getCharacters().toString().isEmpty() && !(this.comboBox_production.getValue() == null))
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
