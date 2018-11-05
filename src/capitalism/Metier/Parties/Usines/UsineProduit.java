/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Usines;

import capitalism.Metier.Parties.Entreprises.Entreprise;

/**
 *
 * @author Damien
 */
public class UsineProduit extends Usine {

//---------- CONSTRUCTEURS -----------------------------------------------------

    /**
     *
     * @param nom
     * @param proprietaire
     */
    public UsineProduit(String nom, Entreprise proprietaire) {
        super(nom, proprietaire);
    }

//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------
    
    
    
//------------------------------------------------------------------------------
    
    @Override
    public void produire() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}