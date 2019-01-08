/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.WindowsCode;

import capitalism.Controlleurs.ControlleursIHM.MenuContextuelInGameController;
import capitalism.IHM.Cases.CaseEmplacementIHM;
import capitalism.Metier.Parties.Carte.Cases.Case;
import capitalism.Metier.Parties.Carte.Cases.CaseEmplacement;
import static capitalism.Metier.Parties.Carte.Cases.TypeCase.CaseEmplacement;
import capitalism.Metier.Parties.Carte.Map;
import capitalism.Metier.Parties.Entreprises.Entreprise;
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
public class MenuContextuel {

    private final Scene menuContextuel;
    private final Stage s1;
    private final CaseEmplacementIHM c;
    private final Entreprise joueur;
    private final Map map;
    private Case ca;
    private final MenuContextuelInGameController cu;
    
    public MenuContextuel(CaseEmplacementIHM c, Entreprise j, Map m) throws IOException, MalformedURLException{
        FXMLLoader fxmlLoader = new FXMLLoader(new File("src/capitalism/IHM/Windows/MenuContextuelInGame.fxml").toURI().toURL());
        menuContextuel = new Scene(fxmlLoader.load(), 630, 400);
        s1 = new Stage();
        s1.setTitle("Capitalism - Visualisation d'usine");
        s1.setResizable(false);
        s1.setScene(menuContextuel);
        s1.show();
        this.c = c;
        this.joueur = j;
        this.map = m;
        cu = new MenuContextuelInGameController();
        cu.setCase(c);
    }
    
   
    
}
