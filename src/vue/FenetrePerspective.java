package vue;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Box;
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
	private BufferedImage myPicture;
	private JLabel picLabel;
	private double zoom = 1.0;

	public FenetrePerspective(Perspective perspectiveM) {
		setLayout(new BorderLayout());
		this.perspectiveM = perspectiveM;  
		this.perspectiveM.setObservateur(this); //Enregistre cette vue auprès de son modèle en tant qu'observateur	
		addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				int notches = e.getWheelRotation();
				double temp = zoom - (notches * 0.1);
				// minimum zoom factor is 1.0
				temp = Math.max(temp, 1.0);
				if (temp != zoom) {
					zoom = temp;
					resizeImage();
				}
			}

		});
	}

	public void resizeImage() {
		ImageIcon image = new ImageIcon(fitImage(myPicture, (int) (myPicture.getWidth() * zoom), (int) (myPicture.getHeight() * zoom)));
		picLabel.setIcon(image);
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

			myPicture = ImageIO.read(Photo.getInstance().getFichierImage());

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

			picLabel = new JLabel(new ImageIcon(myPicture));
			add(picLabel, BorderLayout.CENTER);

			revalidate();
			repaint();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
