/******************************************************
* Cours:   LOG121
* Session: H2017
* Groupe:  03
* Projet: Laboratoire #4
* Etudiant(e)s: Youssef Soliman
				Yassine Abdellaoui
				Raph Jobin
				Victor Trinh
* Professeur : 	Vincent Lacasse
* Charge : 		Patrice Boucher
* Nom du fichier: FenetreVignette.java
* Date cree: 2017-03-23
*******************************************************/

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

/*****************************************************************************
 * Classe qui permet l'instanciation d'une fenetre qui contiendrait une vignette.
 * Contient:
 * - Le modèle de la photo
 * @author Youssef Soliman, Yassine Abdellaoui, Raph Jobin, Victor Trinh
 *****************************************************************************/
@SuppressWarnings("serial")
public class FenetreVignette extends JPanel implements Observateur {
	
	/*****************************
	 * VARIABLES
	 *****************************/
	private Photo photo; //le modèle de cette vue
	private final int HEIGHT_FROM_TOP = 15;
	
	/*****************************
	 * CONSTRUCTEUR
	 *****************************/
	public FenetreVignette(Photo image, int width, int height, int widthDesktop){
		setSize(width, height);
		setLayout(new BorderLayout());
		this.photo = image;
		this.photo.setObservateur(this); //Enregistre cette vue auprès de son modèle en tant qu'observateur
		
	    setLocation(widthDesktop - width, HEIGHT_FROM_TOP);  		   		   	
	}
	
	/**
	 * Resize de l'image pour qu'elle soit au milieu et bien proportionné dans la vignette
	 * @param image Image
	 * @param width  Largeur
	 * @param height Hauteur
	 * @return resizedImage l'image resized.
	 */
	public BufferedImage fitImage(BufferedImage image, int width, int height){
		BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = resizedImage.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(image, 0, 0, width, height, null);
		g2.dispose();
		return resizedImage;
	}

	/**
	 * Lors du changement/chargement de la photo, il faut changer la photo sur la vignette.
	 */
	@Override
	public void update() {
		try {
			removeAll();
			
			BufferedImage myPicture = ImageIO.read(photo.getFichierPhoto());
			
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
			e.printStackTrace();
		}
	}
}
