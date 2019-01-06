package capitalism.Controlleurs;

import capitalism.IHM.Cases.CaseIHM;
import capitalism.Metier.Parties.Carte.Cases.Case;
import capitalism.Metier.Parties.Carte.Cases.CaseEmplacement;
import capitalism.Metier.Parties.Usines.Usine;

/**
 *
 * @author Damien
 */
public class Controlleur_Case {
    
    Case modele;
    CaseIHM view;

//---------- CONSTRUCTEURS -----------------------------------------------------

    public Controlleur_Case(CaseIHM _view, Case _modele){
        this.modele = _modele;
        this.view = _view;
    }

    public Controlleur_Case(Case c, CaseIHM aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------

    public Case getModele() {
        return modele;
    }

    public void setModele(Case modele) {
        this.modele = modele;
    }

    public CaseIHM getView() {
        return view;
    }

    public void setView(CaseIHM view) {
        this.view = view;
    }

//------------------------------------------------------------------------------

    public void construireUsine(Usine u){
        CaseEmplacement aled = (CaseEmplacement) this.modele;
        if(!aled.estOccupe()){
            aled.construireUsine(u);
        }
    }
    
}
