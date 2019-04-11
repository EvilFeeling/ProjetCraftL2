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
	Item aok_fence = new Item("aok_fence");					// Barriï¿½re en bois
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

		
		
		// Ligne 1 A ajouter ï¿½ la liste d'objets
		ajouterAll(new Item[] { stick, lever,rock,wood_plank,wooden_pickaxe,wooden_axe,wood_slab,stone_sword,stone_pickaxe,stone_axe,stone_shovel,aok_fence_gate,aok_fence,vide});
    	// Ligne 2
		ajouterAll(new Item[] { chest, crafting_table,furnace,cobblestone_slab,cobblestone_wall,sign,wood,watch,vide,vide,vide,aok_fence_gate,aok_fence,vide});


    	
    	System.out.print("Le rï¿½sultat de recherche:");
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
	// Va ajouter un objet ï¿½ la base de donnï¿½e, obj, dï¿½fini l'objet ï¿½ ajouter et craftable si l'objet est craftable ou non.
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





//rajout base de données:


objet : vide,vide,vide;vide,vide,vide;vide,vide,vide

//objet primaire:

wood
coal
flint
gold
iron
leather
redstone
rock
feather
sugarcane
string**


//objet secondaire:

wood_plank : vide,vide,vide;vide,wood,vide;vide,vide,vide
stick : vide ,vide ,vide;vide ,wood_plank,vide;vide,wood_plank,vide
wools : vide,vide,vide;string,string,vide;string,string,vide
aok_fence_gate : vide,vide,vide;stick,wood_plank,stick;stick,wood_plank,stick
aok_fence : vide,vide,vide;wood_plank,stick,wood_plank;wood_plank,stick,wood_plank 
arrow : vide,flint,vide;vide,stick,vide;vide,feather,vide
boat : vide,vide,vide;wood_plank,vide,wood_plank;wood_plank,wood_plank,wood_plank
paper: vide,vide,vide;sugarcane,sugarcane,sugarcane;vide,vide,vide
book : vide,vide,vide;paper,paper,vide;paper,leather,vide
bookshelf : wood_plank,wood_plank,wood_plank;book,book,book;wood_plank,wood_plank,wood_plank
bow : vide,stick,string;stick,vide,string;vide,stick,string
bucket : vide,vide,vide;iron,vide,iron;vide,iron,vide
chest : wood_plank,wood_plank,wood_plank;wood_plank,vide,wood_plank;wood_plank,wood_plank,wood_plank
cobblestone_slab : vide,vide,vide;vide,vide,vide;rock,rock,rock
cobblestone_wall : vide,vide,vide;rock,rock,rock;rock,rock,rock
compass : vide,iron,vide;iron,redstone,iron;vide,iron,vide
crafting_table : vide,vide,vide;vide,wood_plank,wood_plank;vide,wood_plank,wood_plank
dispenser : rock,rock,rock;rock,bow,rock;rock,redstone,rock
furnace : rock,rock,rock;rock,vide,rock;rock,rock,rock
lever : vide,vide,vide;vide,stick,vide;vide,rock,vide
lighter : vide,vide,vide;iron,flint,vide;vide,vide,vide
watch : vide,gold,vide;gold,redstone,gold;vide,gold,vide
redstone_torch : vide,vide,vide;vide,redstone,vide,vide,stick,vide
shear : vide,vide,vide;vide,iron,vide;iron,vide,vide
fishing_rod : vide,vide,stick;vide,stick,string;stick,vide,string
piston : wood_plank,wood_plank,wood_plank;rock,iron,rock;rock,redstone,rock
sign : wood_plank,wood_plank,wood_plank;wood_plank,wood_plank,wood_plank;vide,stick,vide
woodendoor : wood_plank,wood_plank,vide;wood_plank,wood_plank,vide;wood_plank,wood_plank,vide
trapdoor : vide,vide,vide;wood_plank,wood_plank,wood_plank;wood_plank,wood_plank,wood_plank
pressure_plate : vide,vide,vide;wood_plank,wood_plank,vide;vide,vide,vide
wood_slab : vide,vide,vide;vide,vide,vide;wood_plank,wood_plank,wood_plank
cartography_table*** : paper,paper,vide;wood_plank,wood_plank,vide;wood_plank,wood_plank,vide
paint : stick,stick,stick;stick,wools,stick;stick,stick,stick
music_box : wood_plank,wood_plank,wood_plank;wood_plank,redstone,wood_plank;wood_plank,wood_plank,wood_plank
bed : vide,vide,vide;wools,wools,wools;wood_plank,wood_plank,wood_plank
banner : wools,wools,wools;wools,wools,wools;vide,stick,vide
sugar : vide,vide,vide;vide,sugarcane,vide;vide,vide,vide
shield : wood_plank,iron,wood_plank;wood_plank,wood_plank,wood_plank;vide,wood_plank,vide
map : paper,paper,paper;paper,compass,paper;paper,paper,paper

//armure :

iron_boots : vide,vide,vide;iron,vide,iron;iron,vide,iron
iron_leggings : iron,iron,iron;iron,vide,iron;iron,vide,iron
ironchesplate : iron,vide,iron;iron,iron,iron;iron,iron,iron
ironhelmet : iron,iron,iron;iron,vide,iron;vide,vide,vide

//arme :

stone_axe : rock,rock,vide;rock,stick,vide;vide,stick,vide
stone_pickaxe : rock,rock,rock;vide,stick,vide;vide,stick,vide
stone_shovel : vide,rock,vide;vide,stick,vide;vide,stick,vide
stone_sword : vide,rock,vide;vide,rock,vide;vide,stick,vide

wooden_axe : wood_plank,wood_plank,vide;wood_plank,stick,vide;vide,stick,vide
wooden_pickaxe : wood_plank,wood_plank,wood_plank;vide,stick,vide;vide,stick,vide
wooden_shovel : vide,wood_plank,vide;vide,stick,vide;vide,stick,vide
wooden_sword*** : vide,wood_plank,vide;vide,wood_plank,vide;vide,stick,vide

