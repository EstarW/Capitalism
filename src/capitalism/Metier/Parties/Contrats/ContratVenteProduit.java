/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Contrats;

import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Metier.Parties.Usines.Enum.MatierePremiere;
import capitalism.Metier.Parties.Usines.Enum.Produit;

/**
 *
 * @author Beelzed
 */
public class ContratVenteProduit extends Contrat{

    private int prix;
    //private Ressources ressourceSource;
    private int qteSource;
    private Produit p;

    public ContratVenteProduit(int prix, int qteSource, Produit p, Entreprise entSource, Entreprise entDestinataire, int duree) {
        super(entSource, entDestinataire, duree);
        this.prix = prix;
        this.qteSource = qteSource;
        this.p = p;
    }
    
    
    @Override
    public TypeContrat getTypeContrat() {
        return TypeContrat.VenteProduit;
    }
    
}
