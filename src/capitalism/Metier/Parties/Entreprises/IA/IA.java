/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Entreprises.IA;

import capitalism.Metier.Parties.Contrats.Contrat;
import capitalism.Metier.Parties.Contrats.TypeContrat;
import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Metier.Parties.Usines.Enum.MatierePremiere;
import capitalism.Metier.Parties.Partie;
import capitalism.Metier.Parties.Usines.UsineMatierePremiere;
import capitalism.Metier.Parties.ValeursDesChoses;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Beelzed
 */
public class IA extends Entreprise{
    
    public IA(String nom, Partie partie) {
        super(nom, partie);
        
    }
    
    
    public void joue(){
        boolean continuer = true;
        int i = 0;
        ArrayList<Contrat> cc = new ArrayList();
        ArrayList<Contrat> ccc = new ArrayList();
        for(Contrat c : this.listeContratAttente){
            if(c.getTypeContrat() == TypeContrat.VenteProduit){
                cc.add(c);
            }
            else {
                Random r = new Random();
                int x = r.nextInt(2);
                if (x == 1){
                    ccc.add(c);
                }
                else {
                    cc.add(c);
                }
            }
        }
        
        for(Contrat c : cc){
            c.refuser();
        }
        
        for(Contrat c : ccc){
            c.accepter();
        }
        while(continuer){
            Random rr = new Random();
            int xy = rr.nextInt(this.partie.getMap().getListeCasesE().size());     
            if(i > 15){
                continuer = false;
            }
            else if (!this.partie.getMap().getListeCasesE().get(xy).estOccupe()){
                if(this.argent>=ValeursDesChoses.getCoutUsine()){
                    int x = rr.nextInt(4);
                    MatierePremiere m;
                    switch(x){
                        case 0 :
                            m = MatierePremiere.Bois;
                            break;
                        case 1 :
                            m= MatierePremiere.Cereales;
                            break;
                        case 2 :
                            m = MatierePremiere.Metal;
                            break;
                        case 3 : 
                            m = MatierePremiere.Nourriture;
                            break;
                        default : m = MatierePremiere.Bois;
                    }
                    
                    this.partie.getMap().getListeCasesE().get(xy).construireUsine(new UsineMatierePremiere("Usine_"+this.getNom()+this.listeUsines.size(),this,this.partie.getMap().getListeCasesE().get(xy),m));
                }
                continuer = false;
            }
            else {
                i++;
            }
            
        }
        Random rr = new Random();
        int qte;
            if(this.getMatieresPremieresPossedees().get(MatierePremiere.Bois) >= 10){
                qte = rr.nextInt(11);
                this.getMatieresPremieresPossedees().replace(MatierePremiere.Bois, this.getMatieresPremieresPossedees().get(MatierePremiere.Bois)-qte);
                this.argent += (qte * ValeursDesChoses.getpVenteBois());
            }
            if(this.getMatieresPremieresPossedees().get(MatierePremiere.Metal) >= 10){
                qte = rr.nextInt(11);
                this.getMatieresPremieresPossedees().replace(MatierePremiere.Metal, this.getMatieresPremieresPossedees().get(MatierePremiere.Metal)-qte);
                this.argent += (qte * ValeursDesChoses.getpVenteMetal());
            }
            if(this.getMatieresPremieresPossedees().get(MatierePremiere.Cereales) >= 10){
                qte = rr.nextInt(11);
                this.getMatieresPremieresPossedees().replace(MatierePremiere.Cereales, this.getMatieresPremieresPossedees().get(MatierePremiere.Cereales)-qte);
                this.argent += (qte * ValeursDesChoses.getpVenteCereales());
            }
            if(this.getMatieresPremieresPossedees().get(MatierePremiere.Nourriture) >= 10){
                qte = rr.nextInt(11);
                this.getMatieresPremieresPossedees().replace(MatierePremiere.Nourriture, this.getMatieresPremieresPossedees().get(MatierePremiere.Nourriture)-qte);
                this.argent += (qte * ValeursDesChoses.getpVenteNourriture());
            }
    }
    
}
