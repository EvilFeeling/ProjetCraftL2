package project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class ViewHelp extends Pane {
	Modele mdl;
	int ti = 48;
	int tc = ti + 10;
	
	public ViewHelp(Modele modl) {
		this.mdl = modl;
		this.setOnMousePressed(event -> {
			this.setVisible(false);
			
		});
		this.setMaxSize(1000, 650);
		this.setMinSize(1000, 650);
		
		Pane fond = new Pane();
		fond.setMaxSize(1000, 650);
		fond.setMinSize(1000, 650);
		fond.setStyle("-fx-background-color:#000");
		fond.setOpacity(0.5);
		
		ScrollPane center = new ScrollPane();
		
		center.setMinSize(600, 650);
		center.setMaxWidth(610);
		center.setStyle("-fx-background:#DDD");
		
		Text explication = new Text();
		explication.setFont(new Font(20));
		explication.setTextAlignment(TextAlignment.JUSTIFY);
		explication.setText(
				"Bienvenue dans notre programme My Craft Simulator,\n"
				+ "ici tu peux essayer le système de craft comme dans le jeu original\n"
				+ "Minecraft grâce à l'interface centrale, apprendre la recette d'un\n"
				+ "objet si tu ne la connais pas encore ou encore voir l'arborescence\n"
				+ "d'un objet (Qu'est ce que tu peux faire avec l'objet en question).\n\n"
				+ "- Pour créer des objets, clique sur les objets en bas de l écran pour\n"
				+ "les sélectionner et clique sur les cases pour les placer.\n\n"
				+ "- Pour savoir comment créer un objet, place le dans la case sous\n"
				+ "le bouton Recette puis clique sur le bouton.\n\n"
				+ "- Pour savoir ce que tu peux obtenir avec un objet, place le dans \n"
				+ "la case sous le bouton Arborescence puis clique sur le bouton.");
		center.setContent(explication);;
		center.relocate(175, 0);
		



		this.getChildren().addAll(fond,center);
		this.relocate(0, 0);
		this.backgroundProperty();
	}
	
	
}
