package vue;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Photo;
import model.Observateur;
import model.Perspective;

@SuppressWarnings("serial")
public class FenetrePerspective extends JPanel implements Observateur {
	
	// Attributs
	private Perspective perspectiveM; //le modèle de cette vue
	
	public FenetrePerspective(Perspective perspectiveM) {
		this.perspectiveM = perspectiveM;  
	   	this.perspectiveM.setObservateur(this); //Enregistre cette vue auprès de son modèle en tant qu'observateur	
	}

	@Override
	public void update() {
		try {
			removeAll();
			
			BufferedImage myPicture = ImageIO.read(Photo.getInstance().getFichierImage());
			
			double resolutionImage = (double) (myPicture.getWidth()) / (double) (myPicture.getHeight());
			double resolutionPanel = (double) getSize().width / (double) getSize().height;
			int width;
			int height;
			
			if (resolutionImage > resolutionPanel){
				width = getSize().width;
				height = (int) (getSize().width / resolutionImage);
			} else {
				width = (int) (getSize().height * resolutionImage);
				height = getSize().height;
			}
			
			JLabel picLabel = new JLabel(new ImageIcon(myPicture.getScaledInstance(width, height, Image.SCALE_SMOOTH)));
			add(picLabel);
			
			revalidate();
			repaint();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
