/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Contrats;

import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Metier.Parties.Usines.Enum.MatierePremiere;
import capitalism.Metier.Parties.Usines.Enum.Produit;
import javafx.scene.control.Alert;

/**
 *
 * @author Beelzed
 */
public class ContratVenteProduit extends Contrat{

    //private Ressources ressourceSource;
    private int qteSource;
    private Produit p;

    public ContratVenteProduit(String nom,int prix, int qteSource, Produit p, Entreprise entSource, Entreprise entDestinataire, int duree) {
        super(nom, entSource, entDestinataire, duree, prix);
        this.qteSource = qteSource;
        this.p = p;
    }
    
    
    @Override
    public TypeContrat getTypeContrat() {
        return TypeContrat.VenteProduit;
    }

    public int getQteSource() {
        return qteSource;
    }

    public Produit getP() {
        return p;
    }
    
    @Override
    public void effectuer() {
        if(this.getPrix()> this.getEntSource().getArgent()){
            this.getEntDestinataire().addArgent(getEntSource().getArgent());
            this.getEntSource().addArgent(-(getEntSource().getArgent()));
            this.annuler();
            if(!this.getEntSource().equals(this.getEntDestinataire().getPartie().getJoueurCourant())){
                Alert alertProd = new Alert(Alert.AlertType.INFORMATION);
                alertProd.setTitle("Contrat résilié ! ");
                alertProd.setHeaderText("Un de vos contrats a été résilié");
                alertProd.setContentText("Votre contrat " + this.getNom() + " a été résilié par l'entreprise "+ this.getEntDestinataire() + ", qui n'a plus assez d'argent pour vous payer  !");
                alertProd.show();
            }
        }
        if(this.getEntDestinataire().getProduitsPossedees().get(this.p) < this.getQteSource()){
            this.getEntSource().getProduitsPossedees().replace(this.p, this.getEntSource().getProduitsPossedees().get(p)+ this.getEntDestinataire().getProduitsPossedees().get(p));
            this.getEntDestinataire().getProduitsPossedees().replace(p,0);
            this.annuler();

            if(this.getEntSource().equals(this.getEntDestinataire().getPartie().getJoueurCourant())){
                Alert alertProd = new Alert(Alert.AlertType.INFORMATION);
                alertProd.setTitle("Contrat résilié ! ");
                alertProd.setHeaderText("Un de vos contrats a été résilié");
                alertProd.setContentText("Votre contrat " + this.getNom() + " a été résilié par l'entreprise "+ this.getEntDestinataire() + ", qui n'a plus assez de ressources pour vous payer  !");
                alertProd.show();
            }
        }
    }
}
