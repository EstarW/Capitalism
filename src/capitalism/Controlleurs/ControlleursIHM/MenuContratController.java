/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Controlleurs.ControlleursIHM;

import capitalism.IHM.WindowsCode.Game;
import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Metier.Parties.Usines.Enum.MatierePremiere;
import capitalism.Metier.Parties.Usines.Enum.Produit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Beelzed
 */
public class MenuContratController implements Initializable {

    @FXML
    private ComboBox<Entreprise> cbEntrep;
    @FXML
    private RadioButton bProduit;
    @FXML
    private RadioButton bMP;
    @FXML
    private ComboBox<Produit> comboBox_produit;
    @FXML
    private ComboBox<MatierePremiere> comboBox_matiere;
    @FXML
    private Button btnProp;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrix;
    @FXML
    private TextField tfQuantite;
    @FXML
    private TextField tfDuree;
    @FXML
    private ComboBox<?> cbContratAttente;
    @FXML
    private Label lDestAttente;
    @FXML
    private Label lProprioAttente;
    @FXML
    private Label lRessourceAttente;
    @FXML
    private Label lQteAttente;
    @FXML
    private Label LMontatAttente;
    @FXML
    private Label lDureeAttente;
    @FXML
    private Button bAccepter;
    @FXML
    private Button bDecliner;
    @FXML
    private Button bAnnuler;
    @FXML
    private ComboBox<?> cbContrat;
    @FXML
    private Label lProprio;
    @FXML
    private Label lDest;
    @FXML
    private Label lRessource;
    @FXML
    private Label lQte;
    @FXML
    private Label lMontant;
    @FXML
    private Label lDuree;
    @FXML
    private Button btnResilier;

    private static Game g;

    public static void setG(Game g) {
        MenuContratController.g = g;
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        for(Entreprise e : g.getP().getListeEnt()){
            this.cbEntrep.getItems().add(e);
        }
        this.cbEntrep.getItems().remove(g.getJCourant());
        
        this.comboBox_matiere.getItems().add(MatierePremiere.Bois);
        this.comboBox_matiere.getItems().add(MatierePremiere.Cereales);
        this.comboBox_matiere.getItems().add(MatierePremiere.Metal);
        this.comboBox_matiere.getItems().add(MatierePremiere.Nourriture);
        
        this.comboBox_produit.getItems().add(Produit.Acier);
        
        this.comboBox_produit.getItems().add(Produit.Cagettes);
        this.comboBox_produit.getItems().add(Produit.Conserves);
        this.comboBox_produit.getItems().add(Produit.Medicaments);
        this.comboBox_produit.getItems().add(Produit.Meubles);
        this.comboBox_produit.getItems().add(Produit.PC);
    }    

    @FXML
    private void btnProduit(ActionEvent event) {
                
        this.bMP.setSelected(false);
        
    }

    @FXML
    private void btnMP(ActionEvent event) {
        this.bProduit.setSelected(false);

    }

    @FXML
    private void proposerContrat(ActionEvent event) {
    }

    @FXML
    private void accepter(ActionEvent event) {
    }

    @FXML
    private void decliner(ActionEvent event) {
    }

    @FXML
    private void resilier(ActionEvent event) {
    }
    
}
