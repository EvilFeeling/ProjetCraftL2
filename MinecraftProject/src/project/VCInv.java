package project;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;


// Va g�nerer la zone d'inventaire du player
public class VCInv extends ScrollPane{
	int ti = 48;
	int tc = ti + 10;
	int ncol = 3;
	int nlig = 10;
	Item vide = new Item("vide");
	//Creating a Grid Pane 
	GridPane gridPane =new GridPane();	
	

	ArrayList<ArrayList<PaneItem>> tabP = new ArrayList<ArrayList<PaneItem>>();
	
	
	public VCInv() {
		this.setStyle("-fx-background:#DDD");
		

		//Setting the vertical and horizontal gaps between the columns 
		gridPane.setVgap(5); 
		gridPane.setHgap(5);       
		//Setting the Grid alignment 
		gridPane.setAlignment(Pos.TOP_LEFT);

		gridPane.setPadding(new Insets(10, 0, 10, 10));

		
		for (int i = 0; i < ncol; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setMaxWidth(tc);
            gridPane.getColumnConstraints().add(colConst);
        }
		
		//Setting title to the Stage 
		this.setContent(gridPane);


	} 
	
	
	
	
}
