/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Usines;

import capitalism.Metier.Parties.Usines.Enum.TypeUsine;
import capitalism.Metier.Parties.Usines.Enum.Produit;
import capitalism.Metier.Parties.Carte.Cases.Case;
import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Metier.Parties.Usines.Enum.MatierePremiere;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author Damien
 */
public class UsineProduit extends Usine {

    private final Produit production;
//---------- CONSTRUCTEURS -----------------------------------------------------

    public UsineProduit(String nom, Entreprise proprietaire, Case c, Produit production) {
        super(nom, proprietaire, c);
        this.production = production;
    }

//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------

    public Produit getProduction() {
        return production;
    }
    
    @Override
    public String getProdName() {
        return this.production.toString();
    }
//------------------------------------------------------------------------------

    @Override
    public TypeUsine type() {
        return TypeUsine.Produit;
    }

    @Override
    public void produire() {
        //Cestchiant
        switch(production){
            case Acier:
                if(this.proprietaire.getMatieresPremieresPossedees().get(MatierePremiere.Metal)>=1){
                    this.proprietaire.ajouteProduit(Produit.Acier, 1);
                    this.proprietaire.ajouteMatierePremiere(MatierePremiere.Metal, -1);
                }
                else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Impossible de produire !");
                    alert.setHeaderText("Votre usine " + this.nom + " ne peut pas produire de " + this.production);
                    alert.setContentText("Vous avez besoin d'une unité de métal pour produire de l'acier!");
                    alert.show();
                }
                break;
            case PlaqueMetal:
                if(this.proprietaire.getMatieresPremieresPossedees().get(MatierePremiere.Metal)>=2){
                    this.proprietaire.ajouteProduit(Produit.PlaqueMetal, 1);
                    this.proprietaire.ajouteMatierePremiere(MatierePremiere.Metal, -2);
                }
                else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Impossible de produire !");
                    alert.setHeaderText("Votre usine " + this.nom + " ne peut pas produire de " + this.production);
                    alert.setContentText("Vous avez besoin de deux unités de métal pour produire des plaques de métal!");
                    alert.show();
                }
                break;
            case Cagettes:
                if(this.proprietaire.getMatieresPremieresPossedees().get(MatierePremiere.Bois)>=1){
                    this.proprietaire.ajouteProduit(Produit.Cagettes, 2);
                    this.proprietaire.ajouteMatierePremiere(MatierePremiere.Bois, -1);
                }
                else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Impossible de produire !");
                    alert.setHeaderText("Votre usine " + this.nom + " ne peut pas produire de " + this.production);
                    alert.setContentText("Vous avez besoin d'une unité de bois pour produire deux cagettes!");
                    alert.show();
                }
                break;
            case Meubles:
                if(this.proprietaire.getMatieresPremieresPossedees().get(MatierePremiere.Bois)>=2){
                    this.proprietaire.ajouteProduit(Produit.Meubles, 1);
                    this.proprietaire.ajouteMatierePremiere(MatierePremiere.Bois, -2);
                }
                else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Impossible de produire !");
                    alert.setHeaderText("Votre usine " + this.nom + " ne peut pas produire de " + this.production);
                    alert.setContentText("Vous avez besoin de deux unités de bois pour produire un meuble!");
                    alert.show();
                }
                break;
            case Conserves:
                if(this.proprietaire.getMatieresPremieresPossedees().get(MatierePremiere.Metal)>=1 && this.proprietaire.getMatieresPremieresPossedees().get(MatierePremiere.Nourriture)>=1){
                    this.proprietaire.ajouteProduit(Produit.Conserves, 2);
                    this.proprietaire.ajouteMatierePremiere(MatierePremiere.Metal, -1);
                    this.proprietaire.ajouteMatierePremiere(MatierePremiere.Nourriture,-1);
                }
                else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Impossible de produire !");
                    alert.setHeaderText("Votre usine " + this.nom + " ne peut pas produire de " + this.production);
                    alert.setContentText("Vous avez besoin d'une unité de métal et d'une de nourriture pour des conserves !");
                    alert.show();
                }
                break;
            case PC:
                if(this.proprietaire.getMatieresPremieresPossedees().get(MatierePremiere.Metal)>=4){
                    this.proprietaire.ajouteProduit(Produit.PC, 1);
                    this.proprietaire.ajouteMatierePremiere(MatierePremiere.Metal, -4);
                }
                else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Impossible de produire !");
                    alert.setHeaderText("Votre usine " + this.nom + " ne peut pas produire de " + this.production);
                    alert.setContentText("Vous avez besoin de quatre unités de métal     pour produire un ordinateur!");
                    alert.show();
                }
                break;
            case Medicaments:
                 if(this.proprietaire.getMatieresPremieresPossedees().get(MatierePremiere.Cereales)>=1){
                    this.proprietaire.ajouteProduit(Produit.Medicaments, 1);
                    this.proprietaire.ajouteMatierePremiere(MatierePremiere.Cereales, -1);
                }
                else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Impossible de produire !");
                    alert.setHeaderText("Votre usine " + this.nom + " ne peut pas produire de " + this.production);
                    alert.setContentText("Vous avez besoin d'une unité de nourriture pour produire un médicament (bio) !");
                    alert.show();
                }
                break;
            default:
                throw new AssertionError(production.name());
            
        }
    }
    
  
    
}