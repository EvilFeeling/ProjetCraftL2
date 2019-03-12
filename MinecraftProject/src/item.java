import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class item extends Panel{
	
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
		
		if (craftList instanceof item[][]) {			
			item[][] list = (item[][])craftList;
			for (int i = 0; i < list.length; i++) {
				ArrayList<item> ligne = new ArrayList<item>();
				for (int j = 0; j < list[0].length; j++) {
					item k = list[i][j];
					if (k != null) {
						ligne.add(k);
					}
					
				}
				this.craftList.add(ligne);
			}
			
		}
		this.getMinCraft();
		this.craftCode();
	}
	// Méthode s'appliquant à la zone de craft, comparant, l'objet de test et un autre item.
	public boolean sameCraft(item other) {

		for (int i = 0; i < this.craftList.size(); i++) 
			for (int j = 0; j < this.craftList.get(0).size(); j++) 
				if (other.craftList.get(i).get(j) != this.craftList.get(i).get(j))
					return false;
		return true;
	}
	
	// Renvoie le craft minimum d'un item en retirant toutes les valeurs à null et vide dépassant de la matrice minimum
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
	}
	
	@Override
    public int hashCode() {
		
		if (this.nom == "vide") {
			return 0;
		}
        return this.nom.hashCode();
    }
	
	public void craftCode() {
		this.craftCode = -1;
		for (int i = 0; i < this.craftList.size(); i++) {
			for (int j = 0; j < this.craftList.get(0).size(); j++) {
				item k = this.craftList.get(i).get(j);
				this.craftCode += (i+k.nom).hashCode();
			}
				
		}
	}
	
	public void paintComponent(Graphics g) {
          String test = " x vaut " + x ;
          String test2 = " y vaut " + y ;
          //g.drawImage(img, x, y, this);
          g.setColor(Color.red);
          g.drawRect(0, 0, 100, 100);
          g.drawString(test,400 , 100);
          System.out.println(test);
          System.out.println(test2);
	   
	       
	}
	
	
	
}
