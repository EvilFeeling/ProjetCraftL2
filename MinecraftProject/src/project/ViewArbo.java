package project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


public class ViewArbo extends Pane {
	GridPane gridArb = new GridPane ();
	Modele mdl;
	int ti = 48;
	int tc = ti + 10;
	
	public ViewArbo(Modele modl) {
		this.mdl = modl;
		this.setOnMousePressed(event -> {
			this.setVisible(false);
			
		});
		this.setMaxSize(1000, 650);
		this.setMinSize(1000, 650);
		
		Pane fond = new Pane();
		fond.setMaxSize(1000, 650);
		fond.setMinSize(1000, 650);
		fond.setStyle("-fx-background-color:#000");
		fond.setOpacity(0.5);
		
		ScrollPane center = new ScrollPane();
		center.setMaxSize(400, 650);
		center.setMinSize(400, 650);
		center.setStyle("-fx-background:#555");
		
		center.relocate(275, 0);
		
		//Setting the vertical and horizontal gaps between the columns 
		gridArb.setVgap(20); 
		gridArb.setHgap(60);       

		//Setting the Grid alignment 
		gridArb.setAlignment(Pos.CENTER);

		gridArb.setPadding(new Insets(60, 0, 60, 70));
		
		majAb("wood_plank");

		center.setContent(gridArb);
		this.getChildren().addAll(fond,center);
		this.relocate(0, 0);
		this.backgroundProperty();
	}
	
	public void majAb(String n) {
		gridArb.getChildren().clear();
		Item k = mdl.Items.get(n);
		int nbAsc = k.Ascendant.size();
		for (int i = 0; i < nbAsc; i++) {
			PaneItem p = new PaneItem();
			Item img = new Item(k.Ascendant.get(i));
			p.getChildren().add(img);
			
			p.draw("Ascendant", nbAsc - 1 - i);
			
			
			gridArb.add(p,0,i);
		}
		// L'objet central
		PaneItem pobj = new PaneItem();
		Item imgobj = new Item(n);
		pobj.getChildren().add(imgobj);
		
		if (k.Descendant.size() > 0) {
			pobj.draw("Ascendant", 0);
		}
		if (k.Ascendant.size() > 0) {
			pobj.draw("Descendant", -1);		
		} 
		int posY = 0;
		if (nbAsc > 1) {
			gridArb.add(pobj,1,nbAsc - 1);
			posY = nbAsc-1;
		}
		else {
			gridArb.add(pobj,1,0);
		}
		// Fin de l'objet central
		
		for (int i = 0; i < k.Descendant.size(); i++) {
			
			//Item img = mdl.Items.get(k.Descendant.get(i));
			Item obj = mdl.Items.get(k.Descendant.get(i));
			Item img = new Item(k.Descendant.get(i));
			
			Pane pan = new Pane();
			pan.setPrefSize(tc,tc);
			pan.setMaxSize(tc, tc);
			
			gridArb.add(pan,2,posY+1);
			if (img.Ascendant.size() > 2) {
				posY += obj.Ascendant.size() - 1;
				
			}
			else if (i == 0){
				posY += obj.Ascendant.size() - 1;
			}
			else {
				posY += 2;
			}
			
			PaneItem p = new PaneItem();
			
			p.getChildren().add(img);
			if (i == 0) {
				p.draw("Descendant", obj.Ascendant.size() - 2);
			}
			else {
				p.draw("Descendant", obj.Ascendant.size());
			}
			

			gridArb.add(p,2,posY);
			
			//System.out.println(img.Ascendant);
			int posYY = 0;
			for (int j = 0; j < obj.Ascendant.size(); j++) {
				//System.out.println("rez");
				if (mdl.Items.get(obj.Ascendant.get(j)) != mdl.Items.get(n) || i == 0) {
					Item imgA = new Item(obj.Ascendant.get(j));
					PaneItem po = new PaneItem();
					po.getChildren().add(imgA);
					
					po.draw("Ascendant", 0);
					
					gridArb.add(po,1,posY - posYY);
					posYY += 1;
				}
			}
			
			
			
			
		}
		
		
	}
	
	
	
	
	
	
}
