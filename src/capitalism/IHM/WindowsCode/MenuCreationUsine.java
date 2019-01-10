/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.WindowsCode;

import capitalism.Capitalism;
import capitalism.IHM.Cases.CaseEmplacementIHM;
import capitalism.Controlleurs.ControlleursIHM.CréationUsineController;
import capitalism.Metier.Parties.Carte.Cases.Case;
import capitalism.Metier.Parties.Carte.Cases.CaseEmplacement;
import static capitalism.Metier.Parties.Carte.Cases.TypeCase.CaseEmplacement;
import capitalism.Metier.Parties.Carte.Map;
import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Metier.Parties.Usines.Usine;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Azelat
 */
public class MenuCreationUsine {
    
    private final double ligne;
    private final double colonne;
    private final Stage s2;
    private final Scene menuCreationUsine;
    private final CaseEmplacementIHM c;
    private final CréationUsineController cu;
    private final Entreprise j;
    private final Map m;    
    private ArrayList<capitalism.Metier.Parties.Carte.Cases.Case> listeCases;
    
    public MenuCreationUsine(CaseEmplacementIHM c, Entreprise j, Map m) throws MalformedURLException, IOException, InterruptedException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Capitalism.class.getResource("IHM/Windows/créationUsine.fxml"));
        Parent root = loader.load();
        menuCreationUsine = new Scene(root, 630, 400);
        s2 = new Stage();
        s2.setTitle("Création d'usine");
        s2.setResizable(false);
        s2.setScene(menuCreationUsine);
        s2.show();
        this.m = m;
        this.c = c;
        
        colonne = this.c.getLigne();
        ligne = this.c.getColonne();
        System.out.println(ligne+" "+colonne);
        
        this.j = j;
        cu = new CréationUsineController();
        cu.setEntreprise(j);
        cu.setCaseIHM(c);        
        
    }
}
