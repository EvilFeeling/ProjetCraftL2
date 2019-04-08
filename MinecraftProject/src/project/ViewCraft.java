package project;
import javafx.event.EventHandler;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
public class ViewCraft extends BorderPane {
    Button BMenu = new Button("Menu");
    Button BQuit = new Button("Quitter");
    
    VCIPlayer invPlayer = new VCIPlayer();
    VCTable craftTable = new VCTable();
    Pane Q = new Pane();

    public ViewCraft(ControllerCraft controllerC, Modele mdl) {
    	BMenu.setOnAction(controllerC);
    	BQuit.setOnAction(controllerC);
   	
    	this.setStyle("-fx-background-color:#AAA;");
		
		//Top
		GridPane head = new GridPane();
		head.setStyle("-fx-background-color:orange;");
		head.setPrefHeight(75);
		head.setPadding(new Insets(10, 10, 10, 10));		
		head.add(BMenu,0,1);
		head.add(BQuit,1,1);
		
		
		// Left
		Pane left = new Pane();
		left.setStyle("-fx-background-color:red;");
		left.setPrefSize(300, 200);
		
		GridPane invCrea = new GridPane();
		invCrea.setStyle("-fx-background-color:purple;");
		invCrea.setPrefSize(48 * 4, 48 * 5);
		left.getChildren().add(invCrea);
		//left.setAlignment(invCrea, Pos.CENTER_LEFT);
		
		
		//Bottom
		Pane bottom = new Pane();
		bottom.setStyle("-fx-background-color:blue;");
		bottom.setPrefHeight(180);
		
		
		
		bottom.getChildren().add(invPlayer);
		
		// Center
		Pane center = new Pane();
		center.setStyle("-fx-background-color:#500;");
		center.setPrefSize(350, 250);
		
		
		
		craftTable.setPrefSize(250, 200);
		center.getChildren().add(craftTable);
		
		//Right
		Pane right = new Pane();
		right.setStyle("-fx-background-color:#111;");
		right.setPrefSize(300, 200);
		
		VCRight vcRight = new VCRight();
		right.getChildren().add(vcRight);
		
		this.setTop(head);
		this.setBottom(bottom);
		this.setLeft(left);
		this.setRight(right);
		this.setCenter(center);
    	
    	
 
    }
}