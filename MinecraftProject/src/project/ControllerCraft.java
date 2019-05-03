package project;

import java.util.ArrayList;

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
    ViewCraft view ;
    PaneItem rec = new PaneItem(0,0);
    PaneItem arb = new PaneItem(0,0);

	// Cette chaine stocke les caractï¿½ristiques d'une case vide.
	String basePan = "-fx-border-color: WHITE;-fx-background-color: #c6c6c6; -fx-effect: innershadow( three-pass-box, rgba( 0, 0, 0, 0.5 ), 10, 0.2, 1, 1 ); -fx-font-size:10;";
	


	Item zoneCraft = new Item("zoneCraft");		// ZoneCraft
	
	Item vide = new Item("vide");				// Vide
	Item rock = new Item("rock");				// Pierre
	Item stick = new Item("stick");				// Stick
	//Item wood_plank = new Item("wood_plank");	// Planche
	
	
	Item[][] matCraft = 	{	{vide,vide,vide},	 
							{vide,stick,vide}, 	
							{vide,vide,vide}
						};

	Pane[][] tabP = 	{	{new PaneItem(0,0),new PaneItem(1,0),new PaneItem(2,0)},
							{new PaneItem(0,1),new PaneItem(1,1),new PaneItem(2,1)},
							{new PaneItem(0,2),new PaneItem(1,2),new PaneItem(2,2)}
						};



    public ControllerCraft(final Stage primaryStage,Modele modl) {
    	// Initialisation du controlleur.
        this.primaryStage = primaryStage;
        this.mdl = modl;
        view = new ViewCraft(this, mdl);
        
    	
    	// Gestion de la table de Craft
    	Pane VIDE= new Pane ();
    	VIDE.setStyle(" -fx-font-size:10;");
		VIDE.setPrefSize(mdl.tc,mdl.tc);
		// On initialise, la zone de craft, avec une recette de craft emplie d'objets vide.
		zoneCraft.howToCraft(new Item[][]	{{vide,vide,vide}								,{vide,vide,vide}						,{vide,vide,vide}});
		
		
		// Crï¿½ation des cases
		for (int i = 0; i < tabP.length; i++) {
			for (int j = 0; j < tabP.length; j++) {
				
				tabP[i][j].setStyle(basePan);
				tabP[i][j].setMaxSize(mdl.tc,mdl.tc);
				tabP[i][j].setMinSize(mdl.tc,mdl.tc);
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
		// Init de la case de rï¿½sultat
		res.setStyle(basePan);
		res.setPrefSize(mdl.tc,mdl.tc);
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
        
	    rightCraft();
	    //affRecette("bed");
        
    }

    @Override
    public void handle(Event event) {
        final Button source = (Button)event.getSource();
        System.out.println(source);
        if (source.getText() == "Menu") {
            ControllerMenu controllerM = new ControllerMenu(primaryStage,mdl);
            Scene scene = new Scene(controllerM.getView());
            primaryStage.setScene(scene);
        }
        else if (source.getText() == "Rechercher :") {
            majInv(mdl.recherche(view.textField1.getText()));
        }
        else if (source.getText() == "Recette") {
        	affRecette(rec.nom);
        }
        else if (source.getText() == "Arborescence") {
            affArbo(arb.nom);
        }
        
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ViewCraft getView() {
        return view;
    }
    
    // Modifie la matrice de VCTable d'aprï¿½s la matrice d'objet
    public void majTable() {
		// Modifie l'affichage d'aprï¿½s la matrice.
		for (int i=0;i<matCraft.length;i++) {
			for (int j = 0; j < matCraft.length; j++) {
				
				String n = matCraft[i][j].nom;
				Item img = new Item(n);
				tabP[i][j].getChildren().clear();
				tabP[i][j].getChildren().add(img);
				
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
    	view.invPlayer.tabP = new ArrayList<ArrayList<PaneItem>>();
    	ArrayList<PaneItem> ligne = new ArrayList<PaneItem>();
    	// Cette ligne réinitialise le gridpane, le lag venait d'ici, le grid était surchargé et non vidé
    	view.invPlayer.gridPane.getChildren().clear();
		for (int i=0;i<view.invPlayer.nlig ;i++) {
			
			for (int j = 0; j < view.invPlayer.ncol ; j++) {
				PaneItem k = new PaneItem(i,j);
				k.setStyle(basePan);
				k.setPrefSize(mdl.tc,mdl.tc);
				k.setMaxSize(mdl.tc, mdl.tc);
				if (i * view.invPlayer.ncol  + j < listObj.size()) {
					k.nom = listObj.get(i * view.invPlayer.ncol  + j).nom;
				}		
				else {
					k.nom = "vide";
				}
				Item img = mdl.Items.get(k.nom);
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
				k.setPrefSize(mdl.tc,mdl.tc);
				k.setMaxSize(mdl.tc, mdl.tc);
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
    
    public void rightCraft() {
    	
		rec.setStyle(basePan);
		rec.setPrefSize(mdl.tc,mdl.tc);
		rec.setMaxSize(mdl.tc, mdl.tc);
		rec.nom = "vide";
		rec.relocate(30, 30);
		
		rec.setOnMousePressed(event -> {
			rec.nom = dragImage;
			Item dimg = new Item(dragImage);
			rec.getChildren().clear();
			rec.getChildren().add(dimg);		});
		
		arb.setStyle(basePan);
		arb.setPrefSize(mdl.tc,mdl.tc);
		arb.setMaxSize(mdl.tc,mdl.tc);
		arb.nom = "vide";
		arb.relocate(30, 150);
		arb.setOnMousePressed(event -> {
			arb.nom = dragImage;
			Item dimg = new Item(dragImage);
			arb.getChildren().clear();
			arb.getChildren().add(dimg);		});
		view.vcRight.getChildren().addAll(rec,arb);
    }
    
    public void affRecette(String n) {
    	System.out.println("salutt");
    	System.out.println(mdl.Items.get((String)n));
    	ArrayList<ArrayList <Item>> craftRec = mdl.Items.get(n).craftList;
    	for (int i = 0; i < matCraft.length; i++) {
    		for (int j = 0; j < matCraft[0].length; j++) {
    			matCraft[i][j] = vide;
				if (i < craftRec.size() && j < craftRec.get(0).size()) {
					matCraft[i][j] = craftRec.get(i).get(j);
				}
			}
		}
    	majTable();
    }
    public void affArbo(String n) {
    	if (arb.nom != "vide") {
    		this.view.viewArb.majAb(n);
    		this.view.viewArb.setVisible(true);
    	}
    }
}