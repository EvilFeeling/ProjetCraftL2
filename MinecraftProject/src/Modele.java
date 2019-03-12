import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

public class Modele extends Observable {
	
	//Arborescence listeItems = new Arborescence();
	
	ArrayList<item> listeItems = new ArrayList<item>();
	item zoneCraft = new item("zoneCraft");		// ZoneCraft
	item vide = new item("vide");				// Vide
	item stick = new item("stick");				// Baton
	item lever = new item("lever");				// Levier
	item rock = new item("rock");				// Pierre
	item woodenPlank = new item("woodenPlank");	// Planche
	item pick = new item("pick");				// Pioche
	item axe = new item("axe");					// Hache
	
	
	
	public Modele() {
		listeItems.add(stick);listeItems.add(lever);listeItems.add(rock);listeItems.add(woodenPlank);listeItems.add(pick);listeItems.add(axe);
		
		codeCraft_HashMap codeCraft = new codeCraft_HashMap ();
		
		zoneCraft.howToCraft(new item[][]	{{rock,vide,vide}								,{stick,vide,vide}						,{vide,vide,vide}});

		stick.howToCraft(	new item[][]	{{woodenPlank}									,{woodenPlank}});
		axe.howToCraft(		new item[][]	{{woodenPlank,woodenPlank}						,{woodenPlank,stick}					,{vide,stick}});
		pick.howToCraft(	new item[][]	{{woodenPlank,woodenPlank,woodenPlank}			,{vide,stick,vide}						,{vide,stick,vide}});
		lever.howToCraft(	new item[][]	{{rock}											,{stick}});
		

		codeCraft.addVal(stick.craftCode,stick);
		codeCraft.addVal(axe.craftCode,axe);
		codeCraft.addVal(pick.craftCode,pick);
		codeCraft.addVal(lever.craftCode,lever);		
		
		
		System.out.println(codeCraft.get(lever.craftCode));
		System.out.println(zoneCraft.craftList);
		
		System.out.println(lever.craftList);
		System.out.println("lever" + lever.craftCode);
		
		
		//zoneCraft.howToCraft(zoneCraft.craftList);
		System.out.println(zoneCraft.craftList);
		System.out.println("zoneCraft" + zoneCraft.craftCode);
		
		System.out.println(codeCraft.get(zoneCraft.craftCode));
		
		
	}
	
	
	
}
