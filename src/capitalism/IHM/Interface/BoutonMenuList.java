/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Interface;

import static capitalism.IHM.Interface.Type.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Azelat
 */
public class BoutonMenuList extends Parent{
    
    private Bouton[] boutons;
    private Type type;

   
    public BoutonMenuList(){
        
        boutons = new Bouton[]{
            new Bouton(1100, 725, 60, "Menu", MenuJeu),
            new Bouton(50, 750, 40, "Contrat", MenuContrat),
            new Bouton(150, 750, 40, "Gestion", MenuGestion),
            new Bouton(250, 750, 40, "Liste", MenuListe)
        };

        
        for(Bouton bouton: boutons){
            this.getChildren().add(bouton);
        }
        
        boutons[0].setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                type = boutons[0].getType();
                try {
                    boutons[0].afficherMenu(type);
                } catch (IOException ex) {
                    Logger.getLogger(BoutonMenuList.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Ok");
                }
        });
        
        boutons[1].setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                type = boutons[1].getType();
                try {
                    boutons[1].afficherMenu(type);
                } catch (IOException ex) {
                    Logger.getLogger(BoutonMenuList.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Ok");
                }
        });
        
        boutons[2].setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                type = boutons[2].getType();
                try {
                    boutons[2].afficherMenu(type);
                } catch (IOException ex) {
                    Logger.getLogger(BoutonMenuList.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Ok");
                }
        });
        
        boutons[3].setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                type = boutons[3].getType();
                try {
                    boutons[3].afficherMenu(type);
                } catch (IOException ex) {
                    Logger.getLogger(BoutonMenuList.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Ok");
                }
        });
       
        
    }

}