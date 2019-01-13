package capitalism.Controlleurs;

import capitalism.IHM.Cases.CaseIHM;
import capitalism.Metier.Parties.Carte.Cases.Case;
import capitalism.Metier.Parties.Carte.Cases.CaseEmplacement;
import capitalism.Metier.Parties.Usines.Usine;
import java.io.Serializable;

/**
 *
 * @author Damien
 */
public class Controlleur_Case implements Serializable{
    
    private Case modele;
    private transient CaseIHM view;

//---------- CONSTRUCTEURS -----------------------------------------------------

    public Controlleur_Case(CaseIHM _view, Case _modele){
        this.modele = _modele;
        this.modele.setControlleur(this);
        this.view = _view;
    }

    public Controlleur_Case(Case _modele, CaseIHM _view) {
        this.modele = _modele;
        this.view = _view;
        this.modele.setControlleur(this);

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
