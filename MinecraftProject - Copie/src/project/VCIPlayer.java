package project;

import java.io.InputStream;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
public class VCIPlayer extends ScrollPane{
	int ti = 48;
	int tc = ti + 10;
	int ncol = 15;
	int nlig = 3;
	Item vide = new Item("vide");
	
	ArrayList<ArrayList<Item>> matrice = new ArrayList< ArrayList<Item> > ();

	ArrayList<ArrayList<Pane>> tabP = new ArrayList<ArrayList<Pane>>();
	
	
	public VCIPlayer() {
		this.setPrefSize(1000, 175);
		this.setStyle("-fx-background-color:pink;");
		//creating label rechercher 
		Text text1 = new Text("Rechercher :");   


		//Creating Text Filed for rechercher        
		TextField textField1 = new TextField(); 
		textField1.setPrefWidth(80);

		//Creating a Grid Pane 
		GridPane gridPane =new GridPane();	

		//Setting the vertical and horizontal gaps between the columns 
		gridPane.setVgap(5); 
		gridPane.setHgap(5);       

		//Setting the Grid alignment 
		gridPane.setAlignment(Pos.TOP_LEFT);

		//Arranging all the nodes in the grid 
		String chaine = "-fx-border-color: WHITE;-fx-background-color: rgb(180, 180, 180);-fx-background-radius: 2; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.9), 1, 0, 0, 1); -fx-font-size:10;";


		gridPane.setPadding(new Insets(20, 10, 10, 10));
		GridPane gridpane = new GridPane();
		// Set Les cases vides
		for (int i = 0; i < nlig; i++) {
			ArrayList<Pane> Ligne = new ArrayList<Pane>();
			for (int j = 0; j < ncol; j++) {
				Pane k = new Pane();
				
				k.setStyle(chaine);
				k.setPrefSize(tc,tc);
				k.setMaxSize(tc, tc);
				Ligne.add(k);
				gridPane.add(k, j, i+1, 1, 1);
				
			}
			tabP.add(Ligne);
		}

		for (int i=0;i<matrice.size();i++) {
			for (int j = 0; j < matrice.size(); j++) {
				if (matrice.get(i).get(j) != vide) {
					Item img = matrice.get(i).get(j);
					tabP.get(i).get(j).getChildren().removeAll();
					tabP.get(i).get(j).getChildren().add(img);

				}
			}
		}
		
		gridPane.add(text1, 0, 0 ); 
		gridPane.add(textField1, 1, 0);
		
		for (int i = 0; i < ncol; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setMaxWidth(tc);
            gridPane.getColumnConstraints().add(colConst);
        }
		
		//Setting title to the Stage 
		this.setContent(gridPane);


	} 
	
}
