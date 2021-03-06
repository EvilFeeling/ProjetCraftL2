package project;



import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.util.ArrayList;


public class Item extends ImageView{
	
	public String nom;
	public int x=0,y=0;
	public ArrayList<String> Ascendant = new ArrayList<String>();
	public ArrayList<String> Descendant = new ArrayList<String>();
	public int craftCode = -1; 		// cette variable stocke un code correspondant au nombre et type d'objet utilis� pour le construire
	// Cette liste stocke la matrice du craft
	public ArrayList<ArrayList<Item>> craftList = new ArrayList<ArrayList<Item>>();
	int ti = 48;
	int tc = ti + 10;
	
	public Item(String n) {
		this.nom = n;
		//System.out.println(n);
		Class<?> clazz = this.getClass();
		InputStream input = clazz.getResourceAsStream("/images/" + n +".png");
		this.setImage(new Image(input));
		this.setFitHeight(ti);
		this.setFitWidth(ti);
		this.setLayoutX(tc/2-ti/2);
		this.setLayoutY(tc/2-ti/2);

		
	}
	
	public String toString() {
        return this.nom;
    }
	

	
	public void howToCraft(Object cList) {
		this.craftList = new ArrayList<ArrayList<Item>>();
		
		
		if (cList instanceof Item[][]) {			
			Item[][] list = (Item[][])cList;
			for (int i = 0; i < list.length; i++) {
				ArrayList<Item> ligne = new ArrayList<Item>();
				for (int j = 0; j < list[0].length; j++) {
					Item k = list[i][j];
					if (k != null) {
						ligne.add(k);
					}
					
				}
				this.craftList.add(ligne);
			}
			
		}
		else if (cList instanceof ArrayList<?>) {
			ArrayList<ArrayList<Item>> laListe = new ArrayList<ArrayList<Item>>();
			laListe = (ArrayList<ArrayList<Item>>) cList;
			this.craftList = laListe;
			
		}
		this.getMinCraft();
		
		this.craftCode();
		System.out.println(this);
		System.out.println(this.craftList);
		System.out.println(this.craftCode);
		System.out.println();
	}
	// M�thode s'appliquant � la zone de craft, comparant, l'objet de test et un autre Item.
	public boolean sameCraft(Item other) {

		for (int i = 0; i < this.craftList.size(); i++) 
			for (int j = 0; j < this.craftList.get(0).size(); j++) 
				if (other.craftList.get(i).get(j) != this.craftList.get(i).get(j))
					return false;
		return true;
	}
	
	// Renvoie le craft minimum d'un Item en retirant toutes les valeurs � null et vide d�passant de la matrice minimum
	public void getMinCraft() {
		ArrayList<ArrayList<Item>> finalCraft = new ArrayList<ArrayList<Item>>();
		int maxX,maxY,minX,minY;
		maxX = maxY = 	0 ;
		minX = minY = 	-1;
		// On r�cup�re les coordonn�es
		for (int i = 0; i < this.craftList.size(); i++) {
			for (int j = 0; j < this.craftList.get(0).size(); j++) {
				if (this.craftList.get(i).get(j).nom != "vide") {
					if (minX > i || minX == -1) 
						minX = i;
					if (maxX < i) 
						maxX = i;
					if (minY > j || minY == -1) 
						minY = j;
					if (maxY < j) 
						maxY = j;
				}
			}
		}
		// On r�cup�re la matrice minimal en fonction des coordoon�es.
		if (minX != -1 && minY != -1) {
			for (int i = minX; i <= maxX; i++) {
				ArrayList<Item> ligne = new ArrayList<Item>();
				for (int j = minY; j <= maxY; j++) {
					ligne.add(this.craftList.get(i).get(j));
				}
				finalCraft.add(ligne);
			}
			this.craftList = finalCraft;
		}	
		
	}
	
	@Override
    public int hashCode() {
		
        return this.nom.hashCode();
    }
	
	public void craftCode() {
		this.craftCode = -1;
		String chaine = "";
		for (int i = 0; i < this.craftList.size(); i++) {
			for (int j = 0; j < this.craftList.get(0).size(); j++) {
				chaine += this.craftList.get(i).get(j).nom;
			}
			chaine += ";";
				
		}
	this.craftCode = chaine.hashCode();
	}
	
}
