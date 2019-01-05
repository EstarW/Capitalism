/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Cases;

import capitalism.IHM.WindowsCode.MenuContextuel;
import capitalism.IHM.WindowsCode.MenuCreationUsine;
import capitalism.Metier.Parties.Carte.Cases.Case;
import java.io.FileInputStream;
import java.io.IOException;
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
    
    public CaseEmplacementIHM(Case c) throws IOException {
        super(c);
        rec = new Rectangle(50,50,Color.GREY);
        rec.setStroke(Color.rgb(0,0,0, 0.5));
        rec.setStrokeWidth(1);
        rec.setX(this.getX()*50);
        rec.setY(this.getY()*50);
        this.getChildren().add(rec);
        
        FileInputStream inputstream = new FileInputStream("..\\Capitalism\\src\\capitalism\\Resources\\Sprites\\Neige.png"); 
        img = new Image(inputstream); 
        imgv = new ImageView(img);
        imgv.setX(this.getX()*50);
        imgv.setY(this.getY()*50);
        this.getChildren().add(imgv);
        
        FileInputStream inputstream2 = new FileInputStream("..\\Capitalism\\src\\capitalism\\Resources\\Sprites\\EmplacementUsine.png"); 
        img2 = new Image(inputstream2); 
        imgv2 = new ImageView(img2);
        imgv2.setX(this.getX()*50);
        imgv2.setY(this.getY()*50);
        this.getChildren().add(imgv2);
        
           
                    
        this.setOnMouseEntered((MouseEvent me) -> {
            rec.setFill(Color.rgb(0,0,0,0.8)); 
        });
        
        this.setOnMouseExited((MouseEvent me) -> {
            rec.setFill(Color.GREY);
        });
        
        /*this.setOnMouseClicked((MouseEvent me) -> {
            if(state){
                try {
                    m = new MenuContextuel(this, j, map, this.g);
                } catch (IOException ex) {
                    Logger.getLogger(CaseEmplacementIHM.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                try {
                    m2 = new MenuCreationUsine(this, j, map, this.g);
                } catch (IOException ex) {
                    Logger.getLogger(CaseEmplacementIHM.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CaseEmplacementIHM.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });*/
    }
    
}
