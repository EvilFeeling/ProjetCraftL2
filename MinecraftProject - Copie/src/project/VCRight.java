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
	Button BRecette = new Button("Recette");
	Button BArborescence = new Button("Arborescence");
	public VCRight(){
		
		Class<?> clazz = this.getClass();
        InputStream input = clazz.getResourceAsStream("/images/axe.png");
        ImageView img = new ImageView(new Image(input));
     // Position
        
        // Taille de l'item
        img.setFitHeight(34); 
        img.setFitWidth(34); 
        
		this.setStyle("-fx-background-color:purple;");
		this.setPrefSize(48 * 4, 48 * 5);
		//this.setAlignment(Pos.CENTER);
		
		// Zone où placer l'item pour demander sa recette.
		Pane itemRec = new Pane();
		// Pour mettre une taille précise
		itemRec.setMinSize(50, 50);
		itemRec.setMaxSize(50, 50);
		itemRec.setStyle("-fx-background-color:#999;");
		// Zone où placer l'item pour demander son arborescence.
		Pane itemArb = new Pane();
		// Pour mettre une taille précise
		itemArb.setMinSize(50, 50);
		itemArb.setMaxSize(50, 50);
		itemArb.setStyle("-fx-background-color:#999;");
		itemRec.getChildren().add(img);
		this.setPadding(new Insets(10, 10, 10, 10));
		this.add(BRecette,2,1);
		this.add(itemRec,2,2);
		this.add(BArborescence,2,3);
		this.add(itemArb,2,5);
		
	}
	
}
