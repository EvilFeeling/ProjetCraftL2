package project;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PaneItem extends Pane{
	int i = 0;
	int j = 0;
	int tc = 48 + 10;
	//String basePan = "-fx-border-color: BLACK;-fx-background-color: #c6c6c6; -fx-effect: dropshadow(gaussian, blue, 1, 1, 1, 1), innershadow(three-pass-box, purple, -1, -1, -1, -1); -fx-font-size:10;";
	String nom; // Si pas d'item alors vide, sinon nom de l'item
	public PaneItem(int x,int y) {
		this.i = y;
		this.j = x;
		//Rectangle r = new Rectangle(tc,tc);
		//this.setStyle(basePan);
		//r.setOpacity(0);
		//this.getChildren().add(r);
	}
}
