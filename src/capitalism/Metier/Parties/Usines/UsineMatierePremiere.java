/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Usines;

import capitalism.Metier.Parties.Carte.Cases.Case;
import capitalism.Metier.Parties.Carte.Cases.CaseEmplacement;
import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Metier.Parties.MatierePremiere;

/**
 *
 * @author Damien
 */
public class UsineMatierePremiere extends Usine {

    private MatierePremiere production;
//---------- CONSTRUCTEURS -----------------------------------------------------
    
    public UsineMatierePremiere(String nom, Entreprise proprietaire, Case emplacement, MatierePremiere production) {
        super(nom, proprietaire, emplacement);
        this.production = production;
    }

//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------

    public MatierePremiere getProduction() {
        return production;
    }
    
    
    
//------------------------------------------------------------------------------
    
    @Override
    public void produire() {
       this.getProprietaire().ajouterRessources(production, 1);
    }
}