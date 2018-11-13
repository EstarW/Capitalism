/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Contrats;

import capitalism.Metier.Parties.Entreprises.Entreprise;

/**
 *
 * @author Damien
 */
public class ContratEchange extends Contrat{
    
    //private Ressources ressourceSource;
    private int qteSource;
    //private Ressources ressourceDest;
    private int qteDest;

//---------- CONSTRUCTEURS -----------------------------------------------------
    
    public ContratEchange(Entreprise entSource, Entreprise entDestinataire, int duree, int qteDest) {
        super(entSource, entDestinataire, duree);
        this.qteDest=qteDest;
        this.qteSource=qteSource;
        //this.ressourceDest=ressourceDest;
        //this.ressourceSource=ressourceSource;
    }
    
//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------
    
    @Override
    public TypeContrat getTypeContrat() {
        return TypeContrat.Echange;
    }

    public int getQteSource() {
        return qteSource;
    }

    public void setQteSource(int qteSource) {
        this.qteSource = qteSource;
    }

    public int getQteDest() {
        return qteDest;
    }

    public void setQteDest(int qteDest) {
        this.qteDest = qteDest;
    }
    
//------------------------------------------------------------------------------

}