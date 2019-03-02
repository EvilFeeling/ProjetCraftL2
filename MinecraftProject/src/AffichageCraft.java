import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ItemListener;
import java.util.Observable;
import java.util.Observer;



public class AffichageCraft extends Canvas implements Observer{
	item test;
	public AffichageCraft(ItemListener l,Modele m) {
		
		this.setBackground(Color.GRAY);
		this.setSize(50,50);

		m.addObserver(this);
		
	}
	
	public void paint(Graphics g) {
		
		test = new item();
		g.drawImage(test.img,0,0,48,48,null);
			
		
	}
	@Override
	public void update(Observable o, Object arg) {
		//this.propositions = (Rangee[])arg;
		repaint();
	}
}
