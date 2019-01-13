/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Controlleurs.ControlleursIHM;

import capitalism.IHM.WindowsCode.Game;
import capitalism.Metier.Parties.Usines.Enum.MatierePremiere;
import capitalism.Metier.Parties.Usines.Enum.Produit;
import capitalism.Metier.Parties.ValeursDesChoses;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.SwipeEvent;

/**
 * FXML Controller class
 *
 * @author yv066840
 */
public class EcranVenteController implements Initializable {

    @FXML
    private Spinner<Integer> CBBois;
    @FXML
    private Button BVenteBois;
    @FXML
    private Label lQteBois;
    @FXML
    private Label labelPrixBois;
    @FXML
    private Spinner<Integer> CBCereales;
    @FXML
    private Button BVenteCereales;
    @FXML
    private Label lQteCereales;
    @FXML
    private Label labelPrixCereale;
    @FXML
    private Spinner<Integer> CBMetal;
    @FXML
    private Button BVenteMetal;
    @FXML
    private Label lQteMetal;
    @FXML
    private Label labelPrixMetal;
    @FXML
    private Spinner<Integer> CBNourriture;
    @FXML
    private Button BVenteNourriture;
    @FXML
    private Label lQteNourriture;
    @FXML
    private Label labelPrixNourriture;
    @FXML
    private Spinner<Integer> CBAcier;
    @FXML
    private Button BVenteAcier;
    @FXML
    private Label lQteAcier;
    @FXML
    private Label labelPrixAcier;
    @FXML
    private Spinner<Integer> CBCagettes;
    @FXML
    private Button BVenteCagettes;
    @FXML
    private Label lQteCagettes;
    @FXML
    private Label labelPrixCagettes;
    @FXML
    private Spinner<Integer> CBConserves;
    @FXML
    private Button BVenteConserves;
    @FXML
    private Label lQteConserves;
    @FXML
    private Label labelPrixConserves;
    @FXML
    private Spinner<Integer> CBMedicaments;
    @FXML
    private Button BVenteMedicaments;
    @FXML
    private Label lQteMedicaments;
    @FXML
    private Label labelPrixMedicaments;
    @FXML
    private Spinner<Integer> CBMeubles;
    @FXML
    private Button BVenteMeubles;
    @FXML
    private Label lQteMeubles;
    @FXML
    private Label labelPrixMeubles;
    @FXML
    private Spinner<Integer> CBPC;
    @FXML
    private Button BVentePC;
    @FXML
    private Label lQtePC;
    @FXML
    private Label labelPrixPC;
    
    private static Game g;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //init valeurs des choses
        this.labelPrixAcier.setText(String.valueOf(ValeursDesChoses.getpVenteAcier()) + " $");
        this.labelPrixBois.setText(String.valueOf(ValeursDesChoses.getpVenteBois())+ " $");
        this.labelPrixCereale.setText(String.valueOf(ValeursDesChoses.getpVenteCereales())+ " $");
        this.labelPrixMetal.setText(String.valueOf(ValeursDesChoses.getpVenteMetal())+ " $");
        this.labelPrixNourriture.setText(String.valueOf(ValeursDesChoses.getpVenteNourriture())+ " $");
        this.labelPrixCagettes.setText(String.valueOf(ValeursDesChoses.getpVenteCagettes())+ " $");
        this.labelPrixConserves.setText(String.valueOf(ValeursDesChoses.getpVenteConserves())+ " $");
        this.labelPrixMedicaments.setText(String.valueOf(ValeursDesChoses.getpVenteMedicaments())+ " $");
        this.labelPrixMeubles.setText(String.valueOf(ValeursDesChoses.getpVenteMeubles())+ " $");
        this.labelPrixPC.setText(String.valueOf(ValeursDesChoses.getpVentePC())+ " $");
        
        //init qte
        

