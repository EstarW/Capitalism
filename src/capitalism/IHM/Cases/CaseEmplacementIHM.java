/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Cases;

import capitalism.Capitalism;
import capitalism.IHM.WindowsCode.MenuContextuel;
import capitalism.IHM.WindowsCode.MenuCreationUsine;
import capitalism.Metier.Parties.Carte.Cases.Case;
import capitalism.Metier.Parties.Carte.Cases.CaseEmplacement;
import capitalism.Metier.Parties.Usines.Enum.MatierePremiere;
import capitalism.Metier.Parties.Usines.Enum.Produit;
import capitalism.Metier.Parties.Usines.UsineMatierePremiere;
import capitalism.Metier.Parties.Usines.UsineProduit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Azelat
 */
public class CaseEmplacementIHM extends CaseIHM {
    
    private MenuContextuel m;
    private MenuCreationUsine m2;
    private Rectangle rec;
    private Image img;
    private ImageView imgv;
    private Image img2;
    private ImageView imgv2;
    private boolean state;
    public CaseEmplacementIHM(Case c) throws IOException {
        super(c);
        CaseEmplacement cEmp = (CaseEmplacement) c;
        if(cEmp.estOccupe()){
            state = true;
        }
        else {
            state = false;
        }
        rec = new Rectangle(50,50,Color.GREY);
        rec.setStroke(Color.rgb(0,0,0, 0.5));
        rec.setStrokeWidth(1);
        rec.setX(this.getX()*50);
        rec.setY(this.getY()*50);
        this.getChildren().add(rec);
        
            img = new Image(Capitalism.class.getResourceAsStream("Resources/Sprites/Neige.png"));
        imgv = new ImageView(img);
        imgv.setX(this.getX()*50);
        imgv.setY(this.getY()*50);
        this.getChildren().add(imgv);
        if(state){
            this.onSetState();
        }
        else {
                img2 = new Image(Capitalism.class.getResourceAsStream("Resources/Sprites/EmplacementUsine.png"));
            imgv2 = new ImageView(img2);
            imgv2.setX(this.getX()*50);
            imgv2.setY(this.getY()*50);
            this.getChildren().add(imgv2);
        }
        
        
           
                    
        this.setOnMouseEntered((MouseEvent me) -> {
            rec.setFill(Color.rgb(0,0,0,0.8)); 
        });
        
        this.setOnMouseExited((MouseEvent me) -> {
            rec.setFill(Color.GREY);
        });
        
        
        
        this.setOnMouseClicked((MouseEvent me) -> {
            
                if(state){
                try {
                    m = new MenuContextuel(this, this.getCc().getModele().getMap().getPartie().getJoueurCourant(), this.getCc().getModele().getMap());
                } catch (IOException ex) {
                    System.out.println("m ioexception");
                }
                }
                else{
                    if(this.getC().getMap().getPartie().getJoueurCourant().getArgent()>=5000){
                        try {
                        m2 = new MenuCreationUsine(this, this.getCc().getModele().getMap().getPartie().getJoueurCourant(), this.getCc().getModele().getMap());
                        } catch (IOException ex) {
                            System.out.println("m2 ioexception");
                        } catch (InterruptedException ex) {
                            System.out.println("m2 interruptedexception");
                        }
                    }
                    else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Impossible de construire");
                        alert.setHeaderText("Impossible de construire, vous n'avez pas assez d'argent ");
                        alert.setContentText("( 5 000 $ nécessaires)");
                        alert.show();
                    }

                    

                }                
            
            

        });
    }
    
    
    public void construireUsineProduit(Produit p, String nom){
        UsineProduit up = new UsineProduit(nom,this.getC().getMap().getPartie().getJoueurCourant(),this.getC(),p);
        this.getCc().construireUsine(up);
    }   
    
    public void construireUsineMatierePremiere(MatierePremiere p, String nom){
        System.out.println("coucou");
        UsineMatierePremiere up = new UsineMatierePremiere(nom,this.getC().getMap().getPartie().getJoueurCourant(),this.getC(),p);
        this.getCc().construireUsine(up);
    }

    public void setState() throws FileNotFoundException {
        this.state= true;
        this.onSetState();
    }
    
    public void onSetState() throws FileNotFoundException{
            img2 = new Image(Capitalism.class.getResourceAsStream("Resources/Sprites/UsineRouge1.png"));
        imgv2 = new ImageView(img2);
        imgv2.setX(this.getX()*50);
        imgv2.setY(this.getY()*50);
        this.getChildren().add(imgv2);
    }
    
    public void dissoudre(){
        this.state = false;
        img2 = new Image(Capitalism.class.getResourceAsStream("Resources/Sprites/EmplacementUsine.png"));
        imgv2 = new ImageView(img2);
        imgv2.setX(this.getX()*50);
        imgv2.setY(this.getY()*50);
        this.getChildren().add(imgv2);
    }
}
