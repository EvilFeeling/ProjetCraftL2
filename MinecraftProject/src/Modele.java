import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

public class Modele extends Observable {
	
	Arborescence listeItems = new Arborescence();
	
	item zoneCraft = new item("zoneCraft");		// ZoneCraft
	item vide = new item("vide");				// Vide
	item stick = new item("stick");				// Baton
	item lever = new item("lever");				// Levier
	item rock = new item("rock");				// Pierre
	item woodenPlank = new item("woodenPlank");	// Planche
	item pick = new item("pick");				// Pioche
	item axe = new item("axe");					// Hache
	
	
	
	public Modele() {
		
		codeCraft_HashMap codeCraft = new codeCraft_HashMap ();
		
		//stick.howToCraft(new item[][]		{{null	,null	,null}							,{null	,null	,null	},{null	,null	,null}});
		stick.howToCraft(	new item[][]	{{woodenPlank}									,{woodenPlank}});
		axe.howToCraft(		new item[][]	{{woodenPlank,woodenPlank}						,{woodenPlank,stick}					,{vide,stick}});
		pick.howToCraft(	new item[][]	{{woodenPlank,woodenPlank,woodenPlank}			,{vide,stick,vide}						,{vide,stick,vide}});
		
		vide.howToCraft(	new item[][]	{{vide,vide,woodenPlank}			,{vide,vide,woodenPlank}						,{vide,vide,vide}});
		
		//zoneCraft.howToCraft(new item[][]	{{vide,vide,vide}			,{vide,vide,vide}						,{vide,vide,vide}});
		zoneCraft.howToCraft(new item[][]	{{rock,vide,vide}			,{stick,vide,vide}						,{vide,vide,vide}});
		lever.howToCraft(	new item[][]	{{rock}											,{stick}});

		codeCraft.addVal(stick.craftCode,stick);
		codeCraft.addVal(rock.craftCode,rock);
		
		codeCraft.addVal(pick.craftCode,pick);
		codeCraft.addVal(axe.craftCode,axe);
		
		codeCraft.addVal(lever.craftCode,lever);
		/*
		System.out.println(stick.craftCode);
		System.out.println(stick.craftList);
		
		System.out.println(axe.craftCode);
		System.out.println(axe.craftList);
		
		System.out.println(pick.craftCode);
		System.out.println(pick.craftList);*/
		
		
		
		System.out.println(codeCraft.get(lever.craftCode));
		System.out.println(zoneCraft.craftList);
		
		System.out.println("azaaa");
		
		System.out.println(lever.craftList);
		System.out.println("lever" + lever.craftCode);
		
		
		zoneCraft.getMinCraft();
		zoneCraft.howToCraft(zoneCraft.craftList);
		System.out.println(zoneCraft.craftList);
		System.out.println("zoneCraft" + zoneCraft.craftCode);
		
		
	}
	
	
	
}
