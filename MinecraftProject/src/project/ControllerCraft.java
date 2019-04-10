package project;

import java.util.ArrayList;
import java.util.Map.Entry;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;

import javafx.stage.Stage;

public class ControllerCraft implements EventHandler {
    Stage primaryStage;
    Pane res = new Pane();
    Modele mdl;
    String dragImage = "stick";
    ViewCraft view = new ViewCraft(this, mdl);
    int ti = 48;
	int tc = ti + 10;
	// Cette chaine stocke les caractéristiques d'une case vide.
	String basePan = "-fx-border-color: WHITE;-fx-background-color: rgb(180, 180, 180);-fx-background-radius: 2; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.9), 1, 0, 0, 1); -fx-font-size:10;";

	Item zoneCraft = new Item("zoneCraft");		// ZoneCraft
	
	Item vide = new Item("vide");				// Vide
	Item rock = new Item("rock");				// Pierre
	Item stick = new Item("stick");				// Stick
	Item wood_plank = new Item("wood_plank");	// Planche
	
	
	Item[][] matCraft = 	{	{wood_plank,wood_plank,wood_plank},	 
							{vide,stick,vide}, 	
							{vide,vide,vide}
						};

	Pane[][] tabP = 	{	{new PaneItem(0,0),new PaneItem(1,0),new PaneItem(2,0)},
							{new PaneItem(0,1),new PaneItem(1,1),new PaneItem(2,1)},
							{new PaneItem(0,2),new PaneItem(1,2),new PaneItem(2,2)}
						};
	ArrayList<Item> matInvP = new ArrayList<Item>();


    public ControllerCraft(final Stage primaryStage,Modele modl) {
    	// Initialisation du controlleur.
        this.primaryStage = primaryStage;
        this.mdl = modl;
        System.out.println();
        
    	
    	// Gestion de la table de Craft
    	Pane VIDE= new Pane ();
    	VIDE.setStyle("-fx-border-color: white; -fx-font-size:10;");
		VIDE.setPrefSize(tc,tc);
		// On initialise, la zone de craft, avec une recette de craft emplie d'objets vide.
		zoneCraft.howToCraft(new Item[][]	{{vide,vide,vide}								,{vide,vide,vide}						,{vide,vide,vide}});
		// Création des cases
		for (int i = 0; i < tabP.length; i++) {
			for (int j = 0; j < tabP.length; j++) {
				tabP[i][j].setStyle(basePan);
				tabP[i][j].setMaxSize(tc,tc);
				tabP[i][j].setMinSize(tc,tc);
				// Doit modifier la matrice.
				tabP[i][j].setOnMousePressed(event -> {
					Item img = new Item(dragImage);
					PaneItem obj = ((PaneItem)event.getSource());
					matCraft[obj.i][obj.j] = img;
					majTable();
					
		    		
		    	});
				view.craftTable.grid.add(tabP[i][j], j, i);
				
			}
		}
		// Init de la case de résultat
		res.setStyle(basePan);
		res.setPrefSize(tc,tc);
		res.setOnMousePressed(event -> {
			if (res.getChildren().size() > 0) {
				dragImage = ((Item)res.getChildren().get(0)).nom;
			}

		});
		
		view.craftTable.grid.add(res,4 ,1,1,1 );
		view.craftTable.grid.add(VIDE, 3, 1, 1, 1);
		
		// Gestion de l'inventaire du bas.
	    majInv(mdl.recherche(""));
	    // Gestion de l'inventaire du bas.
	    leftInv();
	    // Fin gestion inv bas
	    majTable();
        
        
    }

    @Override
    public void handle(Event event) {
    	System.out.println("salut");
        final Button source = (Button)event.getSource();
        if (source.getText() == "Menu") {
            System.out.println("ButtonA has been pressed, switching to ViewB.");

            ControllerMenu controllerM = new ControllerMenu(primaryStage,mdl);
            Scene scene = new Scene(controllerM.getView());
            primaryStage.setScene(scene);
        }
        if (source.getText() == "Rechercher :") {
            majInv(mdl.recherche(view.textField1.getText()));
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ViewCraft getView() {
        return view;
    }
    
    // Modifie la matrice de VCTable d'après la matrice d'objet
    public void majTable() {
		// Modifie l'affichage d'après la matrice.
		for (int i=0;i<matCraft.length;i++) {
			for (int j = 0; j < matCraft.length; j++) {
				if (matCraft[i][j] != vide) {
					String n = matCraft[i][j].nom;
					Item img = new Item(n);
					tabP[i][j].getChildren().clear();
					tabP[i][j].getChildren().add(img);
				}
			}
		}
		zoneCraft.howToCraft(matCraft);
		res.getChildren().clear();
		if (mdl.codeCraft.get(zoneCraft.craftCode) != null) {
			Item resultat = new Item(mdl.codeCraft.get(zoneCraft.craftCode).get(0).nom);
			res.getChildren().add(resultat);
			
		}
	}
    
    public void majInv(ArrayList<Item> listObj) {
    	
    	ArrayList<PaneItem> ligne = new ArrayList<PaneItem>();
		for (int i=0;i<view.invPlayer.nlig ;i++) {
			
			for (int j = 0; j < view.invPlayer.ncol ; j++) {
				PaneItem k = new PaneItem(i,j);
				k.setStyle(basePan);
				k.setPrefSize(tc,tc);
				k.setMaxSize(tc, tc);
				if (i * view.invPlayer.ncol  + j < listObj.size()) {
					k.nom = listObj.get(i * view.invPlayer.ncol  + j).nom;
				}		
				else {
					k.nom = "vide";
				}
				Item img = new Item(k.nom);
				k.getChildren().add(img);
				view.invPlayer.gridPane.add(k,j ,i + 1 );
				k.setOnMousePressed(event -> {
					dragImage = k.nom;
				});
	    		ligne.add(k);
			}
			view.invPlayer.tabP.add(ligne);
			ligne = new ArrayList<PaneItem>();
		
		}
	}
    public void leftInv() {
    	
    	ArrayList<PaneItem> ligne = new ArrayList<PaneItem>();
		for (int i=0;i<view.invCrea.nlig ;i++) {
			
			for (int j = 0; j < view.invCrea.ncol ; j++) {
				PaneItem k = new PaneItem(i,j);
				k.setStyle(basePan);
				k.setPrefSize(tc,tc);
				k.setMaxSize(tc, tc);
				k.nom = "vide";
				Item img = new Item(k.nom);
				k.getChildren().add(img);
				view.invCrea.gridPane.add(k,j ,i + 1 );
				k.setOnMousePressed(event -> {
					if (k.nom == "vide") {
						k.nom = dragImage;
						Item dimg = new Item(dragImage);
						k.getChildren().clear();
						k.getChildren().add(dimg);
					}
					else {
						dragImage = k.nom;
					}
					
				});
	    		ligne.add(k);
			}
			view.invCrea.tabP.add(ligne);
			ligne = new ArrayList<PaneItem>();
		
		}
	}
}