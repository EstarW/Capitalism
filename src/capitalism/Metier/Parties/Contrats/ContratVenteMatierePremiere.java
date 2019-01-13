/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Contrats;

import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Metier.Parties.Usines.Enum.MatierePremiere;
import javafx.scene.control.Alert;

/**
 *
 * @author Damien
 */
public class ContratVenteMatierePremiere extends Contrat {

    //private Ressources ressourceSource;
    private int qteSource;
    private MatierePremiere mp;

//---------- CONSTRUCTEURS -----------------------------------------------------

    public ContratVenteMatierePremiere(String nom,int prix, int qteSource, Entreprise entSource, Entreprise entDestinataire, int duree, MatierePremiere mp) {
        super(nom, entSource, entDestinataire, duree,prix);
        this.qteSource = qteSource;
        this.mp = mp;
       
    }
    


//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------
    
    @Override
    public TypeContrat getTypeContrat() {
        return TypeContrat.VenteMatierePremiere;
    }


    public int getQteSource() {
        return qteSource;
    }

    public void setQteSource(int qteSource) {
        this.qteSource = qteSource;
    }

    
//------------------------------------------------------------------------------

    public MatierePremiere getMp() {
        return mp;
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
        else if(this.getEntDestinataire().getMatieresPremieresPossedees().get(this.mp) < this.getQteSource()){
            this.getEntSource().getMatieresPremieresPossedees().replace(this.mp, this.getEntSource().getMatieresPremieresPossedees().get(mp)+ this.getEntDestinataire().getMatieresPremieresPossedees().get(mp));
            this.getEntDestinataire().getMatieresPremieresPossedees().replace(mp,0);
            this.annuler();

            if(this.getEntSource().equals(this.getEntDestinataire().getPartie().getJoueurCourant())){
                Alert alertProd = new Alert(Alert.AlertType.INFORMATION);
                alertProd.setTitle("Contrat résilié ! ");
                alertProd.setHeaderText("Un de vos contrats a été résilié");
                alertProd.setContentText("Votre contrat " + this.getNom() + " a été résilié par l'entreprise "+ this.getEntDestinataire() + ", qui n'a plus assez de ressources pour vous payer  !");
                alertProd.show();
            }
        }
        else {
            this.duree --;
            this.getEntDestinataire().addArgent(this.prix);
            this.getEntSource().addArgent(-this.prix);
            this.getEntDestinataire().getMatieresPremieresPossedees().replace(mp,this.getEntDestinataire().getMatieresPremieresPossedees().get(this.mp)-this.qteSource);
            this.getEntSource().getMatieresPremieresPossedees().replace(mp,this.getEntSource().getMatieresPremieresPossedees().get(this.mp)+this.qteSource);
            if(duree == 0){
                this.annuler();
                Alert alertProd = new Alert(Alert.AlertType.INFORMATION);
                alertProd.setTitle("Contrat terminé ! ");
                alertProd.setHeaderText("Un de vos contrats est terminé");
                alertProd.setContentText("Votre contrat " + this.getNom() + " avec l'entreprise "+ this.getEntDestinataire() + " est terminé !");
                alertProd.show();
            }
        }
    }
    
}