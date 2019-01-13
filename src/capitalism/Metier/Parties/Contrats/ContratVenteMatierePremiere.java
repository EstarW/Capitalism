/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Contrats;

import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Metier.Parties.Usines.Enum.MatierePremiere;

/**
 *
 * @author Damien
 */
public class ContratVenteMatierePremiere extends Contrat {

    private int prix;
    //private Ressources ressourceSource;
    private int qteSource;
    private MatierePremiere mp;

//---------- CONSTRUCTEURS -----------------------------------------------------

    public ContratVenteMatierePremiere(String nom,int prix, int qteSource, Entreprise entSource, Entreprise entDestinataire, int duree, MatierePremiere mp) {
        super(nom, entSource, entDestinataire, duree);
        this.prix = prix;
        this.qteSource = qteSource;
        this.mp = mp;
       
    }
    


//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------
    
    @Override
    public TypeContrat getTypeContrat() {
        return TypeContrat.VenteMatierePremiere;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    public int getQteSource() {
        return qteSource;
    }

    public void setQteSource(int qteSource) {
        this.qteSource = qteSource;
    }

//------------------------------------------------------------------------------
    
}