/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capitalism.Controlleurs;

import capitalism.Game;
import capitalism.Metier.Parties.Partie;
import capitalism.Metier.Parties.Carte.Coordonnee;
import capitalism.Metier.Parties.MatierePremiere;
import capitalism.Metier.Parties.Produit;
import javafx.scene.layout.AnchorPane;
import capitalism.IHM.Windows.EcranDeChargementDeLaPartieController;
/**
 *
 * @author Damien
 */
public class Controlleur_Jeu {

    //private ? vue
    private Game model;
    private EcranDeChargementDeLaPartieController vue;
    
//---------- CONSTRUCTEURS -----------------------------------------------------

    public Controlleur_Jeu(Game _model, EcranDeChargementDeLaPartieController _vue){
        //Initialisation
        this.model =_model;
        this.vue = _vue;
        
        //lie le controlleur au modele
        this.model.setControlleur(this);
    }

//------------------------------------------------------------------------------

    public void ConstruireUsineProduit(Produit prod, String nom, Coordonnee cord){
        this.model.getP().ConstruireUsineProduit(prod,nom,cord);
    }
    
    public void ConstruireUsineRessource(MatierePremiere prod, String nom, Coordonnee cord){
        this.model.getP().ConstruireUsineRessource(prod,nom,cord);
    }
    
}
