package vue;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Photo;
import model.Observateur;

@SuppressWarnings("serial")
public class FenetreVignette extends JPanel implements Observateur {
	
	// Attributs
	private Photo photo; //le modèle de cette vue
	private int HEIGHT_FROM_TOP = 15;
	
	public FenetreVignette(Photo image, int width, int height, int widthDesktop){
		setSize(width, height);
		setLayout(new BorderLayout());
		this.photo = image;
		this.photo.setObservateur(this); //Enregistre cette vue auprès de son modèle en tant qu'observateur
		
	    setLocation(widthDesktop - width, HEIGHT_FROM_TOP);  		   		   	
	}
	
	public BufferedImage fitImage(BufferedImage image, int width, int height){
		BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = resizedImage.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(image, 0, 0, width, height, null);
		g2.dispose();
		return resizedImage;
	}

	@Override
	public void update() {
		try {
			removeAll();
			
			BufferedImage myPicture = ImageIO.read(Photo.getInstance().getFichierPhoto());
			
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
			
			myPicture = fitImage(myPicture, width, height);
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			add(picLabel, BorderLayout.CENTER);
			
			revalidate();
			repaint();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
