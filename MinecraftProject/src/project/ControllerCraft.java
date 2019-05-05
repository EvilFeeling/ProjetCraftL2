package project;

import java.util.ArrayList;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

public class ControllerCraft implements EventHandler {
    Stage primaryStage;
    Pane res = new Pane();
    Modele mdl;
    String dragImage = "stick";
    ViewCraft view ;
    PaneItem rec = new PaneItem();
    PaneItem arb = new PaneItem();

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

	Pane[][] tabP = 	{	{new PaneItem(),new PaneItem(),new PaneItem()},
							{new PaneItem(),new PaneItem(),new PaneItem()},
							{new PaneItem(),new PaneItem(),new PaneItem()}
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
					MouseButton mouseB = event.getButton();
					Item img = new Item(dragImage);
					PaneItem obj = ((PaneItem)event.getSource());
					if (mouseB == MouseButton.PRIMARY) {
						obj.nom = dragImage;
					}
					else if (mouseB == MouseButton.SECONDARY) {
						obj.nom = "vide";
					}
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

        if (source.getText() == "Rechercher :") {
            majInv(mdl.recherche(view.textField1.getText()));
        }
        else if (source.getText() == "Recette") {
        	affRecette(rec.nom);
        }
        else if (source.getText() == "Arborescence") {
            affArbo(arb.nom);
        }
        else if (source.getText() == "Help") {
            affHelp();
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
				PaneItem obj = ((PaneItem)tabP[i][j]);
				matCraft[i][j] = new Item(obj.nom);
				Item img = new Item(obj.nom);
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
    public void affHelp() {
    	this.view.viewHelp.setVisible(true);
    }
    public void majInv(ArrayList<Item> listObj) {
    	view.invPlayer.tabP = new ArrayList<ArrayList<PaneItem>>();
    	ArrayList<PaneItem> ligne = new ArrayList<PaneItem>();
    	// Cette ligne réinitialise le gridpane, le lag venait d'ici, le grid était surchargé et non vidé
    	view.invPlayer.gridPane.getChildren().clear();
		for (int i=0;i<view.invPlayer.nlig ;i++) {
			
			for (int j = 0; j < view.invPlayer.ncol ; j++) {
				PaneItem k = new PaneItem();
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
				PaneItem k = new PaneItem();
				Item img = new Item(k.nom);
				k.getChildren().add(img);
				view.invCrea.gridPane.add(k,j ,i + 1 );
				k.setOnMousePressed(event -> {
					MouseButton mouseB = event.getButton();
					if (mouseB == MouseButton.PRIMARY) {
						if (k.nom == "vide") {
							k.nom = dragImage;
							Item dimg = new Item(dragImage);
							k.getChildren().clear();
							k.getChildren().add(dimg);
						}
						else {
							k.nom = dragImage;
							Item dimg = new Item(dragImage);
							k.getChildren().clear();
							k.getChildren().add(dimg);
							dragImage = k.nom;
						}
					}
					else if (mouseB == MouseButton.SECONDARY) {
						k.nom = "vide";
						k.getChildren().clear();
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
    	ArrayList<ArrayList <Item>> craftRec = mdl.Items.get(n).craftList;
    	for (int i = 0; i < matCraft.length; i++) {
    		for (int j = 0; j < matCraft[0].length; j++) {
    			matCraft[i][j] = vide;
    			tabP[i][j].getChildren().clear();
				if (i < craftRec.size() && j < craftRec.get(0).size()) {
					matCraft[i][j] = craftRec.get(i).get(j);
					tabP[i][j].getChildren().add(craftRec.get(i).get(j));
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
    public void affArbo(String n) {
    	if (arb.nom != "vide") {
    		this.view.viewArb.majAb(n);
    		this.view.viewArb.setVisible(true);
    	}
    }
}