

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Controleur implements ItemListener,ActionListener {

	Modele modl;
	public Controleur(Modele m) {
		this.modl=m;
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object source = e.getSource();
		if (e.getSource() instanceof Button) {
			//System.out.println(((Button)source).getBackground());

		}
	}
	
	

}
