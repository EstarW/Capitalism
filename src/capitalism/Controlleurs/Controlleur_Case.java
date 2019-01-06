package capitalism.Controlleurs;

import capitalism.IHM.Cases.CaseIHM;
import capitalism.Metier.Parties.Carte.Cases.Case;

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

    public void construireUsine(){
        
    }
    
}
