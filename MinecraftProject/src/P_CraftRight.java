import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;

public class P_CraftRight extends Panel {
	public P_CraftRight() {
		this.setLayout(new GridLayout(2,0));
		Button recette = new Button("Recette");
		Button arborescence = new Button("Arborescence");
		this.add(recette);
		this.add(arborescence);
		//arborescence.addActionListener(al);
		this.setBackground(Color.pink);
	}
}
