/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Controlleurs.ControlleursIHM;

import capitalism.Controlleurs.ControlleursIHM.NecessaireDeSurvie.NecessaireDeSurvieCreationUsineController;
import capitalism.Controlleurs.Controlleur_Jeu;
import capitalism.IHM.WindowsCode.Game;
import capitalism.IHM.Cases.CaseEmplacementIHM;
import capitalism.Metier.Parties.Carte.Cases.Case;
import capitalism.Metier.Parties.Carte.Cases.CaseEmplacement;
import capitalism.Metier.Parties.Carte.Coordonnee;
import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Metier.Parties.Entreprises.Joueur;
import capitalism.Metier.Parties.MatierePremiere;
import capitalism.Metier.Parties.Produit;
import capitalism.Metier.Parties.Usines.Usine;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private Controlleur_Jeu cu;
    private Case c;
    private boolean check;
    private Entreprise e;
    private Joueur j;
    private Game g;
    private CaseEmplacement c2;
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
        this.c2 = (CaseEmplacement) c;
        NecessaireDeSurvieCreationUsineController.setCasee(c);
    }
    
    public Case getCase()
    {
        return c;
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
    
    public void setGame(Game g)
    {
        this.g = g;
        NecessaireDeSurvieCreationUsineController.setGame(g);
    }
    
    public Game getGame()
    {
        return g;
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
        
        Game game = NecessaireDeSurvieCreationUsineController.getGame();
        Case c2 =  NecessaireDeSurvieCreationUsineController.getCaseEmp();
        CaseEmplacementIHM cIHM2 =  NecessaireDeSurvieCreationUsineController.getCaseIHM();
        
        if(!this.textField_nom.getCharacters().toString().isEmpty())
        {
            if(this.matiereCheck() && !this.produitCheck())
            {
                //Creation de l'usine ressource
                game.getP().ConstruireUsineRessource(this.getMat(), this.getName(), new Coordonnee(c2.getLigne(),c2.getColonne()));
                
            }
            else if(this.produitCheck() && !this.matiereCheck())
            {
                //Creation de l'usine produit
                game.getP().ConstruireUsineProduit(this.getProd(), this.getName(), new Coordonnee(c2.getLigne(),c2.getColonne()));
            }
            System.out.println("Coord : Ligne : " + c2.getLigne() + " Colonne : " + c2.getColonne());
            Stage stage = (Stage) textField_nom.getScene().getWindow();
            cIHM2.setState(true);
            
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
