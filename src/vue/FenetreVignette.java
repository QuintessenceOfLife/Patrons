package vue;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Image;
import model.Observateur;

@SuppressWarnings("serial")
public class FenetreVignette extends JPanel implements Observateur {
	
	// Attributs
	private Image image; //le modèle de cette vue
	private int HEIGHT_FROM_TOP = 15;
	
	public FenetreVignette(Image image, int width, int height, int widthDesktop){
		setSize(width, height);
		this.image = image;
//		image.setObservateur(this); //Enregistre cette vue auprès de son modèle en tant qu'observateur
		
	    setLocation(widthDesktop - width, HEIGHT_FROM_TOP);  		   		   	
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
//		try {
//		
//			BufferedImage myPicture = ImageIO.read(new File(Image.getInstance().getFichierImage().getAbsolutePath()));
//			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
//			add(picLabel);
//			
//			revalidate();
//			repaint();
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
