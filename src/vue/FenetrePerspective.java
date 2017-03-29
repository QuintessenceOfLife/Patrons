package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Image;
import model.Observateur;
import model.Perspective;

@SuppressWarnings("serial")
public class FenetrePerspective extends JPanel implements Observateur {
	
	// Attributs
	private Perspective perspectiveM; //le modèle de cette vue
	private Image imageM;
	
	public FenetrePerspective(Perspective perspectiveM, Image imageM) {

		this.imageM = imageM;
		this.perspectiveM = perspectiveM;  
		
		imageM.setObservateur(this);
	   	perspectiveM.setObservateur(this); //Enregistre cette vue auprès de son modèle en tant qu'observateur	
	}

	@Override
	public void update() {
		try {
			BufferedImage myPicture;
			myPicture = ImageIO.read(new File(Image.getInstance().getFichierImage().getAbsolutePath()));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			add(picLabel);
			
			revalidate();
			repaint();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
