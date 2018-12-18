/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Usines;

import capitalism.Metier.Parties.Carte.Cases.Case;
import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Metier.Parties.Produit;

/**
 *
 * @author Damien
 */
public class UsineProduit extends Usine {

    private final Produit production;
//---------- CONSTRUCTEURS -----------------------------------------------------

    public UsineProduit(String nom, Entreprise proprietaire, Case c, Produit production) {
        super(nom, proprietaire, c);
        this.production = production;
    }

//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------

    public Produit getProduction() {
        return production;
    }
    
    @Override
    public String getProdName() {
        return this.production.toString();
    }
//------------------------------------------------------------------------------
    
}