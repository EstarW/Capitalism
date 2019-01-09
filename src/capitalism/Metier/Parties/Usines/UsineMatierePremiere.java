/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Usines;

import capitalism.Metier.Parties.Usines.Enum.TypeUsine;
import capitalism.Metier.Parties.Usines.Enum.MatierePremiere;
import capitalism.Metier.Parties.Carte.Cases.Case;
import capitalism.Metier.Parties.Entreprises.Entreprise;

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

    public void setProduction(MatierePremiere production) {
        this.production = production;
    }
    
//------------------------------------------------------------------------------
    
    @Override
    public String getProdName() {
        return this.production.toString();
    }

    @Override
    public TypeUsine type() {
        return TypeUsine.MatierePremiere;
    }

    @Override
    public void produire() {
        this.proprietaire.getMatieresPremieresPossedees().replace(production, this.proprietaire.getMatieresPremieresPossedees().get(production)+1);
    }
    
}