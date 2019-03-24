import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionListener;

public class P_CraftRight extends Panel {
	public P_CraftRight(ActionListener al) {
		this.setLayout(new GridLayout(2,0));
		Button recette = new Button("Recette");
		Button arborescence = new Button("Arborescence");
		recette.addActionListener(al);
		arborescence.addActionListener(al);
		this.add(recette);
		this.add(arborescence);

		
		//arborescence.addActionListener(al);
		this.setBackground(Color.GRAY);
	}
}
