package project;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Modele extends Application {
	
	// Gestion Objets
	ArrayList<Item> listeItems = new ArrayList<Item>();
	Item zoneCraft = new Item("zoneCraft");					// ZoneCraft
	Item vide = new Item("vide");							// Vide
	Item stick = new Item("stick");							// Baton
	Item lever = new Item("lever");							// Levier
	Item rock = new Item("rock");							// Pierre
	Item wood_plank = new Item("wood_plank");				// Planche
	Item wooden_pickaxe = new Item("wooden_pickaxe");		// Pioche
	Item wooden_axe = new Item("wooden_axe");				// Hache
	Item wood_slab = new Item("wood_slab");					// Plancher
	Item stone_sword = new Item("stone_sword");				// Epee en piere
	Item stone_pickaxe = new Item("stone_pickaxe");			// pioche en piere
	Item stone_axe = new Item("stone_axe");					// Hache en piere
	Item stone_shovel = new Item("stone_shovel");			// Pelle en piere
	Item aok_fence_gate = new Item("aok_fence_gate");		// Porte en bois
	Item aok_fence = new Item("aok_fence");					// Barri�re en bois
	Item wood = new Item("wood");							// bois
	Item chest = new Item("chest");							// bois
	Item crafting_table = new Item("crafting_table");		// table craft
	Item furnace = new Item("furnace");						// four
	Item cobblestone_slab = new Item("cobblestone_slab");		// plancher pierre
	Item cobblestone_wall = new Item("cobblestone_wall");		// mur pierre
	Item sign = new Item("sign");							// panneau
	
	Item watch = new Item("watch");							// montre

	
	codeCraft_HashMap codeCraft = new codeCraft_HashMap ();
	
    public static void main(final String[] args) {
        launch();
    }
    

    @Override
    public void init() {
    	
    	zoneCraft.howToCraft(new Item[][]			{{vide,vide,vide}								,{wood_plank,wood_plank,wood_plank}		,{vide,vide,vide}});

		stick.howToCraft(	new Item[][]			{{wood_plank}									,{wood_plank}});
		wooden_axe.howToCraft(		new Item[][]	{{wood_plank,wood_plank}						,{wood_plank,stick}						,{vide,stick}});
		wooden_pickaxe.howToCraft(	new Item[][]	{{wood_plank,wood_plank,wood_plank}				,{vide,stick,vide}						,{vide,stick,vide}});
		lever.howToCraft(	new Item[][]			{{rock}											,{stick}});
		wood_slab.howToCraft(	new Item[][]		{{wood_plank,wood_plank,wood_plank}});
		stone_sword.howToCraft(	new Item[][]		{{rock}											,{rock}									,{stick}});
		stone_pickaxe.howToCraft(	new Item[][]	{{rock,rock,rock}								,{vide,stick,vide}						,{vide,stick,vide}});
		stone_axe.howToCraft(	new Item[][]		{{rock,rock}									,{rock,stick}							,{vide,stick}});
		stone_shovel.howToCraft(	new Item[][]	{{rock}											,{stick}								,{stick}});
		aok_fence_gate.howToCraft(	new Item[][]	{{stick,wood_plank,stick}						,{stick,wood_plank,stick}});
		aok_fence.howToCraft(	new Item[][]		{{wood_plank,stick,wood_plank}					,{wood_plank,stick,wood_plank}});
		
		chest.howToCraft(	new Item[][]			{{wood_plank,wood_plank,wood_plank}				,{wood_plank,vide,wood_plank}			,{wood_plank,wood_plank,wood_plank}});
		crafting_table.howToCraft(	new Item[][]	{{wood_plank,wood_plank}						,{wood_plank,wood_plank,}});
		furnace.howToCraft(	new Item[][]			{{rock,rock,rock}								,{rock,vide,rock}						,{rock,rock,rock}});
		cobblestone_slab.howToCraft(	new Item[][]	{{rock,rock,rock}});
		cobblestone_wall.howToCraft(	new Item[][]	{{rock,rock,rock},{rock,rock,rock}});
		sign.howToCraft(	new Item[][]			{{wood_plank,wood_plank,wood_plank}				,{wood_plank,wood_plank,wood_plank}		,{vide,stick,vide}});
		wood_plank.howToCraft(	new Item[][]			{{wood}});

		
		
		// Ligne 1 A ajouter � la liste d'objets
		ajouterAll(new Item[] { stick, lever,rock,wood_plank,wooden_pickaxe,wooden_axe,wood_slab,stone_sword,stone_pickaxe,stone_axe,stone_shovel,aok_fence_gate,aok_fence,vide});
    	// Ligne 2
		ajouterAll(new Item[] { chest, crafting_table,furnace,cobblestone_slab,cobblestone_wall,sign,wood,watch,vide,vide,vide,aok_fence_gate,aok_fence,vide});


    	
    	System.out.print("Le r�sultat de recherche:");
		System.out.println(this.recherche("s"));
		
		
			
		
		
		System.out.println(codeCraft.get(lever.craftCode));
		System.out.println(zoneCraft.craftList);
		
		System.out.println(wood_slab.craftList);
		System.out.println("slabs" + wood_slab.craftCode);
		
		
		//zoneCraft.howToCraft(zoneCraft.craftList);
		System.out.println(zoneCraft.craftList);
		System.out.println("zoneCraft" + zoneCraft.craftCode);
		
		System.out.println(codeCraft.get(zoneCraft.craftCode));
		
		
	}
	
	public ArrayList<Item> recherche(String x){
		
		ArrayList<Item> res = new ArrayList<Item>(); 		
		res.add(vide);
		for (int i = 0; i < listeItems.size(); i++) {
			if (listeItems.get(i).nom.contains(x)){
				res.add(listeItems.get(i)); 
			}
		}
		
		return res;
	}
	// Va ajouter un objet � la base de donn�e, obj, d�fini l'objet � ajouter et craftable si l'objet est craftable ou non.
    public void ajouterObjet(Item obj) {
    	listeItems.add(obj);
    	codeCraft.addVal(obj);
    	
    }
    public void ajouterAll(Item[] listObj) {
    	for (int i = 0; i < listObj.length; i++) {
    		listeItems.add(listObj[i]);
    		codeCraft.addVal(listObj[i]);
		}
    	
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        final Scene scene = new Scene(new ControllerCraft(primaryStage,this).getView());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}