import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

public class View_Craft extends Panel implements Observer{
	int a;
	int WIDTH = 1000;
	int HEIGHT = 600;
	int tailleCase = 48;
	int border = 2;
	
	public View_Craft(ActionListener al,Modele m) {
		
		int tx,ty;
		
		Font fontTitre = new Font("Arial",Font.BOLD,40);
		Font fontMenu = new Font("Arial",Font.BOLD,40);
		
		//AffichageCraft AffCraft= new AffichageCraft(c,m);
		
		Label titre = new Label("Craft");
		titre.setBounds(this.WIDTH/2 - 50,50,100,50);
		titre.setBackground(Color.gray);
		titre.setFont(fontTitre);
		
		Button menu = new Button("Menu");
		menu.setBounds(50,50,110,50);
		menu.setBackground(Color.green);
		menu.setFont(fontMenu);
		
		Panel inv = new Panel();
		tx = (tailleCase * 5) + border * 5;
		ty = (tailleCase * 5) + border * 5;
		inv.setBounds(50, this.HEIGHT/2 - ty/2 - 30, tx, ty);
		inv.setBackground(Color.blue);
		
		Panel right = new P_CraftRight();
		
		right.setBounds(this.WIDTH - tx - 50, this.HEIGHT/2 - ty/2 - 30, tx, ty);
		
		
		Panel panCraft = new Panel();
		tx = (tailleCase * 7) + border * 7;
		ty = (tailleCase * 5) + border * 5;
		panCraft.setBounds(this.WIDTH/2 - tx/2, this.HEIGHT/2 - ty/2 - 30, tx, ty);
		panCraft.setBackground(Color.red);
		
		Panel invCrea = new Panel();
		//m.stick.paint(invCrea);
		tx = (tailleCase * 16) + border * 16;
		ty = (tailleCase * 3) + border * 3;
		invCrea.setBounds(this.WIDTH/2 - tx/2, this.HEIGHT - ty - 20, tx, ty);
		invCrea.setBackground(Color.orange);
		/*invCrea.setLayout(new GridLayout(16,3));
		for (int i = 0; i < m.listeItems.size(); i++) {
			invCrea.add(new Panel());
		}*/
		
		this.add(titre);
		this.add(menu);
		this.add(inv);
		this.add(panCraft);
		this.add(invCrea);
		this.add(right);
		
		
		this.setBounds(0, 0, WIDTH,HEIGHT);
		this.setLayout(null);
		this.setVisible(true);
		
		m.addObserver(this);
		
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
