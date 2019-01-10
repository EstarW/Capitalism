/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM.Cases;

import capitalism.Capitalism;
import capitalism.Metier.Parties.Carte.Cases.Case;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Azelat
 */
public class CaseEauIHM extends CaseIHM {

    private final Image img;
    private final ImageView imgv;
    
    public CaseEauIHM(Case c) throws FileNotFoundException {
        super(c);
        Rectangle rec = new Rectangle(50,50,Color.CYAN);
        rec.setStroke(Color.rgb(0,0,0, 0.5));
        rec.setStrokeWidth(1);
        rec.setX(this.getX()*50);
        rec.setY(this.getY()*50);
        //FileInputStream inputstream = new FileInputStream(); 
        
        img = new Image(Capitalism.class.getResourceAsStream("Resources/Sprites/Mer1.png"));
        imgv = new ImageView(img);
        imgv.setX(this.getX()*50);
        imgv.setY(this.getY()*50);
        this.getChildren().add(rec);
        this.getChildren().add(imgv);
    }
    
}
