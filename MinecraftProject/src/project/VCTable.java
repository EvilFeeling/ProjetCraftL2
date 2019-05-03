package project;


import javafx.geometry.Insets;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


public class VCTable extends Pane {
	
	GridPane grid =new GridPane();

  

	
	
	public VCTable() {
		//  Mise en place des cases des objts
		grid.setPadding(new Insets(10, 10, 10, 10));

		this.getChildren().add(grid);
		
	}
	
	
	
	
}
