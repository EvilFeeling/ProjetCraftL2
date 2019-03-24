


import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class Application extends Frame implements WindowListener{
	
	int tailleCase = 48;
	int border = 2;

	
	public Application() {
		this.setLayout(new BorderLayout());
		Modele m = new Modele();
		Controleur c = new Controleur(m,this);
		
		//View_Menu menu = new View_Menu(c,m);
		//menu.setVisible(false);
		AffichageCraft(c,m);
		
		//this.AffichageCraft(c,m);
		this.addWindowListener(this);
		
		this.setTitle("MinecraftProject");
		this.pack();
		this.setVisible(true);
		//System.out.println(Controleur.modl);
	}
	
	
	
	public static void main(String[] args) {
		new Application();
	}
	
	public void AffichageMenu(Controleur c, Modele m) {
		this.removeAll();
		View_Menu menu = new View_Menu(c,m);
		this.add(menu, BorderLayout.CENTER);
		
	}
	
	public void AffichageCraft( Controleur c, Modele m) {
		this.removeAll();
		View_Craft craft = new View_Craft(c,m);
		this.add(craft, BorderLayout.CENTER);
	}
	
	public void AffichageManuel(Controleur c, Modele m) {
		this.removeAll();
		View_Manuel manuel = new View_Manuel(c,m);
		this.add(manuel, BorderLayout.CENTER);
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
