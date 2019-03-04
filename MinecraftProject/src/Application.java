


import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class Application extends Frame implements WindowListener{
	
	int tailleCase = 48;
	int border = 2;

	
	public Application() {

		Modele m = new Modele();
		Controleur c = new Controleur(m);
		View_Craft craft = new View_Craft(c,m);
		
		
		this.add(craft);
		//this.AffichageCraft(c,m);
		this.addWindowListener(this);
		this.setTitle("MinecraftProject");
		this.pack();
		this.setLayout(null);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Application();
	}
	
	public void AffichageCraft( Controleur c, Modele m) {

		
		
		
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
