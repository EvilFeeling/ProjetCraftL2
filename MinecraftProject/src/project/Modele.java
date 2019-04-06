package project;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Modele extends Application {
	
	// Gestion Objets
	ArrayList<Item> listeItems = new ArrayList<Item>();
	Item zoneCraft = new Item("zoneCraft");		// ZoneCraft
	Item vide = new Item("vide");				// Vide
	Item stick = new Item("stick");				// Baton
	Item lever = new Item("lever");				// Levier
	Item rock = new Item("rock");				// Pierre
	Item woodenPlank = new Item("woodenPlank");	// Planche
	Item pick = new Item("pick");				// Pioche
	Item axe = new Item("axe");					// Hache
	Item slabs = new Item("slabs");				// Plancher
	Item stone_sword = new Item("stone_sword");	// epe en piere
	codeCraft_HashMap codeCraft = new codeCraft_HashMap ();
	
    public static void main(final String[] args) {
        launch();
    }
    

    @Override
    public void init() {
    	listeItems.add(vide);listeItems.add(stick);listeItems.add(lever);listeItems.add(rock);listeItems.add(woodenPlank);listeItems.add(pick);listeItems.add(axe);listeItems.add(slabs);
		System.out.print("Le résultat de recherche:");
		System.out.println(this.recherche("o"));
		
		
		zoneCraft.howToCraft(new Item[][]	{{vide,vide,vide}								,{woodenPlank,woodenPlank,woodenPlank}	,{vide,vide,vide}});

		stick.howToCraft(	new Item[][]	{{woodenPlank}									,{woodenPlank}});
		axe.howToCraft(		new Item[][]	{{woodenPlank,woodenPlank}						,{woodenPlank,stick}					,{vide,stick}});
		pick.howToCraft(	new Item[][]	{{woodenPlank,woodenPlank,woodenPlank}			,{vide,stick,vide}						,{vide,stick,vide}});
		lever.howToCraft(	new Item[][]	{{rock}											,{stick}});
		slabs.howToCraft(	new Item[][]	{{woodenPlank,woodenPlank,woodenPlank}});
		

		codeCraft.addVal(stick.craftCode,stick);
		codeCraft.addVal(axe.craftCode,axe);
		codeCraft.addVal(pick.craftCode,pick);
		codeCraft.addVal(lever.craftCode,lever);
		codeCraft.addVal(slabs.craftCode,slabs);
		
		
		System.out.println(codeCraft.get(lever.craftCode));
		System.out.println(zoneCraft.craftList);
		
		System.out.println(slabs.craftList);
		System.out.println("slabs" + slabs.craftCode);
		
		
		//zoneCraft.howToCraft(zoneCraft.craftList);
		System.out.println(zoneCraft.craftList);
		System.out.println("zoneCraft" + zoneCraft.craftCode);
		
		System.out.println(codeCraft.get(zoneCraft.craftCode));
		
		
	}
	
	public ArrayList<Item> recherche(String x){
		
		ArrayList<Item> res = new ArrayList<Item>(); 		
		for (int i = 0; i < listeItems.size(); i++) {
			if (listeItems.get(i).nom.contains(x)){
				res.add(listeItems.get(i)); 
			}
		}
		
		return res;
	}
    

    @Override
    public void start(final Stage primaryStage) throws Exception {
        final Scene scene = new Scene(new ControllerCraft(primaryStage,this).getView());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}