        this.updateQte();
        initSpin();
    }    

    private void initSpin(){
        this.CBAcier.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100));
        this.CBBois.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100));
        this.CBCagettes.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100));
        this.CBCereales.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100));
        this.CBConserves.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100));
        this.CBMedicaments.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100));
        this.CBMetal.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100));
        this.CBMeubles.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100));
        this.CBNourriture.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100));
        this.CBPC.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100));

    }
    
    @FXML
    private void VenteBois(ActionEvent event) {
        if(this.CBBois.getValue() > g.getJCourant().getMatieresPremieresPossedees().get(MatierePremiere.Bois)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Impossible de vendre !");
            alert.setHeaderText("Vous ne pouvez pas vendre plus de bois que ce que vous possédez !");
            alert.setContentText("Vous essayez de vendre " + this.CBBois.getValue() + " unité(s) de bois alors que vous n'en possédez que "+ g.getJCourant().getMatieresPremieresPossedees().get(MatierePremiere.Bois) + " ! Diminuez un peu la quantité pour voir !");
            alert.show();
        }
        else {
            g.getJCourant().getMatieresPremieresPossedees().replace(MatierePremiere.Bois, g.getJCourant().getMatieresPremieresPossedees().get(MatierePremiere.Bois)-this.CBBois.getValue());
            g.getJCourant().addArgent(this.CBBois.getValue() * ValeursDesChoses.getpVenteBois());
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Vente effectuée !");
            alert.setHeaderText("Vous avez vendu pour " + this.CBBois.getValue() * ValeursDesChoses.getpVenteBois() + " $ de bois !");
            alert.setContentText("Vous avez vendu " + this.CBBois.getValue() + " unités de bois, il vous en reste " + g.getJCourant().getMatieresPremieresPossedees().get(MatierePremiere.Bois));
            alert.show();
            this.updateQte();
            this.CBBois.getValueFactory().setValue(0);
            g.refreshAffichage();
        }
    }

    @FXML
    private void VenteCereales(ActionEvent event) {
        if(this.CBCereales.getValue() > g.getJCourant().getMatieresPremieresPossedees().get(MatierePremiere.Cereales)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Impossible de vendre !");
            alert.setHeaderText("Vous ne pouvez pas vendre plus de cereales que ce que vous possédez !");
            alert.setContentText("Vous essayez de vendre " + this.CBCereales.getValue() + " unité(s) de cereales alors que vous n'en possédez que "+ g.getJCourant().getMatieresPremieresPossedees().get(MatierePremiere.Cereales) + " ! Diminuez un peu la quantité pour voir !");
            alert.show();
        }
        else {
            g.getJCourant().getMatieresPremieresPossedees().replace(MatierePremiere.Cereales, g.getJCourant().getMatieresPremieresPossedees().get(MatierePremiere.Cereales)-this.CBCereales.getValue());
            g.getJCourant().addArgent(this.CBCereales.getValue() * ValeursDesChoses.getpVenteCereales());
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Vente effectuée !");
            alert.setHeaderText("Vous avez vendu pour " + this.CBCereales.getValue() * ValeursDesChoses.getpVenteCereales() + " $ de cereales !");
            alert.setContentText("Vous avez vendu " + this.CBCereales.getValue() + " unités de cereales, il vous en reste " + g.getJCourant().getMatieresPremieresPossedees().get(MatierePremiere.Cereales));
            alert.show();
            this.updateQte();
            this.CBCereales.getValueFactory().setValue(0);
            g.refreshAffichage();
        }
    }

    @FXML
    private void VenteMetal(ActionEvent event) {
        if(this.CBMetal.getValue() > g.getJCourant().getMatieresPremieresPossedees().get(MatierePremiere.Metal)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Impossible de metal !");
            alert.setHeaderText("Vous ne pouvez pas vendre plus de metal que ce que vous possédez !");
            alert.setContentText("Vous essayez de vendre " + this.CBMetal.getValue() + " unité(s) de metal alors que vous n'en possédez que "+ g.getJCourant().getMatieresPremieresPossedees().get(MatierePremiere.Metal) + " ! Diminuez un peu la quantité pour voir !");
            alert.show();
        }
        else {
            g.getJCourant().getMatieresPremieresPossedees().replace(MatierePremiere.Metal, g.getJCourant().getMatieresPremieresPossedees().get(MatierePremiere.Metal)-this.CBMetal.getValue());
            g.getJCourant().addArgent(this.CBMetal.getValue() * ValeursDesChoses.getpVenteMetal());
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Vente effectuée !");
            alert.setHeaderText("Vous avez vendu pour " + this.CBMetal.getValue() * ValeursDesChoses.getpVenteMetal() + " $ de metal !");
            alert.setContentText("Vous avez vendu " + this.CBMetal.getValue() + " unités de metal, il vous en reste " + g.getJCourant().getMatieresPremieresPossedees().get(MatierePremiere.Metal));
            alert.show();
            this.updateQte();
            this.CBMetal.getValueFactory().setValue(0);
            g.refreshAffichage();
        }
    }

    @FXML
    private void VenteNourriture(ActionEvent event) {
        if(this.CBNourriture.getValue() > g.getJCourant().getMatieresPremieresPossedees().get(MatierePremiere.Nourriture)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Impossible de vendre !");
            alert.setHeaderText("Vous ne pouvez pas vendre plus de nourriture que ce que vous possédez !");
            alert.setContentText("Vous essayez de vendre " + this.CBNourriture.getValue() + " unité(s) de nourriture alors que vous n'en possédez que "+ g.getJCourant().getMatieresPremieresPossedees().get(MatierePremiere.Nourriture) + " ! Diminuez un peu la quantité pour voir !");
            alert.show();
        }
        else {
            g.getJCourant().getMatieresPremieresPossedees().replace(MatierePremiere.Nourriture, g.getJCourant().getMatieresPremieresPossedees().get(MatierePremiere.Nourriture)-this.CBNourriture.getValue());
            g.getJCourant().addArgent(this.CBNourriture.getValue() * ValeursDesChoses.getpVenteNourriture());
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Vente effectuée !");
            alert.setHeaderText("Vous avez vendu pour " + this.CBNourriture.getValue() * ValeursDesChoses.getpVenteNourriture() + " $ de nourriture !");
            alert.setContentText("Vous avez vendu " + this.CBNourriture.getValue() + " unités de nourriture, il vous en reste " + g.getJCourant().getMatieresPremieresPossedees().get(MatierePremiere.Nourriture));
            alert.show();
            this.updateQte();
            this.CBNourriture.getValueFactory().setValue(0);
            g.refreshAffichage();
        }
    }

    @FXML
    private void VenteAcier(ActionEvent event) {
        if(this.CBAcier.getValue() > g.getJCourant().getProduitsPossedees().get(Produit.Acier)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Impossible de vendre !");
            alert.setHeaderText("Vous ne pouvez pas vendre plus de acier que ce que vous possédez !");
            alert.setContentText("Vous essayez de vendre " + this.CBAcier.getValue() + " unité(s) de acier alors que vous n'en possédez que "+ g.getJCourant().getProduitsPossedees().get(Produit.Acier) + " ! Diminuez un peu la quantité pour voir !");
            alert.show();
        }
        else {
            g.getJCourant().getProduitsPossedees().replace(Produit.Acier, g.getJCourant().getProduitsPossedees().get(Produit.Acier)-this.CBAcier.getValue());
            g.getJCourant().addArgent(this.CBAcier.getValue() * ValeursDesChoses.getpVenteAcier());
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Vente effectuée !");
            alert.setHeaderText("Vous avez vendu pour " + this.CBAcier.getValue() * ValeursDesChoses.getpVenteAcier() + " $ de acier !");
            alert.setContentText("Vous avez vendu " + this.CBAcier.getValue() + " unités de acier, il vous en reste " + g.getJCourant().getProduitsPossedees().get(Produit.Acier));
            alert.show();
            this.updateQte();
            this.CBAcier.getValueFactory().setValue(0);
            g.refreshAffichage();
        }
    }

    @FXML
    private void VenteCagettes(ActionEvent event) {
        if(this.CBCagettes.getValue() > g.getJCourant().getProduitsPossedees().get(Produit.Cagettes)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Impossible de vendre !");
            alert.setHeaderText("Vous ne pouvez pas vendre plus de cagettes que ce que vous possédez !");
            alert.setContentText("Vous essayez de vendre " + this.CBCagettes.getValue() + " unité(s) de cagettes alors que vous n'en possédez que "+ g.getJCourant().getProduitsPossedees().get(Produit.Cagettes) + " ! Diminuez un peu la quantité pour voir !");
            alert.show();
        }
        else {
            g.getJCourant().getProduitsPossedees().replace(Produit.Cagettes, g.getJCourant().getProduitsPossedees().get(Produit.Cagettes)-this.CBCagettes.getValue());
            g.getJCourant().addArgent(this.CBCagettes.getValue() * ValeursDesChoses.getpVenteCagettes());
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Vente effectuée !");
            alert.setHeaderText("Vous avez vendu pour " + this.CBCagettes.getValue() * ValeursDesChoses.getpVenteCagettes() + " $ de cagettes !");
            alert.setContentText("Vous avez vendu " + this.CBCagettes.getValue() + " unités de cagettes, il vous en reste " + g.getJCourant().getProduitsPossedees().get(Produit.Cagettes));
            alert.show();
            this.updateQte();
            this.CBCagettes.getValueFactory().setValue(0);
            g.refreshAffichage();
        }
    }

    @FXML
    private void VenteConserve(ActionEvent event) {
        if(this.CBConserves.getValue() > g.getJCourant().getProduitsPossedees().get(Produit.Conserves)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Impossible de vendre !");
            alert.setHeaderText("Vous ne pouvez pas vendre plus de conserves que ce que vous possédez !");
            alert.setContentText("Vous essayez de vendre " + this.CBConserves.getValue() + " unité(s) de conserves alors que vous n'en possédez que "+ g.getJCourant().getProduitsPossedees().get(Produit.Conserves) + " ! Diminuez un peu la quantité pour voir !");
            alert.show();
        }
        else {
            g.getJCourant().getProduitsPossedees().replace(Produit.Conserves, g.getJCourant().getProduitsPossedees().get(Produit.Conserves)-this.CBConserves.getValue());
            g.getJCourant().addArgent(this.CBConserves.getValue() * ValeursDesChoses.getpVenteConserves());
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Vente effectuée !");
            alert.setHeaderText("Vous avez vendu pour " + this.CBConserves.getValue() * ValeursDesChoses.getpVenteConserves() + " $ de conserves !");
            alert.setContentText("Vous avez vendu " + this.CBConserves.getValue() + " unités de conserves, il vous en reste " + g.getJCourant().getProduitsPossedees().get(Produit.Conserves));
            alert.show();
            this.updateQte();
            this.CBConserves.getValueFactory().setValue(0);
            g.refreshAffichage();
        }
    }

    @FXML
    private void VenteMedicaments(ActionEvent event) {
        if(this.CBMedicaments.getValue() > g.getJCourant().getProduitsPossedees().get(Produit.Medicaments)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Impossible de vendre !");
            alert.setHeaderText("Vous ne pouvez pas vendre plus de medicaments que ce que vous possédez !");
            alert.setContentText("Vous essayez de vendre " + this.CBMedicaments.getValue() + " unité(s) de medicaments alors que vous n'en possédez que "+ g.getJCourant().getProduitsPossedees().get(Produit.Medicaments) + " ! Diminuez un peu la quantité pour voir !");
            alert.show();
        }
        else {
            g.getJCourant().getProduitsPossedees().replace(Produit.Medicaments, g.getJCourant().getProduitsPossedees().get(Produit.Medicaments)-this.CBMedicaments.getValue());
            g.getJCourant().addArgent(this.CBMedicaments.getValue() * ValeursDesChoses.getpVenteMedicaments());
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Vente effectuée !");
            alert.setHeaderText("Vous avez vendu pour " + this.CBMedicaments.getValue() * ValeursDesChoses.getpVenteMedicaments() + " $ de medicaments !");
            alert.setContentText("Vous avez vendu " + this.CBMedicaments.getValue() + " unités de medicaments, il vous en reste " + g.getJCourant().getProduitsPossedees().get(Produit.Medicaments));
            alert.show();
            this.updateQte();
            this.CBMedicaments.getValueFactory().setValue(0);
            g.refreshAffichage();
        }
    }

    @FXML
    private void VenteMeubles(ActionEvent event) {
        if(this.CBMeubles.getValue() > g.getJCourant().getProduitsPossedees().get(Produit.Meubles)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Impossible de vendre !");
            alert.setHeaderText("Vous ne pouvez pas vendre plus de meubles que ce que vous possédez !");
            alert.setContentText("Vous essayez de vendre " + this.CBMeubles.getValue() + " unité(s) de meubles alors que vous n'en possédez que "+ g.getJCourant().getProduitsPossedees().get(Produit.Meubles) + " ! Diminuez un peu la quantité pour voir !");
            alert.show();
        }
        else {
            g.getJCourant().getProduitsPossedees().replace(Produit.Meubles, g.getJCourant().getProduitsPossedees().get(Produit.Meubles)-this.CBMeubles.getValue());
            g.getJCourant().addArgent(this.CBMeubles.getValue() * ValeursDesChoses.getpVenteMeubles());
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Vente effectuée !");
            alert.setHeaderText("Vous avez vendu pour " + this.CBMeubles.getValue() * ValeursDesChoses.getpVenteMeubles() + " $ de meubles !");
            alert.setContentText("Vous avez vendu " + this.CBMeubles.getValue() + " unités de meubles, il vous en reste " + g.getJCourant().getProduitsPossedees().get(Produit.Meubles));
            alert.show();
            this.updateQte();
            this.CBMeubles.getValueFactory().setValue(0);
            g.refreshAffichage();
        }
    }

    @FXML
    private void VentePC(ActionEvent event) {
        if(this.CBPC.getValue() > g.getJCourant().getProduitsPossedees().get(Produit.PC)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Impossible de vendre !");
            alert.setHeaderText("Vous ne pouvez pas vendre plus de PC que ce que vous possédez !");
            alert.setContentText("Vous essayez de vendre " + this.CBPC.getValue() + " unité(s) de PC alors que vous n'en possédez que "+ g.getJCourant().getProduitsPossedees().get(Produit.PC) + " ! Diminuez un peu la quantité pour voir !");
            alert.show();
        }
        else {
            g.getJCourant().getProduitsPossedees().replace(Produit.PC, g.getJCourant().getProduitsPossedees().get(Produit.PC)-this.CBPC.getValue());
            g.getJCourant().addArgent(this.CBPC.getValue() * ValeursDesChoses.getpVentePC());
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Vente effectuée !");
            alert.setHeaderText("Vous avez vendu pour " + this.CBPC.getValue() * ValeursDesChoses.getpVentePC() + " $ de PC !");
            alert.setContentText("Vous avez vendu " + this.CBPC.getValue() + " unités de PC, il vous en reste " + g.getJCourant().getProduitsPossedees().get(Produit.PC));
            alert.show();
            this.updateQte();
            this.CBPC.getValueFactory().setValue(0);
            g.refreshAffichage();
        }
    }

    public static Game getG() {
        return g;
    }

    public static void setG(Game g) {
        EcranVenteController.g = g;
    }

    private void updateQte() {
                this.lQteBois.setText(String.valueOf(g.getJCourant().getMatieresPremieresPossedees().get(MatierePremiere.Bois)));
        this.lQteCereales.setText(String.valueOf(g.getJCourant().getMatieresPremieresPossedees().get(MatierePremiere.Cereales)));
        this.lQteMetal.setText(String.valueOf(g.getJCourant().getMatieresPremieresPossedees().get(MatierePremiere.Metal)));
        this.lQteNourriture.setText(String.valueOf(g.getJCourant().getMatieresPremieresPossedees().get(MatierePremiere.Nourriture)));
        
        this.lQteAcier.setText(String.valueOf(g.getJCourant().getProduitsPossedees().get(Produit.Acier)));
        this.lQteCagettes.setText(String.valueOf(g.getJCourant().getProduitsPossedees().get(Produit.Acier)));
        this.lQteMedicaments.setText(String.valueOf(g.getJCourant().getProduitsPossedees().get(Produit.Acier)));
        this.lQtePC.setText(String.valueOf(g.getJCourant().getProduitsPossedees().get(Produit.PC)));
        this.lQteConserves.setText(String.valueOf(g.getJCourant().getProduitsPossedees().get(Produit.Conserves)));
        this.lQteMeubles.setText(String.valueOf(g.getJCourant().getProduitsPossedees().get(Produit.Meubles)));
    }

    
    
}
