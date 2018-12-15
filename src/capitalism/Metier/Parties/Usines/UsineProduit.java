/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Usines;

import capitalism.Metier.Parties.Carte.Cases.Case;
import capitalism.Metier.Parties.Carte.Cases.CaseEmplacement;
import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Metier.Parties.Produit;

/**
 *
 * @author Damien
 */
public class UsineProduit extends Usine {

    private final Produit production;
//---------- CONSTRUCTEURS -----------------------------------------------------

    /**
     *
     * @param nom
     * @param proprietaire
     * @param production
     */
    public UsineProduit(String nom, Entreprise proprietaire, Case c, Produit production) {
        super(nom, proprietaire, c);
        this.production = production;
    }

//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------
    
    void setEmplacement(CaseEmplacement emplacement){
        emplacement.setUsine(this);
    }

    public Produit getProduction() {
        return production;
    }
    public String getProdName() {
        return this.production.toString();
    }
//------------------------------------------------------------------------------
    
    @Override
    public void produire() {
       this.getProprietaire().ajouterRessources(production, 1);
    }
    
    
}