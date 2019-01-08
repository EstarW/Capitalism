/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.Metier.Parties.Entreprises.IA;

import capitalism.Metier.Parties.Entreprises.Entreprise;
import capitalism.Metier.Parties.MatierePremiere;
import capitalism.Metier.Parties.Partie;
import capitalism.Metier.Parties.Usines.UsineMatierePremiere;

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
        while(continuer){
            if (this.partie.getMap().getListeCasesE().size()>i){
                if (!this.partie.getMap().getListeCasesE().get(i).estOccupe()){
                    this.partie.getMap().getListeCasesE().get(i).construireUsine(new UsineMatierePremiere("Nom",this,this.partie.getMap().getListeCasesE().get(i),MatierePremiere.Bois));
                }
                else {
                    i++;
                }
            }
            else {
                continuer = false;
            }
        }
    }
    
}
