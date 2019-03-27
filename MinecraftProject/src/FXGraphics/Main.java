package FXGraphics;
	
import java.io.InputStream;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class Main extends Application {
	
	GridPane grid =new GridPane();
	Scene scene= new Scene(grid);
	String[][] matrice = {	{"rock","rock","vide"},	 
							{"stick","stick","vide"}, 	
							{"aze","stick","vide"}
					};
	
	Pane[][] tabP = {		{new Pane(),new Pane(),new Pane()},
							{new Pane(),new Pane(),new Pane()},
							{new Pane(),new Pane(),new Pane()}
					};
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Pane VIDE= new Pane ();
			
			String chaine = "-fx-border-color: WHITE;-fx-background-color: rgb(180, 180, 180);-fx-background-radius: 2; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.9), 1, 0, 0, 1); -fx-font-size:10;";
			

			
			/*Image img = new Image("images/aze.png");
			ImageView view = new ImageView(img);
			view.setFitHeight(40);
			view.setFitWidth(40);
			Pane pane = new Pane();
			pane.setPrefSize(300, 300);
			*/
			int tc = 70;
			int ti=tc-15;
			
			
			
			grid.setPadding(new Insets(10, 10, 10, 10));
			for (int i = 0; i < tabP.length; i++) {
				for (int j = 0; j < tabP.length; j++) {
					tabP[i][j].setStyle(chaine);
					tabP[i][j].setPrefSize(tc,tc);
					grid.add(tabP[i][j], j, i, 1, 1);
				}
			}
			
			VIDE.setStyle("-fx-border-color: white; -fx-font-size:10;");
			VIDE.setPrefSize(tc,tc);
			
			Pane res = new Pane();
			res.setStyle(chaine);
			res.setPrefSize(tc,tc);
			grid.add(res,4 ,1,1,1 );
			grid.add(VIDE, 3, 1, 1, 1);
			
			
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
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
