package project;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class PaneItem extends Pane{
	String basePan = "-fx-border-color: WHITE;-fx-background-color: #c6c6c6; -fx-effect: innershadow( three-pass-box, rgba( 0, 0, 0, 0.5 ), 10, 0.2, 1, 1 ); -fx-font-size:10;";
	int i = 0;
	int j = 0;
	String nom; // Si pas d'item alors vide, sinon nom de l'item
	public String typePan = new String();
	public PaneItem(int x,int y) {
		
		this.i = y;
		this.j = x;
		
	this.setOnMouseClicked(new EventHandler<MouseEvent>(){
		    // Enregistre quel bouton de la souris est enfoncé.
		public void handle(MouseEvent e){
		    MouseButton buttonDown = e.getButton();
		 
		    if (buttonDown == MouseButton.PRIMARY) {
		           // Bouton GAUCHE enfoncé
		    	System.out.println("gauche");
		    } else if(buttonDown == MouseButton.SECONDARY) {
		           // Bouton du MILIEU enfoncé
		    	System.out.println("droite");
		    }
		}
	});
	this.setOnMouseEntered(new EventHandler<MouseEvent>(){
		
        public void handle(MouseEvent me){
        	Pane k = (Pane)me.getTarget();
        	k.setStyle("-fx-background-color: GREY; -fx-font-size:10;");
        }
    });
    this.setOnMouseExited(new EventHandler<MouseEvent>(){
        public void handle(MouseEvent me){
        	Pane k = (Pane)me.getTarget();
        	k.setStyle(basePan);
        }
    });
}
}
