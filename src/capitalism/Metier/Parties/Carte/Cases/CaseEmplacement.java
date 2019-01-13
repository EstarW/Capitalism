/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Carte.Cases;

import capitalism.IHM.Cases.CaseEmplacementIHM;
import capitalism.Metier.Parties.Carte.Map;
import capitalism.Metier.Parties.Usines.Enum.MatierePremiere;
import capitalism.Metier.Parties.Usines.Usine;
import capitalism.Metier.Parties.ValeursDesChoses;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public void dissoudreUsine(){
        this.usine.getProprietaire().addToBilan(" Dissolution de l'usine " + this.usine.getNom());
        this.usine = null;
        CaseEmplacementIHM c =(CaseEmplacementIHM) this.controlleur.getView();
        c.dissoudre();
    }
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
        this.usine.getProprietaire().retireArgent(ValeursDesChoses.getCoutUsine());
        this.usine.getProprietaire().addToBilan(" Construction de l'usine : " + this.usine.getNom() + "- Production : "+ this.usine.getProdName() + "- Coût : 5 000 $");
        CaseEmplacementIHM cEmp = (CaseEmplacementIHM)this.getControlleur().getView();
        try {
            if(this.usine.getProprietaire().equals(this.getMap().getPartie().getJoueurCourant())){
                cEmp.setState();
            }
            else {
                cEmp.setStateIa();
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CaseEmplacement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}