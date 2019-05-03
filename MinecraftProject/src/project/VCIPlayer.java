package project;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;


// Va génerer la zone d'inventaire du player
public class VCIPlayer extends ScrollPane{
	int ti = 48;
	int tc = ti + 10;
	int ncol = 15;
	int nlig = 7;
	Item vide = new Item("vide");
	//Creating a Grid Pane 
	GridPane gridPane =new GridPane();	
	

	ArrayList<ArrayList<PaneItem>> tabP = new ArrayList<ArrayList<PaneItem>>();
	
	
	public VCIPlayer() {
		this.setStyle("-fx-background:#333");

		this.setPrefSize(1000, 225);
		BackgroundSize bgs = new BackgroundSize(1000,500,false,false,false,false);
    	BackgroundImage bgi = new BackgroundImage(new Image("images/background.png"), null, null, null, bgs);
    	Background bg = new Background(bgi);
    	this.setBackground(bg);
    
		//this.setStyle("-fx-background:grey;");
		//this.setStyle("-fx-opacity:0.5;");
		//this.setOpacity(0.5);
		//creating label rechercher 


		//Setting the vertical and horizontal gaps between the columns 
		gridPane.setVgap(5); 
		gridPane.setHgap(5);       

		//Setting the Grid alignment 
		gridPane.setAlignment(Pos.BOTTOM_LEFT);

		gridPane.setPadding(new Insets(0, 10, 10, 10));

		for (int i = 0; i < ncol; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setMaxWidth(tc);
            gridPane.getColumnConstraints().add(colConst);
        }
		
		//Setting title to the Stage 
		this.setContent(gridPane);


	} 
	
	
	
	
}
