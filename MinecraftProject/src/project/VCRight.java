package project;

import java.io.InputStream;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;



public class VCRight extends GridPane{
	String basePan = "-fx-border-color: WHITE;-fx-background-color: #c6c6c6; -fx-effect: innershadow( three-pass-box, rgba( 0, 0, 0, 0.5 ), 10, 0.2, 1, 1 ); -fx-font-size:10;";
	Button BRecette = new Button("Recette");
	Button BArborescence = new Button("Arborescence");
	public VCRight(ControllerCraft ctrl){
		BRecette.setOnMouseClicked(ctrl);
		
		Class<?> clazz = this.getClass();
        InputStream input = clazz.getResourceAsStream("/images/stick.png");
        ImageView img = new ImageView(new Image(input));
     // Position
        
        // Taille de l'item
        img.setFitHeight(34); 
        img.setFitWidth(34); 
        
		//this.setStyle("-fx-background-color:purple;");
		this.setPrefSize(48 * 4, 48 * 5);
		//this.setAlignment(Pos.CENTER);
		
		// Zone o� placer l'item pour demander sa recette.
		PaneItem itemRec = new PaneItem(0,0);
		// Pour mettre une taille pr�cise
		itemRec.setMinSize(50, 50);
		itemRec.setMaxSize(50, 50);
		itemRec.setStyle(basePan);
		// Zone o� placer l'item pour demander son arborescence.
		PaneItem itemArb = new PaneItem(0,0);
		// Pour mettre une taille pr�cise
		itemArb.setMinSize(50, 50);
		itemArb.setMaxSize(50, 50);
		itemArb.setStyle(basePan);
		itemRec.getChildren().add(img);
		this.setPadding(new Insets(10, 10, 10, 10));
		this.add(BRecette,2,1);
		
		this.add(BArborescence,2,3);
		this.add(itemArb,2,5);
		
	}
	
}
