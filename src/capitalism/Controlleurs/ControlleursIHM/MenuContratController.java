/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Controlleurs.ControlleursIHM;

import capitalism.IHM.WindowsCode.Game;
import capitalism.Metier.Parties.Contrats.Contrat;
import capitalism.Metier.Parties.Contrats.ContratVenteMatierePremiere;
import capitalism.Metier.Parties.Contrats.ContratVenteProduit;
import capitalism.Metier.Parties.Contrats.TypeContrat;
import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Metier.Parties.Usines.Enum.MatierePremiere;
import capitalism.Metier.Parties.Usines.Enum.Produit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
    private ComboBox<Contrat> cbContratAttente;
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
    private ComboBox<Contrat> cbContrat;
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
    
        for(Contrat c : g.getJCourant().getListeContratAttente()){
            this.cbContratAttente.getItems().add(c);
        }
        
        for(Contrat c : g.getJCourant().getListeContrat()){
            this.cbContrat.getItems().add(c);
        }
        

        
        this.bAccepter.setVisible(false);
        this.bAnnuler.setVisible(false);
        this.bDecliner.setVisible(false);
        this.initAttente();
        this.initListe();
    }   
    
    private void initListe(){
        this.lDest.setText("");
        this.lDuree.setText("");
        this.lMontant.setText("");
        this.lProprio.setText("");
        this.lQte.setText("");
        this.lRessource.setText("");
    }
    
    private void initAttente(){
        this.lProprioAttente.setText("");
        this.LMontatAttente.setText("");
        this.lDestAttente.setText("");
        this.lDureeAttente.setText("");
        this.lQteAttente.setText("");
        this.lRessourceAttente.setText("");
    }
    
    @FXML
    private void btnProduit(ActionEvent event) {
                
        this.bMP.setSelected(false);
        
    }
    
    @FXML
    private void annuler(ActionEvent event){
        if (this.cbContratAttente.getSelectionModel().getSelectedItem()!=null){
            Contrat c =this.cbContratAttente.getSelectionModel().getSelectedItem();
            c.annuler();
            this.initAttente();
            this.cbContratAttente.getItems().remove(c);
        }
        
    }
    
    @FXML
    private void listContratChange(ActionEvent event){
        if (this.cbContratAttente.getSelectionModel().getSelectedItem() !=null){
            Contrat c = this.cbContratAttente.getSelectionModel().getSelectedItem();
            if(c.getTypeContrat()== TypeContrat.VenteMatierePremiere){
                ContratVenteMatierePremiere cmp = (ContratVenteMatierePremiere) c;
                this.LMontatAttente.setText(String.valueOf(cmp.getPrix()));
                this.lDestAttente.setText(cmp.getEntDestinataire().getNom());
                this.lDureeAttente.setText(String.valueOf(cmp.getDuree()));
                this.lProprioAttente.setText(cmp.getEntSource().toString());
                this.lQteAttente.setText(String.valueOf(cmp.getDuree()));
                this.lRessourceAttente.setText(cmp.getMp().toString());
            }
            else {
                ContratVenteProduit cp = (ContratVenteProduit) c;
                this.LMontatAttente.setText(String.valueOf(cp.getPrix()));
                this.lDestAttente.setText(cp.getEntDestinataire().getNom());
                this.lDureeAttente.setText(String.valueOf(cp.getDuree()));
                this.lProprioAttente.setText(cp.getEntSource().toString());
                this.lQteAttente.setText(String.valueOf(cp.getDuree()));
                this.lRessourceAttente.setText(cp.getP().toString());
            }
            
            if (this.lProprioAttente.getText().equals(g.getJCourant().getNom())){
                this.bAnnuler.setVisible(true);
            }
            else {
                this.bAccepter.setVisible(true);
                this.bDecliner.setVisible(true);
            }
        }
    }

    @FXML
    private void btnMP(ActionEvent event) {
        this.bProduit.setSelected(false);

    }

    @FXML
    private void changeList(ActionEvent event){
        Contrat c = this.cbContrat.getSelectionModel().getSelectedItem();
        if(c !=null){
            if(c.getTypeContrat()== TypeContrat.VenteMatierePremiere){
                ContratVenteMatierePremiere cmp = (ContratVenteMatierePremiere) c;
                this.lMontant.setText(String.valueOf(cmp.getPrix()));
                this.lDest.setText(cmp.getEntDestinataire().getNom());
                this.lDuree.setText(String.valueOf(cmp.getDuree()));
                this.lProprio.setText(cmp.getEntSource().toString());
                this.lQte.setText(String.valueOf(cmp.getDuree()));
                this.lRessource.setText(cmp.getMp().toString());
            }
            else {
                ContratVenteProduit cp = (ContratVenteProduit) c;
                this.lMontant.setText(String.valueOf(cp.getPrix()));
                this.lDest.setText(cp.getEntDestinataire().getNom());
                this.lDuree.setText(String.valueOf(cp.getDuree()));
                this.lProprio.setText(cp.getEntSource().toString());
                this.lQte.setText(String.valueOf(cp.getDuree()));
                this.lRessource.setText(cp.getP().toString());
            }
        }
            

    }
    private void resetNewContrat(){
        this.tfDuree.setText("");
        this.tfNom.setText("");
        this.tfPrix.setText("");
        this.tfQuantite.setText("");
        this.bMP.setSelected(false);
        this.bProduit.setSelected(false);
        this.cbEntrep.getItems().removeAll(this.cbEntrep.getItems());
         for(Entreprise e : g.getP().getListeEnt()){
            this.cbEntrep.getItems().add(e);
        }
         this.cbEntrep.getItems().remove(g.getJCourant());
        this.comboBox_matiere.getItems().removeAll(this.comboBox_matiere.getItems());
        this.comboBox_produit.getItems().removeAll(this.comboBox_produit.getItems());
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
    private void proposerContrat(ActionEvent event) {
        boolean a;
        a = ((this.comboBox_matiere.getSelectionModel().getSelectedItem() != null && this.bMP.isSelected()) || (this.comboBox_produit.getSelectionModel().getSelectedItem() !=null && this.bProduit.isSelected()));
        if(this.cbEntrep.getSelectionModel().getSelectedItem()!=null && !tfNom.getText().isEmpty() && ! this.tfPrix.getText().isEmpty() && !this.tfQuantite.getText().isEmpty() && !this.tfDuree.getText().isEmpty() && (a)){
            
            if (this.estUnEntier(this.tfDuree.getText())&& this.estUnEntier(this.tfPrix.getText()) &&this.estUnEntier(this.tfQuantite.getText())){
                Contrat c;
                if(this.bMP.isSelected()){
                    c = new ContratVenteMatierePremiere(this.tfNom.getText(),Integer.parseInt(this.tfPrix.getText()), Integer.parseInt(this.tfQuantite.getText()), g.getJCourant(), this.cbEntrep.getSelectionModel().getSelectedItem(), Integer.parseInt(this.tfDuree.getText()), this.comboBox_matiere.getSelectionModel().getSelectedItem());
                    this.cbContratAttente.getItems().add(c);
                    this.resetNewContrat();                    
                }
                else{
                   c = new ContratVenteProduit(this.tfNom.getText(),Integer.parseInt(this.tfPrix.getText()), Integer.parseInt(this.tfQuantite.getText()), this.comboBox_produit.getSelectionModel().getSelectedItem(),g.getJCourant(), this.cbEntrep.getSelectionModel().getSelectedItem(), Integer.parseInt(this.tfDuree.getText()));
                   this.cbContratAttente.getItems().add(c);                
                   this.resetNewContrat();
                }
                Alert alertProd = new Alert(Alert.AlertType.INFORMATION);
                alertProd.setTitle("Contrat créé ");
                alertProd.setHeaderText("Le contrat a bien été envoyé !");
                alertProd.setContentText("L'entreprise "+ c.getEntDestinataire() + " a bien reçu votre contrat ! ");
                alertProd.show();
                
            }
            else {
            Alert alertProd = new Alert(Alert.AlertType.INFORMATION);
            alertProd.setTitle("Champs non entier !");
            alertProd.setHeaderText("Un des champs numériques a mal été renseigné !");
            alertProd.setContentText("Assurez vous d'avoir bien saisi un entier supérieur à 0 pour le prix d'achat, la quantité et la durée !");
            alertProd.show();
            }
        }
        else {
            Alert alertProd = new Alert(Alert.AlertType.INFORMATION);
            alertProd.setTitle("Champs non renseignés !");
            alertProd.setHeaderText("Un champ n'a pas été renseigné !");
            alertProd.setContentText("Assurez vous d'avoir bien saisi tous les champs !");
            alertProd.show();
        }
    }

    @FXML
    private void accepter(ActionEvent event) {
        Contrat c = this.cbContratAttente.getSelectionModel().getSelectedItem();
        c.accepter();
        this.cbContratAttente.getItems().remove(c);
    }

    @FXML
    private void decliner(ActionEvent event) {
        Contrat c =this.cbContratAttente.getSelectionModel().getSelectedItem();
        c.annuler();
        this.cbContratAttente.getItems().remove(c);
        
    }

    @FXML
    private void resilier(ActionEvent event) {
        Contrat c = this.cbContrat.getSelectionModel().getSelectedItem();
        c.resilier();
        this.cbContrat.getItems().remove(c);
        this.initListe();
    }
    
    public boolean estUnEntier(String chaine) {
        boolean rez;
        try {
            Integer.parseInt(chaine);
            if(Integer.parseInt(chaine)>0){
                rez = true;
            }
            else {
                rez = false;
            }
        } catch (NumberFormatException e){
            rez = false;
        }

        return rez;
    }
}
