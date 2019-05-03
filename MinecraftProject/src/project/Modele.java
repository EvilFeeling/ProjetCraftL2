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
	
	codeCraft_HashMap codeCraft = new codeCraft_HashMap ();
	HashMap<String,Item> Items = new HashMap<String,Item>();
    int ti = 48;
	int tc = ti + 10;
	
    public static void main(final String[] args) {
        launch();
    }
    

    @Override
    public void init() {

    	lireBDD();
    	//System.out.println(Items);
		
	}
	
	public ArrayList<Item> recherche(String x){
		ArrayList<Item> res = new ArrayList<Item>();
		if (x.length() != 0) {
			Pattern p = Pattern.compile("([\\w-]*" + x +"[\\w-]*)", Pattern.CASE_INSENSITIVE);
	    	Matcher m = p.matcher(listeItems);
	    	while(m.find()) {
	    		res.add(Items.get(m.group(1)));
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
        		Item k = new Item(nom);
        		if (infos.length != 1) {
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
        			
            		k.howToCraft(listCraft);
            		
            		
            		codeCraft.addVal(k);
        			
        		}
        		
        		}
        		Items.put(nom,k );
        		addFamille(k.nom);
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
				
				if ((!item.Ascendant.contains(obj)) && Items.get(obj) != Items.get("vide")) {
					item.Ascendant.add(item.craftList.get(i).get(j).nom);
				}
				if (!Items.get(obj).Descendant.contains(item.nom)) {
					Items.get(item.craftList.get(i).get(j).nom).Descendant.add(item.nom);
				}
			}
		}
    }
}

