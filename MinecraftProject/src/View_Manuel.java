import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class View_Manuel extends Panel implements Observer{
	
	int WIDTH = 1000;
	int HEIGHT = 600;
	
	
	public View_Manuel(ActionListener al,Modele m) {

		Font fontTitre = new Font("Arial",Font.BOLD,40);
		Font fontMenu = new Font("Arial",Font.BOLD,40);
		
		Button retour = new Button("Retour");
		retour.setBounds(this.WIDTH/2, this.HEIGHT/2, 200, 100);
		retour.setBackground(Color.CYAN);
		retour.setFont(fontMenu);
		retour.addActionListener(al);
		
		
		this.add(retour);
		
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
