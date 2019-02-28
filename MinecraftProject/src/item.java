import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class item {
	
	public String nom;
	public int x=0,y=0;
	public Image img;
	
	public item() {
		try {
			

			this.img = ImageIO.read(new File("src/images/bretagne.jpg"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
    public int hashCode() {
        return this.nom.hashCode();
    }
}
