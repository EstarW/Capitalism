/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Cases;

import capitalism.Metier.Parties.Carte.Cases.Case;
import capitalism.Metier.Parties.Carte.Cases.CaseTerre;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Azelat
 */
public class CaseTerreIHM extends CaseIHM{
    
    private final Image img;
    private final ImageView imgv;
    
    public CaseTerreIHM(Case c) throws FileNotFoundException {
        super(c);
        Rectangle rec = new Rectangle(50,50,Color.ANTIQUEWHITE);
        rec.setStroke(Color.rgb(0,0,0, 0.5));
        rec.setStrokeWidth(1);
        rec.setX(this.getX()*50);
        rec.setY(this.getY()*50);
        FileInputStream inputstream = new FileInputStream("..\\Capitalism\\src\\capitalism\\Resources\\Sprites\\Plaine.png"); 
        img = new Image(inputstream); 
        imgv = new ImageView(img);
        imgv.setX(this.getX()*50);
        imgv.setY(this.getY()*50);
        this.getChildren().add(rec);
        this.getChildren().add(imgv);

    }
    
}
