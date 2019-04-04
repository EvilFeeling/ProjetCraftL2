package project;

import java.io.InputStream;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.Node;

public class VCTable extends Pane {
	
	GridPane grid =new GridPane();

  

	
	
	public VCTable() {
		//  Mise en place des cases des objts
		grid.setPadding(new Insets(10, 10, 10, 10));

		this.getChildren().add(grid);
			
	}
	
	
	
	
}
