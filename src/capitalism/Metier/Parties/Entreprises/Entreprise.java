/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Entreprises;

import capitalism.Metier.Parties.Usines.Usine;
import capitalism.Metier.Parties.Contrats.Contrat;
import capitalism.Metier.Parties.Carte.Cases.CaseEmplacement;
import capitalism.Metier.Parties.MatierePremiere;
import capitalism.Metier.Parties.Partie;
import capitalism.Metier.Parties.Produit;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Damien
 * Classe représentant les entreprises du jeu
 */
public abstract class Entreprise {

    private String nom;
    private int argent;
    //private Image logo;
    private Partie partie;
    private HashMap<MatierePremiere,Integer> MatieresPremieres;
    private HashMap<Produit, Integer> Produits;
    // TODO - Rajouter les listes d'usines et de contrats

//---------- CONSTRUCTEURS -----------------------------------------------------
    
    /**
     * 
     * @param nom
     * @param jeu
     */
    public Entreprise(String nom, Partie partie) {
        this.argent=0;
        this.partie=partie;
        this.nom=nom;   
        this.MatieresPremieres = new HashMap();
        for(MatierePremiere m : MatierePremiere.values()){
            this.MatieresPremieres.put(m, 0);
        }
        this.Produits = new HashMap();
        for(Produit m : Produit.values()){
            this.Produits.put(m, 0);
        }
        
        
    }

//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------

    public String getNom() {
        return nom;
    }

    public int getArgent() {
        return argent;
    }

    public Partie getPartie() {
        return partie;
    }

    public HashMap<Produit, Integer> getProduitsPossedees() {
        return this.Produits;
    }
    
    public HashMap<MatierePremiere, Integer> getMatieresPremieresPossedees() {
        return this.MatieresPremieres;
    }
    
    
//------------------------------------------------------------------------------
    
    public void jouerTour(){
        
    }
    
    public void dissoudre() {
        throw new UnsupportedOperationException();
    }

    public void passerTour() {
            // TODO - implement Entreprise.passerTour
            throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param cible
     * @param prixParTour
     * @param ressourceDemandee
     * @param qteDemandee
     */
    /**public void proposerContratVente(Entreprise cible, int prixParTour, Ressources ressourceDemandee, int qteDemandee) {
            // TODO - implement Entreprise.proposerContratVente
            throw new UnsupportedOperationException();
    }**/

    /**
     * 
     * @param cible
     * @param ressourceProposee
     * @param qteProposee
     * @param ressourceDemandee
     * @param qteDesiree
     */
    /**public void proposerContratEchange(Entreprise cible, Ressources ressourceProposee, int qteProposee, Ressources ressourceDemandee, int qteDesiree) {
            // TODO - implement Entreprise.proposerContratEchange
            throw new UnsupportedOperationException();
    }**/

    /**
     * 
     * @param contrat
     */
    public void ajouterContratEnAttente(Contrat contrat) {
            // TODO - implement Entreprise.ajouterContratEnAttente
            throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param contrat
     */
    public void ajouterContratSource(Contrat contrat) {
            // TODO - implement Entreprise.ajouterContratSource
            throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param contrat
     */
    public void ajouterContratDest(Contrat contrat) {
            // TODO - implement Entreprise.ajouterContratDest
            throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param contrat
     */
    public void accepterContratEnAttente(Contrat contrat) {
            // TODO - implement Entreprise.accepterContratEnAttente
            throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param contrat
     */
    public void refuserContratEnAttente(Contrat contrat) {
            // TODO - implement Entreprise.refuserContratEnAttente
            throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param contrat
     */
    public void annulerContrat(Contrat contrat) {
            // TODO - implement Entreprise.annulerContrat
            throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param contrat
     */
    public void supprimerContrat(Contrat contrat) {
            // TODO - implement Entreprise.supprimerContrat
            throw new UnsupportedOperationException();
    }

    public void recupererArgentContrat() {
            // TODO - implement Entreprise.r�cupererArgentContrat
            throw new UnsupportedOperationException();
    }

    public void recupererRessourcesContrat() {
            // TODO - implement Entreprise.r�cupererRessourcesContrat
            throw new UnsupportedOperationException();
    }

    public int afficherArgent() {
            // TODO - implement Entreprise.afficherArgent
            throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param usine
     */
    public void demolirUsine(Usine usine) {
            // TODO - implement Entreprise.demolirUsine
            throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param emplacement
     */
    public void creerUsine(CaseEmplacement emplacement) {
            // TODO - implement Entreprise.creerUsine
            throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param usine
     * @param nouveauProprietaire
     * @param prix
     */
    public void vendreUsine(Usine usine, Entreprise nouveauProprietaire, int prix) {
            // TODO - implement Entreprise.vendreUsine
            throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param usine
     */
    public void nouvelleUsine(Usine usine) {
            // TODO - implement Entreprise.nouvelleUsine
            throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param qteArgent
     */
    public void ajouterAgent(int qteArgent) {
        this.argent+=qteArgent;
    }

    /**
     * 
     * @param qteArgent
     * @param entrepriseCible
     */
    public void donnerArgent(int qteArgent, Entreprise entrepriseCible) {
        if(this.argent>=qteArgent){
            this.perdreArgent(qteArgent);
            entrepriseCible.ajouterAgent(qteArgent);
        }
        else{
            // TODO - afficher une pop up de message d'erreur
            throw new UnsupportedOperationException();
        }
    }

    /**
     * 
     * @param qteArgent
     */
    public void perdreArgent(int qteArgent) {
        this.argent-=qteArgent;
    }

    /**
     * 
     * @param entreprisePartenaire
     */
    public ArrayList<Contrat> getContrats(Entreprise entreprisePartenaire) {
            // TODO - implement Entreprise.getContrats
            throw new UnsupportedOperationException();
    }

    public void payerFrais() {
            // TODO - implement Entreprise.payerFrais
            throw new UnsupportedOperationException();
    }

    public int getArgentDepenseParContrat() {
            // TODO - implement Entreprise.getArgentDepenseParContrat
            throw new UnsupportedOperationException();
    }

    /**
     * 
     * @return 
     */
    /**public HashMap<Ressources,Integer> getRessourcesPerduesParContrat() {
        // TODO - implement Entreprise.getRessourcesPerduesParContrat
        throw new UnsupportedOperationException();
    }**/

    /**
     * 
     * @param ressources
     */
    /**public void supprimerRessources(HashMap<Ressources,Integer> ressources) {
        // TODO - implement Entreprise.supprimerRessources
        throw new UnsupportedOperationException();
    }**/

    /**
     * 
     * @param ressource
     * @param qte
     */
    public void supprimerRessource(Produit ressource, int qte) {
        this.Produits.replace(ressource, this.Produits.get(ressource)-qte);
    }

    public void supprimerRessource(MatierePremiere ressource, int qte) {
        this.MatieresPremieres.replace(ressource, this.MatieresPremieres.get(ressource)-qte);
    }

    /**
     * 
     * @param ressource
     * @param qte
     */
    public void ajouterRessources(Produit ressource, int qte) {
        this.Produits.replace(ressource, this.Produits.get(ressource)+qte);
    }
    
    public void ajouterRessources(MatierePremiere ressource, int qte) {
        this.MatieresPremieres.replace(ressource, this.MatieresPremieres.get(ressource)+qte);
    }    

}