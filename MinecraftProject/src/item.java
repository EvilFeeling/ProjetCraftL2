import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class item {
	
	public String nom;
	public int x=0,y=0;
	public Image img;
	public ArrayList<item> Ascendant;
	public ArrayList<item> Descendant;
	public int craftCode = -1; 		// cette variable stocke un code correspondant au nombre et type d'objet utilisé pour le construire
	// Cette liste stocke la matrice du craft
	public ArrayList<ArrayList<item>> craftList = new ArrayList<ArrayList<item>>();

	
	public item(String n) {
		this.nom = n;
		try {
			this.img = ImageIO.read(new File("src/images/"+n+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String toString() {
        return this.nom;
    }
	
	public void addNeed(item[][] peres) {
		for (int i = 0; i < peres.length; i++) {
			for (int j = 0; j < peres[0].length; j++) {
				if (peres[i][j] != null) {
					peres[i][j].Ascendant.add(this);
				}
			}
		}
	}
	
	public void howToCraft(Object craftList) {
		this.craftList = new ArrayList<ArrayList<item>>();
		this.craftCode = -1;
		if (craftList instanceof ArrayList<?>) {
			ArrayList<ArrayList<item>> list = (ArrayList<ArrayList<item>>)craftList;
			for (int i = 0; i < list.size(); i++) {
				ArrayList<item> ligne = new ArrayList<item>();
				for (int j = 0; j < list.get(0).size(); j++) {
					item k = list.get(i).get(j);
					if (k != null && k.nom != "vide") {
						System.out.println("i:" + i+k.nom);
						this.craftCode += (i+k.nom).hashCode();
						ligne.add(k);
					}
					
				}
				this.craftList.add(ligne);
			}
		}
		if (craftList instanceof item[][]) {			
			item[][] list = (item[][])craftList;
			for (int i = 0; i < list.length; i++) {
				ArrayList<item> ligne = new ArrayList<item>();
				for (int j = 0; j < list[0].length; j++) {
					item k = list[i][j];
					if (k != null) {
						System.out.println("i:" + i+k.nom);
						this.craftCode += (i+k.nom).hashCode();
						ligne.add(k);
					}
					
				}
				this.craftList.add(ligne);
			}
			
		}
	}
	// Méthode s'appliquant à la zone de craft, comparant, l'objet de test et un autre item.
	public boolean sameCraft(item other) {

		for (int i = 0; i < this.craftList.size(); i++) 
			for (int j = 0; j < this.craftList.get(0).size(); j++) 
				if (other.craftList.get(i).get(j) != this.craftList.get(i).get(j))
					return false;
			
		return true;
	}
	// Renvoie le craft minimum d'un item en retirant toutes les valeurs à null
	public void getMinCraft() {
		ArrayList<ArrayList<item>> finalCraft = new ArrayList<ArrayList<item>>();
		int maxX,maxY,minX,minY;
		maxX = maxY = 	0 ;
		minX = minY = 	-1;
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
		if (minX != -1 && minY != -1) {
			for (int i = minX; i <= maxX; i++) {
				ArrayList<item> ligne = new ArrayList<item>();
				for (int j = minY; j <= maxY; j++) {
					ligne.add(this.craftList.get(i).get(j));
				}
				finalCraft.add(ligne);
			}
			this.craftList = finalCraft;
		}
		//this.howToCraft(finalCraft);
		
	}
	@Override
    public int hashCode() {
		if (this.nom == "vide") {
			return 0;
		}
        return this.nom.hashCode();
    }
	
	
}
