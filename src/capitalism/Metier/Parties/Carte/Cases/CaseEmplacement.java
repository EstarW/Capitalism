/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Carte.Cases;

import capitalism.Metier.Parties.Carte.Map;
import capitalism.Metier.Parties.Usines.Enum.MatierePremiere;
import capitalism.Metier.Parties.Usines.Usine;

/**
 *
 * @author Damien
 */
public class CaseEmplacement extends Case {

    private Usine usine;

//---------- CONSTRUCTEURS -----------------------------------------------------
    
    public CaseEmplacement(int ligne, int colonne, Map map) {
        super(ligne, colonne, map);
        this.usine=null;
    }

//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------
    
    @Override
    public TypeCase getType() {
        return TypeCase.CaseEmplacement;
    }

    public Usine getUsine() {
        return usine;
    }

    public void setUsine(Usine usine) {
        this.usine = usine;
    }
    
//------------------------------------------------------------------------------
    
    /**
     * 
     * @return Vrai si une usine est déjà construite sur cette case et Faux dans le cas contraire
     */
    public boolean estOccupe(){
        return this.getUsine()!=null;
    }
    
    public void construireUsine(Usine u){
        this.usine= u;
        this.usine.setEmplacement(this);
        
    }
}