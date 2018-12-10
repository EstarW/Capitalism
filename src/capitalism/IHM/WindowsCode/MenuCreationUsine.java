/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.WindowsCode;

import capitalism.Controlleurs.Controlleur_Usines;
import capitalism.IHM.Cases.CaseIHM;
import capitalism.IHM.Cases.CaseEmplacementIHM;
import capitalism.IHM.Windows.CréationUsineController;
import capitalism.Metier.Parties.Carte.Cases.Case;
import capitalism.Metier.Parties.Carte.Cases.CaseEmplacement;
import static capitalism.Metier.Parties.Carte.Cases.TypeCase.CaseEmplacement;
import capitalism.Metier.Parties.Carte.Map;
import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Metier.Parties.Entreprises.Joueur;
import capitalism.Metier.Parties.Usines.Usine;
import capitalism.Metier.Parties.Usines.UsineMatierePremiere;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Azelat
 */
public class MenuCreationUsine {
    
    private double ligne;
    private double colonne;
    private Stage s2;
    private Scene menuCreationUsine;
    private CaseEmplacementIHM c;
    private Case ca;
    private CréationUsineController cu;
    private Usine usine;
    private Controlleur_Usines control;
    private Joueur j;
    private Map m;    
    private ArrayList<capitalism.Metier.Parties.Carte.Cases.Case> listeCases;
    
    public MenuCreationUsine(CaseEmplacementIHM c, Joueur j, Map m) throws MalformedURLException, IOException, InterruptedException{
        FXMLLoader fxmlLoader = new FXMLLoader(new File("src/capitalism/IHM/Windows/créationUsine.fxml").toURI().toURL());
        menuCreationUsine = new Scene(fxmlLoader.load(), 630, 400);
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
        
        this.setCase();
        
        this.j = j;
        cu = new CréationUsineController();
        cu.setJoueur(j);
        cu.setCase(ca);
    }
    
    public void setCase()
    {
        listeCases = m.getListeCases();
        
        for(int i=0; i<listeCases.size(); i++)
        {
            if(listeCases.get(i).getType() == CaseEmplacement)
            {
                double ligne2 = (double) listeCases.get(i).getLigne();
                double colonne2 = (double) listeCases.get(i).getColonne();
                if(ligne == ligne2 && colonne == colonne2)
                {
                    ca = listeCases.get(i);
                    System.out.println(ca.getColonne());
                }
            }
        }
    }
}
