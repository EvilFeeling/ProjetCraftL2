package project;

import javafx.scene.layout.Pane;

public class PaneItem extends Pane{
	int i = 0;
	int j = 0;
	String nom; // Si pas d'item alors vide, sinon nom de l'item
	public PaneItem(int x,int y) {
		this.i = y;
		this.j = x;
		
	}
}
