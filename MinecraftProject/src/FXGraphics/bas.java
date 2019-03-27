package FXGraphics;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class bas extends Application {
	@Override
	public void start(Stage primaryStage) {
		 //creating label rechercher 
	      Text text1 = new Text("Rechercher");       

	      //Creating Text Filed for rechercher        
	      TextField textField1 = new TextField();       
 
	       
	      //Creating Buttons 
	      Button button1 = new Button("1"); 
	      Button button2 = new Button("2");
	      Button button3 = new Button("3"); 
	      Button button4 = new Button("4");
	      Button button5 = new Button("5"); 
	      Button button6 = new Button("6");
	      Button button7 = new Button("7"); 
	      Button button8 = new Button("8");
	      Button button9 = new Button("9"); 
	      Button button10 = new Button("10");
	      
	      //Creating a Grid Pane 
	      GridPane gridPane = new GridPane();    
	      GridPane gridPane1 = new GridPane();    
	      
	      //Setting size for the pane  
	      gridPane.setMinSize(300, 100); 
	      gridPane1.setMinSize(300, 100); 
	      //Setting the padding  
	      gridPane.setPadding(new Insets(10, 10, 10, 10)); 
	      
	      //Setting the vertical and horizontal gaps between the columns 
	      gridPane.setVgap(5); 
	      gridPane.setHgap(5);       
	      
	      //Setting the Grid alignment 
	      gridPane.setAlignment(Pos.TOP_LEFT); 
	      gridPane1.setAlignment(Pos.BOTTOM_LEFT);
	      //Arranging all the nodes in the grid 
	      gridPane.add(text1, 0, 0); 
	      gridPane.add(textField1, 1, 0); 
	      gridPane1.add(button1, 2, 1); 
	      gridPane1.add(button2, 3, 1);
	      gridPane1.add(button3, 4, 1); 
	      gridPane1.add(button4, 5, 1);  
	      gridPane1.add(button5, 6, 1); 
	      gridPane1.add(button6, 2, 2);
	      gridPane1.add(button7, 3, 2); 
	      gridPane1.add(button8, 4, 2);  
	      gridPane1.add(button9, 5, 2); 
	      gridPane1.add(button10, 6, 2);  
	      
	      //Creating a scene object 
	      Scene scene = new Scene(gridPane);  
	      Scene scene1 = new Scene(gridPane1);
	      //Setting title to the Stage 
	      primaryStage.setTitle("Craft"); 
	         
	      //Adding scene to the stage 
	      primaryStage.setScene(scene); 
	      primaryStage.setScene(scene1);
	      //Displaying the contents of the stage 
	      primaryStage.show(); 
	   } 
	
	public static void main(String[] args) {
		launch(args);
	}
}
