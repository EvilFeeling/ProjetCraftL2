import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class View_Menu extends Panel implements Observer{
	int WIDTH = 1000;
	int HEIGHT = 600;
	
	
	public View_Menu(ActionListener al,Modele m) {

		Font fontTitre = new Font("Arial",Font.BOLD,40);
		Font fontMenu = new Font("Arial",Font.BOLD,40);
		
		//AffichageCraft AffCraft= new AffichageCraft(c,m);
		
		Label menu= new Label("Menu");
		menu.setBounds(this.WIDTH/2 - 100,50,200,100);
		menu.setBackground(Color.GREEN);
		menu.setFont(fontMenu);
		
		
		Button craft = new Button("Craft");
		craft.setBounds(this.WIDTH/2 - 50,this.HEIGHT/2,100,50);
		craft.setBackground(Color.RED);
		craft.setFont(fontMenu);
		craft.addActionListener(al);
		
		Button manuel = new Button("Manuel d'utilisation");
		manuel.setBounds(this.WIDTH/2 - 50,this.HEIGHT/2 + 100,100,50);
		manuel.setBackground(Color.CYAN);
		manuel.setFont(fontMenu);
		manuel.addActionListener(al);
		
		
		this.add(craft);
		this.add(menu);
		this.add(manuel);
		
		
		
		
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
