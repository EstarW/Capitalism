/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Controlleurs;

import capitalism.IHM.WindowsCode.Game;
import capitalism.Controlleurs.ControlleursIHM.CreationPartieController;
import capitalism.Metier.Parties.Entreprises.Joueur;
import capitalism.Metier.Parties.Partie;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author hedhie
 */
public class Controlleur_CreationPartie {
    private CreationPartieController vue;
    private Partie model;
    private Joueur j;

//---------- CONSTRUCTEURS -----------------------------------------------------

    public Controlleur_CreationPartie(Partie _model, CreationPartieController _vue){
        //Initialisation
        this.model = _model;
        this.vue = _vue;
        
        //lie le controlleur au modele
        //this.model.setControlleur(this);
    }
    
    public Partie getPartie(){
        return model;
    }
    
    public void DonnerJoueur(String _nom){
        j = new Joueur(_nom, model);
    }
    
    public Joueur getJoueur(){
        return j;
    }
}
