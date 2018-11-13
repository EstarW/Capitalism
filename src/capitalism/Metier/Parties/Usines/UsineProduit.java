/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Usines;

import capitalism.Metier.Parties.Carte.Cases.CaseEmplacement;
import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Metier.Parties.Produit;

/**
 *
 * @author Damien
 */
public class UsineProduit extends Usine {

    private Produit production;
//---------- CONSTRUCTEURS -----------------------------------------------------

    /**
     *
     * @param nom
     * @param proprietaire
     */
    public UsineProduit(String nom, Entreprise proprietaire, CaseEmplacement emplacement,Produit production) {
        super(nom, proprietaire, emplacement);
    }

//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------
    
    
    
//------------------------------------------------------------------------------
    
    @Override
    public void produire() {
       this.getProprietaire().ajouterRessources(production, 1);
    }
}