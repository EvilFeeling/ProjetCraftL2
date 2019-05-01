package project;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class Modele extends Application {
	
	
	// Gestion Objets
	String listeItems = "";
	Item zoneCraft = new Item("zoneCraft");					// ZoneCraft
	
	Item wood = new Item("wood");							// Vide
	Item coal = new Item("coal");							// Vide
	Item flint = new Item("flint");							// Vide
	Item gold = new Item("gold");							// Vide
	Item iron = new Item("iron");							// Vide
	Item leather = new Item("leather");							// Vide
	Item redstone = new Item("redstone");							// Vide
	Item rock = new Item("rock");							// Vide
	Item feather = new Item("feather");							// Vide
	Item sugarcane = new Item("sugarcane");							// Vide
	Item string = new Item("string");							// Vide
	
	Item diamond = new Item("diamond");							// Vide
	Item obsidian = new Item("obsidian");							// Vide
	Item gunpowder = new Item("gunpowder");		
	Item sand = new Item("sand");	// Vide


	Item vide = new Item("vide");							// Vide



	
	codeCraft_HashMap codeCraft = new codeCraft_HashMap ();
	HashMap<String,Item> Items = new HashMap<String,Item>();
	
    public static void main(final String[] args) {
        launch();
    }
    

    @Override
    public void init() {

    	//Items.put("wood_plank", wood_plank);
    	Items.put("vide", vide);
    	Items.put("wood", wood);
    	Items.put("string", string);
    	Items.put("flint", flint);
    	Items.put("coal", coal);
    	Items.put("gold", gold);
    	Items.put("iron", iron);
    	Items.put("leather", leather);
    	Items.put("feather", feather);
    	Items.put("redstone", redstone);
    	Items.put("rock", rock);
    	Items.put("sugarcane", sugarcane);
    	
    	Items.put("diamond", diamond);
    	Items.put("gunpowder", gunpowder);
    	Items.put("obsidian", obsidian);
    	Items.put("sand", sand);



    	

    	
    	 
    	
    	
    	
    	zoneCraft.howToCraft(new Item[][]			{{vide,vide,vide}								,{vide,vide,vide}		,{vide,vide,vide}});

    	lireBDD();
    	System.out.println(Items);
    	System.out.println(Items.get("wood").Ascendant);
    	System.out.println(Items.get("wood").Descendant);

		
	}
	
	public ArrayList<Item> recherche(String x){
		ArrayList<Item> res = new ArrayList<Item>();
		if (x.length() != 0) {
			Pattern p = Pattern.compile("([\\w-]*" + x +"[\\w-]*)", Pattern.CASE_INSENSITIVE);
	    	Matcher m = p.matcher(listeItems);
	    	while(m.find()) {
	    		res.add(new Item(m.group(1)));
	    	}
		}
		else {
			
			for(Entry<String, Item> entry : Items.entrySet()) {
			    String key = entry.getKey();
			    Item value = entry.getValue();
			    res.add(value);
			}
		}
		
		return res;
	}
	// Va ajouter un objet ï¿½ la base de donnï¿½e, obj, dï¿½fini l'objet ï¿½ ajouter et craftable si l'objet est craftable ou non.
    public void ajouterObjet(Item obj) {
    	listeItems += obj+":";
    	codeCraft.addVal(obj);
    	
    }
    public void ajouterAll(Item[] listObj) {
    	for (int i = 0; i < listObj.length; i++) {
    		ajouterObjet(listObj[i]);
		}
    	
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        final Scene scene = new Scene(new ControllerCraft(primaryStage,this).getView());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void lireBDD() {
    	try{
        	InputStream flux=new FileInputStream("BDD.txt"); 
        	InputStreamReader lecture=new InputStreamReader(flux);
        	BufferedReader buff=new BufferedReader(lecture);
        	String ligne;
        	while ((ligne=buff.readLine())!=null){
        		//System.out.println(ligne);
        		String[] infos = ligne.split(":");
        		String nom = infos[0];
        		String[] craft = infos[1].split(";");
        		
        		ArrayList<ArrayList<Item>> listCraft = new ArrayList<ArrayList<Item>>();
        		
        		if (craft.length == 1 && craft[0].length() == 1) {
        			ArrayList<Item> ligCraft = new ArrayList<Item>();
        			ligCraft.add(new Item(craft[0]));
        			listCraft.add(ligCraft);
	        		
        		}
        		else {
        			for (int i = 0; i < craft.length; i++) {
	        			String[] ligC = craft[i].split(",") ;
	        			ArrayList<Item> ligCraft = new ArrayList<Item>();
			    				
	    				for (int j = 0; j < ligC.length; j++) {
	    					ligCraft.add(new Item(ligC[j]));
						}
	    				listCraft.add(ligCraft);
	        		}
        		}
    			
        		Item k = new Item(nom);
        		k.howToCraft(listCraft);
        		Items.put(nom,k );
        		addFamille(k.nom);
        		codeCraft.addVal(k);
        		listeItems += nom + ";";
        		
        	}
        	
        	buff.close(); 
        	}		
        	catch (Exception e){
        		System.out.println("Tout vassé" + e.toString());
        	}
    }
    public void addFamille(String k) {
    	Item item = Items.get(k);
		for (int i = 0; i < item.craftList.size(); i++) {
			for (int j = 0; j < item.craftList.get(0).size(); j++) {
				String obj = item.craftList.get(i).get(j).nom ;
				
				if ((!item.Ascendant.contains(obj)) && obj != "vide") {
					item.Ascendant.add(item.craftList.get(i).get(j).nom);
				}
				if (!Items.get(obj).Descendant.contains(item.nom)) {
					Items.get(item.craftList.get(i).get(j).nom).Descendant.add(item.nom);
				}
			}
		}
    }
}

