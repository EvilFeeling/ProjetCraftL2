package project;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;
public class ViewCraft extends Pane {
    Button BInfo = new Button("Help");
    Button search = new Button("Rechercher :");  
	TextField textField1 = new TextField(); 
  		
	
	ViewArbo viewArb ;
    VCIPlayer invPlayer = new VCIPlayer();
    VCInv invCrea = new VCInv();
    VCTable craftTable = new VCTable();
	VCRight vcRight ;
    ViewHelp viewHelp ;


    Pane Q = new Pane();

    public ViewCraft(ControllerCraft controllerC, Modele mdl) {
    	BInfo.setOnAction(controllerC);
    	search.setOnAction(controllerC);
    	vcRight = new VCRight(controllerC);
    	viewArb = new ViewArbo(mdl);
    	viewHelp = new ViewHelp( mdl);
    	textField1.setPrefWidth(80);
    	
    	BInfo.setShape(new Circle(10));
    	BInfo.relocate(950, 15);
    	
    	ImageView Title = new ImageView("images/title.png");
    	Title.relocate(300, 15);
    	Title.setOpacity(0.7);
   	
    	//this.setStyle("-fx-background-color:#AAA;");
    	BackgroundSize bgs = new BackgroundSize(1000,500,false,false,false,false);
    	BackgroundImage bgi = new BackgroundImage(new Image("images/background.png"), null, null, null, bgs);
    	Background bg = new Background(bgi);
    
    	this.setBackground(bg);
//    	this.setStyle("-fx-background-color:#AAA;");
    	
		
    	//Top
		Pane head = new Pane();
		//head.setStyle("-fx-background-color:orange;");
		head.setPrefHeight(75);
		
    	//BInfo.setStyle("-fx-border-width:3px;-fx-effect:dropshadow( three-pass-box, rgba( 0, 0, 0, 0.5 ), 10, 0.2, 1, 1 );");
		head.getChildren().addAll(BInfo,Title);
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
		textField1.setOnKeyReleased(event -> {
			controllerC.majInv(mdl.recherche(textField1.getText()));			
		});
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
		
		
    	System.out.println(this.getChildren());
    	viewArb.setVisible(false);
    	viewHelp.setVisible(false);
		this.getChildren().addAll(head,bottom,right,left,center);
		this.getChildren().addAll(viewArb,viewHelp);

    	
    	
 
    }
}