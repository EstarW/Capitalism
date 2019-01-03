/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.WindowsCode;

import capitalism.IHM.Cases.CaseEmplacementIHM;
import capitalism.Controlleurs.ControlleursIHM.CréationUsineController;
import capitalism.Metier.Parties.Carte.Cases.Case;
import static capitalism.Metier.Parties.Carte.Cases.TypeCase.CaseEmplacement;
import capitalism.Metier.Parties.Carte.Map;
import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Metier.Parties.Usines.Usine;
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
    
    private final double ligne;
    private final double colonne;
    private final Stage s2;
    private final Scene menuCreationUsine;
    private final CaseEmplacementIHM c;
    private Case ca;
    private final CréationUsineController cu;
    private final Entreprise j;
    private final Map m;    
    private ArrayList<capitalism.Metier.Parties.Carte.Cases.Case> listeCases;
    private final Game g;
    
    public MenuCreationUsine(CaseEmplacementIHM c, Entreprise j, Map m, Game g) throws MalformedURLException, IOException, InterruptedException{
        FXMLLoader fxmlLoader = new FXMLLoader(new File("src/capitalism/IHM/Windows/créationUsine.fxml").toURI().toURL());
        menuCreationUsine = new Scene(fxmlLoader.load(), 630, 400);
        s2 = new Stage();
        s2.setTitle("Création d'usine");
        s2.setResizable(false);
        s2.setScene(menuCreationUsine);
        s2.show();
        this.m = m;
        this.c = c;
        this.g = g;
        
        colonne = this.c.getLigne();
        ligne = this.c.getColonne();
        System.out.println(ligne+" "+colonne);
        
        this.setCase();
        
        this.j = j;
        cu = new CréationUsineController();
        cu.setEntreprise(j);
        cu.setCase(ca);
        cu.setGame(g);
        cu.setCaseIHM(c);

        
        
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
