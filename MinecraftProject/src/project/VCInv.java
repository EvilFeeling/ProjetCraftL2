package project;

import java.io.InputStream;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;

// Va génerer la zone d'inventaire du player
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
		this.setPrefSize(1000, 175);
		this.setStyle("-fx-background-color:pink;");

		//Setting the vertical and horizontal gaps between the columns 
		gridPane.setVgap(5); 
		gridPane.setHgap(5);       

		//Setting the Grid alignment 
		gridPane.setAlignment(Pos.TOP_LEFT);

		gridPane.setPadding(new Insets(20, 10, 10, 10));

		
		for (int i = 0; i < ncol; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setMaxWidth(tc);
            gridPane.getColumnConstraints().add(colConst);
        }
		
		//Setting title to the Stage 
		this.setContent(gridPane);


	} 
	
	
	
	
}
