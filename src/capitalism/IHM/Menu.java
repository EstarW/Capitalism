/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalism.IHM;

import capitalism.IHM.Interface.Type;
import javafx.scene.Parent;
import javafx.scene.paint.Color;

import javafx.scene.shape.Rectangle;

/**
 *
 * @author Damien
 */
public class Menu extends Parent {

    public Menu() {
        Rectangle rec = new Rectangle(300, 600, Color.rgb(0, 0, 0, 0.8));
        Rectangle rec2 = new Rectangle(100,50, Color.WHITE);
        rec.setX(400);
        rec.setY(400);
        rec2.setX(400);
        rec2.setY(600);
        this.getChildren().add(rec);
        this.getChildren().add(rec2);
    }

	public void afficherLesOptionsDePartie() {
		// TODO - implement Menu.afficherLesOptionsDePartie
		throw new UnsupportedOperationException();
	}

    public void afficherMenu(Type type) {
        this.setVisible(true);
        System.out.println("Afficher Menu "+type);
    }

}