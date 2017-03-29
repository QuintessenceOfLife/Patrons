package vue;

import java.awt.Image;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
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
	JLabel picLabel;
	private double zoom = 1.0;
	
	public FenetrePerspective(Perspective perspectiveM) {
		this.perspectiveM = perspectiveM;  
	   	this.perspectiveM.setObservateur(this); //Enregistre cette vue auprès de son modèle en tant qu'observateur	
	    addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent e) {
                int notches = e.getWheelRotation();
                double temp = zoom - (notches * 0.2);
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
        System.out.println(zoom);
        BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(Photo.getInstance().getFichierImage());
			ImageIcon image = new ImageIcon(myPicture.getScaledInstance((int) (myPicture.getWidth() * zoom), (int) (myPicture.getHeight() * zoom), Image.SCALE_SMOOTH));
	        picLabel.setIcon(image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			
			picLabel = new JLabel(new ImageIcon(myPicture.getScaledInstance(width, height, Image.SCALE_SMOOTH)));
			add(picLabel);
			
			revalidate();
			repaint();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
