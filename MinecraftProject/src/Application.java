

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class Application extends Frame implements WindowListener{
	
	int WIDTH = 1200;
	int HEIGHT = 800;
	
	public Application() {

		Modele m = new Modele();
		Controleur c = new Controleur(m);
		
		AffichageCraft AffCraft= new AffichageCraft(c,m);
		
		Panel inv = new Panel();
		Panel panCraft = new Panel();
		
		inv.setBounds(40, 50, 500, 200);;
		inv.setBackground(Color.pink);
		inv.add(AffCraft);
		
		panCraft.setBounds(40, 50, 500, 200);;
		panCraft.setBackground(Color.red);
		panCraft.add(inv);
		this.add(panCraft);
		
		this.addWindowListener(this);
		this.setTitle("MinecraftProject");
		this.setSize(WIDTH,HEIGHT);
		this.setLayout(null);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Application();
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0); 
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
