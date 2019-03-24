package FXGraphics;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Label label1= new Label ("1");
			Label label2= new Label ("2");
			Label label3= new Label ("3");
			Label label4= new Label ("4");
			Label label5= new Label ("5");
			Label label6= new Label ("6");
			Label label7= new Label ("7");
			Label label8= new Label ("8");
			Label label9= new Label ("9");
			Label label10= new Label ("10");
			
			label1.setStyle("-fx-border-color: black; -fx-font-size:40;");
			label2.setStyle("-fx-border-color: black; -fx-font-size:40;");
			label3.setStyle("-fx-border-color: black; -fx-font-size:40;");
			label4.setStyle("-fx-border-color: black; -fx-font-size:40;");
			label5.setStyle("-fx-border-color: black; -fx-font-size:40;");
			label6.setStyle("-fx-border-color: black; -fx-font-size:40;");
			label7.setStyle("-fx-border-color: black; -fx-font-size:40;");
			label8.setStyle("-fx-border-color: black; -fx-font-size:40;");
			label9.setStyle("-fx-border-color: black; -fx-font-size:40;");
			label10.setStyle("-fx-border-color: black; -fx-font-size:40;");
			
			//grid.addColumn(0, label1, label2, label3, label4, label5, label6, label7, label8, label9);
			//grid.setAlignment(Pos.CENTER);
		    grid.setPadding(new Insets(10, 10, 10, 10));
			grid.add(label1, 0, 0, 1, 1);
			grid.add(label4, 0, 1, 1, 1);
			grid.add(label7, 0, 2, 1, 1);
			grid.add(label2, 1, 0, 1, 1);
			grid.add(label5, 1, 1, 1, 1);
			grid.add(label8, 1, 2, 1, 1);
			grid.add(label3, 2, 0, 1, 1);
			grid.add(label6, 2, 1, 1, 1);
			grid.add(label9, 2, 2, 1, 1);
			grid.add(label10, 3, 1, 1, 1);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	GridPane grid =new GridPane();
	Scene scene= new Scene(grid);
	
	public static void main(String[] args) {
		launch(args);
	}
}
