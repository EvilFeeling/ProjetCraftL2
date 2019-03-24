

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Controleur implements ItemListener,ActionListener {

	Modele modl;
	Application appli;
	public Controleur(Modele m, Application ap) {
		this.modl=m;
		this.appli=ap;
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object source = e.getSource();
		if (e.getSource() instanceof Button) {
			Button evt = (Button)source;
			if (evt.getLabel() == "Arborescence"){
				Arborescence();
			}
			if (evt.getLabel() == "Craft") {
				this.appli.AffichageCraft(this,this.modl);
			}
			if (evt.getLabel() == "Menu") {
				this.appli.AffichageMenu(this,this.modl);
			}
			if (evt.getLabel() == "Manuel d'utilisation") {
				this.appli.AffichageManuel(this,this.modl);
			}
			if (evt.getLabel() == "Retour") {
				this.appli.AffichageMenu(this,this.modl);
			}
		}
	}
	
	public void Arborescence() {
		//modl.listeItems.getKey("plop");
		System.out.println("plop");
	}
	
	

}
