package project;
import javafx.event.EventHandler;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.event.ActionEvent;
public class ViewCraft extends Pane {
    Button BInfo = new Button("?");
    Button BQuit = new Button("Quitter");
    Button search = new Button("Rechercher :");  
	TextField textField1 = new TextField(); 
  		
	
    
    VCIPlayer invPlayer = new VCIPlayer();
    VCInv invCrea = new VCInv();
    VCTable craftTable = new VCTable();
	VCRight vcRight ;

    Pane Q = new Pane();

    public ViewCraft(ControllerCraft controllerC, Modele mdl) {
    	BInfo.setOnAction(controllerC);
    	BQuit.setOnAction(controllerC);
    	search.setOnAction(controllerC);
    	vcRight = new VCRight(controllerC);
    	textField1.setPrefWidth(80);
   	
    	//this.setStyle("-fx-background-color:#AAA;");
    	BackgroundSize bgs = new BackgroundSize(1000,500,false,false,false,false);
    	BackgroundImage bgi = new BackgroundImage(new Image("images/background.png"), null, null, null, bgs);
    	Background bg = new Background(bgi);
    
    	this.setBackground(bg);
//    	this.setStyle("-fx-background-color:#AAA;");
    	
		
    	//Top
		BorderPane head = new BorderPane();
		//head.setStyle("-fx-background-color:orange;");
		head.setPrefHeight(75);
		head.setPadding(new Insets(10,10,10,10));
		BInfo.setShape(new Circle(10));
    	//BInfo.setStyle("-fx-border-width:3px;-fx-effect:dropshadow( three-pass-box, rgba( 0, 0, 0, 0.5 ), 10, 0.2, 1, 1 );");
		head.setLeft(BQuit);
		head.setRight(BInfo);
		head.relocate(0, 0);
		
		
		// Left
		Pane left = new Pane();
		//left.setStyle("-fx-background-color:red;");
		left.setMaxSize(300, 50);
		left.relocate(770, 100);
		
		
		//invCrea.setStyle("-fx-background-color:purple;");
		invCrea.setPrefSize(230, invCrea.ti * 5);
		left.getChildren().add(invCrea);
		//left.setAlignment(invCrea, Pos.CENTER_LEFT);
		
		
		//Bottom
		Pane bottom = new Pane();
		//bottom.setStyle("-fx-background-color:#DDD;");
		bottom.setPrefHeight(250);
		bottom.relocate(0,400);
		
		
		
		bottom.getChildren().add(search);
		textField1.setLayoutX(90);
		invPlayer.setLayoutY(30);
		bottom.getChildren().add(textField1);
		bottom.getChildren().add(invPlayer);
		
		
		// Center
		Pane center = new Pane();
		//center.setStyle("-fx-background-color:#500;");
		center.setPrefSize(350, 250);
		center.relocate(325, 100);
		
		
		
		craftTable.setPrefSize(250, 200);
		center.getChildren().add(craftTable);
		
		//Right
		Pane right = new Pane();
		//right.setStyle("-fx-background-color:#111;");
		right.setPrefSize(200, 200);
		
		right.getChildren().add(vcRight);
		right.relocate(50, 100);
		
		this.getChildren().addAll(head,bottom,right,left,center);

    	
    	
 
    }
}