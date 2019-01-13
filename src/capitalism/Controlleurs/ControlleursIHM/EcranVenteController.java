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
    }

    @FXML
    private void VenteCereales(ActionEvent event) {
    }

    @FXML
    private void VenteMetal(ActionEvent event) {
    }

    @FXML
    private void VenteNourriture(ActionEvent event) {
    }

    @FXML
    private void VenteAcier(ActionEvent event) {
    }

    @FXML
    private void VenteCagettes(ActionEvent event) {
    }

    @FXML
    private void VenteConserve(ActionEvent event) {
    }

    @FXML
    private void VenteMedicaments(ActionEvent event) {
    }

    @FXML
    private void VenteMeubles(ActionEvent event) {
    }

    @FXML
    private void VentePC(ActionEvent event) {
    }

    public static Game getG() {
        return g;
    }

    public static void setG(Game g) {
        EcranVenteController.g = g;
    }

    
    
}
