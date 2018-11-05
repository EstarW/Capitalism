/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Carte.Cases;

import capitalism.Metier.Parties.Carte.Map;

/**
 *
 * @author Damien
 */
public class CaseVille extends Case {

//---------- CONSTRUCTEURS -----------------------------------------------------
    
    public CaseVille(int ligne, int colonne, Map map) {
        super(ligne, colonne, map);
    }

//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------
    
    @Override
    public TypeCase getType() {
        return TypeCase.CaseVille;
    }
    
//------------------------------------------------------------------------------
    
}