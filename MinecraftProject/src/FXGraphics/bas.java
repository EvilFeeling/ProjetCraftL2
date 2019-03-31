package FXGraphics;

import java.io.InputStream;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class bas extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//creating label rechercher 
			Text text1 = new Text("Rechercher");       

			//Creating Text Filed for rechercher        
			TextField textField1 = new TextField(); 
			textField1.setPrefWidth(90);

			//Creating a Grid Pane 
			GridPane gridPane =new GridPane();	
			Scene scene= new Scene(gridPane);
			String[][] matrice = {	{"rock","rock","vide","rock","rock","vide","rock","rock","vide"},	 
					{"stick","stick","vide","rock","rock","vide","rock","rock","vide"}
			};

			Pane[][] tabP = {		{new Pane(),new Pane(),new Pane(),new Pane(),new Pane(),new Pane(),new Pane(),new Pane(),new Pane()},
					{new Pane(),new Pane(),new Pane(),new Pane(),new Pane(),new Pane(),new Pane(),new Pane(),new Pane()}
			};   

			//Setting size for the pane  
			gridPane.setMinSize(300, 100); 

			//Setting the padding  
			gridPane.setPadding(new Insets(10, 10, 10, 10)); 

			//Setting the vertical and horizontal gaps between the columns 
			gridPane.setVgap(5); 
			gridPane.setHgap(5);       

			//Setting the Grid alignment 
			gridPane.setAlignment(Pos.TOP_LEFT); 

			//Arranging all the nodes in the grid 
			String chaine = "-fx-border-color: WHITE;-fx-background-color: rgb(180, 180, 180);-fx-background-radius: 2; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.9), 1, 0, 0, 1); -fx-font-size:10;";

			int tc = 50;
			int ti=tc-15;



			gridPane.setPadding(new Insets(10, 10, 10, 10));
			//System.out.println(tabP[0].length);
			for (int i = 0; i < tabP.length; i++) {
				for (int j = 0; j < tabP[0].length; j++) {
					tabP[i][j].setStyle(chaine);
					tabP[i][j].setPrefSize(tc,tc);
					gridPane.add(tabP[i][j], j+2, i+1, 1, 1);
				}
			}
			gridPane.add(text1, 0, 0, 1, 1); 
			gridPane.add(textField1, 1, 0, 1, 1);

			for (int i=0;i<matrice.length;i++) {
				for (int j = 0; j < matrice.length; j++) {
					if (matrice[i][j] != "vide") {
						String n = matrice[i][j];
						Class<?> clazz = this.getClass();
						InputStream input = clazz.getResourceAsStream("/images/"+n+".png");
						ImageView img = new ImageView(new Image(input));
						img.setFitHeight(ti);
						img.setFitWidth(ti);
						img.setLayoutX(tc/2-ti/2);
						img.setLayoutY(tc/2-ti/2);
						tabP[i][j].getChildren().add(img);
					}
				}
			}

			//Setting title to the Stage 
			primaryStage.setTitle("Craft"); 

			//Adding scene to the stage 
			primaryStage.setScene(scene); 

			//Displaying the contents of the stage 
			primaryStage.show(); 
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
