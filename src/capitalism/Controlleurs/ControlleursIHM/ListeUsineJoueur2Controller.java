/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Controlleurs.ControlleursIHM;

import capitalism.Controlleurs.ControlleursIHM.NecessaireDeSurvie.NecessaireDeSurvieGestion;
import capitalism.IHM.WindowsCode.Game;
import capitalism.Metier.Parties.Entreprises.Entreprise;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Beelzed
 */
public class ListeUsineJoueur2Controller implements Initializable {

    @FXML
    private ComboBox<String> comboBoxEntrep;
    @FXML
    private Pane panel_affichage;
    @FXML
    private Label qteUsinesEntrep;
    @FXML
    private ComboBox<String> comboBox_lUsine;
    @FXML
    private Label label_Prod;
    @FXML
    private TextArea tfComptabilité;
    @FXML
    private Label label_nom;
    @FXML
    private Label label_production;
    @FXML
    private Label labelQteProduction;
    @FXML
    private Label label_necessaireProd;
    @FXML
    private ComboBox<String> comboxBox_usine;
    @FXML
    private Button bouton_dissoudre;

    private static Game ga;
    
    public static void  setGame(Game g){
        ga = g;
        NecessaireDeSurvieGestion.setG(ga);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Game g = NecessaireDeSurvieGestion.getG();
        this.tfComptabilité.setText(g.getJCourant().getBilan());
        for(Entreprise e : g.getControl().getModele().getPartie().getListeEnt()){
            this.comboBoxEntrep.getItems().addAll(e.getNom());
        }
        this.label_nom.setText("");
        this.label_production.setText("");
        this.labelQteProduction.setText("");
        this.label_necessaireProd.setText("");
        for(Usine u : g.getP().getJoueurCourant().getListeUsines()){
            this.comboxBox_usine.getItems().add(u.getNom());
        }
        
        this.panel_affichage.setVisible(false);
    }    

    @FXML
    private void changeNom(ActionEvent event) {
        
        Entreprise e = NecessaireDeSurvieGestion.getG().getControl().getModele().getPartie().getEntrepByName(this.comboBoxEntrep.getSelectionModel().getSelectedItem());
        this.qteUsinesEntrep.setText(String.valueOf(e.getListeUsines().size()));
        this.comboBox_lUsine.getItems().removeAll(comboBox_lUsine.getItems());
        for(Usine u : e.getListeUsines()){
            this.comboBox_lUsine.getItems().addAll(u.getNom());
        }
        this.label_Prod.setText("");
        this.panel_affichage.setVisible(true);
    }

    @FXML
    private void changeProd(ActionEvent event) {
        Entreprise e = NecessaireDeSurvieGestion.getG().getControl().getModele().getPartie().getEntrepByName(this.comboBoxEntrep.getSelectionModel().getSelectedItem());
        if(e.getListeUsines().size()>0){
            Usine u = e.getUsineByName(this.comboBox_lUsine.getSelectionModel().getSelectedItem());
            this.label_Prod.setText(u.getProdName());
        }
        
    }

    @FXML
    private void changerTout(ActionEvent event) {
        Game g = NecessaireDeSurvieGestion.getG();
        if(g.getP().getJoueurCourant().getListeUsines().size()>0){
            Usine u = g.getP().getJoueurCourant().getUsineByName(this.comboxBox_usine.getSelectionModel().getSelectedItem());
             this.label_nom.setText(u.getNom());
        this.label_production.setText(u.getProdName());
        switch(u.type()){
            case Produit:
                UsineProduit up = (UsineProduit) u;

                switch(up.getProduction()){
                case Acier:
                    this.labelQteProduction.setText("1");
                    this.label_necessaireProd.setText("Nécessite 1 unité de métal");
                    break;
                case Cagettes:
                    this.labelQteProduction.setText("2");
                    this.label_necessaireProd.setText("Nécessite 1 unité de bois");
                    break;
                case Meubles:
                    this.labelQteProduction.setText("1");
                    this.label_necessaireProd.setText("Nécessite 2 unités de bois");
                    break;
                case Conserves:
                    this.labelQteProduction.setText("2");
                    this.label_necessaireProd.setText("Nécessite 1 unité de métal et 1 unité de nourriture");
                    break;
                case PC:
                    this.labelQteProduction.setText("1");
                    this.label_necessaireProd.setText("Nécessite 4 unités de métal");
                    break;
                case Medicaments:
                    this.labelQteProduction.setText("1");
                    this.label_necessaireProd.setText("Nécessite 1 unité de céréale");

                    break;
                default:
                    throw new AssertionError(up.getProduction().name());

                    }
                    break;
            case MatierePremiere:
                UsineMatierePremiere ump = (UsineMatierePremiere) u;
                this.labelQteProduction.setText("1");
                break;
            default:
                throw new AssertionError(u.type().name());
            
        }
        }
       
    }

    @FXML
    private void dissoudreUsine(ActionEvent event) {
        Game g = NecessaireDeSurvieGestion.getG();
        
        Usine u = g.getP().getJoueurCourant().getUsineByName(this.comboxBox_usine.getSelectionModel().getSelectedItem());
         u.dissoudre();
        this.comboxBox_usine.getItems().remove(u.getNom());
       
        this.reload();
    }

    private void reload() {        
        Game g = NecessaireDeSurvieGestion.getG();
        this.label_nom.setText("");
        this.label_production.setText("");
        this.labelQteProduction.setText("");
        this.label_necessaireProd.setText("");
        this.comboxBox_usine = new ComboBox();
        for(Usine u : g.getP().getJoueurCourant().getListeUsines()){
            System.out.println(u.getNom());
            this.comboxBox_usine.getItems().add(u.getNom());
        }
    }
    
}
