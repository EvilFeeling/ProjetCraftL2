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



public class VCRight extends Pane{
	String basePan = "-fx-border-color: WHITE;-fx-background-color: #c6c6c6; -fx-effect: innershadow( three-pass-box, rgba( 0, 0, 0, 0.5 ), 10, 0.2, 1, 1 ); -fx-font-size:10;";
	Button BRecette = new Button("Recette");
	Button BArborescence = new Button("Arborescence");
	public VCRight(ControllerCraft ctrl){
		BRecette.setOnMouseClicked(ctrl);
		BArborescence.setOnMouseClicked(ctrl);
		
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
		

		this.setPadding(new Insets(10, 10, 10, 10));
		BRecette.relocate(30,0);
		BArborescence.relocate(10,120);
		this.getChildren().addAll(BRecette,BArborescence);


		
	}
	
}
