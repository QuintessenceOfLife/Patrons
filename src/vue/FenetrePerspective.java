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
 * Nom du fichier: FenetrePerspective.java
 * Date cree: 2017-03-23
 *******************************************************/

package vue;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import controller.CtrlPerspective;
import model.Photo;
import model.Observateur;
import model.Perspective;

/*****************************************************************************
 * Classe qui permet l'instanciation d'une fenetre qui contiendrait une perspective.
 * Contient:
 * - Le modèle de la perspective
 * - Le modèle de la photo
 * - Numéro de la fenêtre
 * - Une copie de l'image
 * - Le fichier photo
 * @author Youssef Soliman, Yassine Abdellaoui, Raph Jobin, Victor Trinh
 *****************************************************************************/
@SuppressWarnings("serial")
public class FenetrePerspective extends JPanel implements Observateur {

	/*****************************
	 * VARIABLES
	 *****************************/
	private Perspective perspectiveM; //le modèle de cette vue
	private Photo photo;
	private int numFenetre;
	private BufferedImage myPicture;
	private File fichierPhoto;

	/*****************************
	 * ACCESSEURS
	 *****************************/
	public int getNumFenetre() {
		return numFenetre;
	}

	/**
	 * Constructeur
	 * @param numFenetre Le numéro de la fenêtre
	 * @param perspectiveM Le modèle de la perspective
	 * @param photo Le modèle de la photo
	 */
	public FenetrePerspective(int numFenetre, Perspective perspectiveM, Photo photo) {
		this.numFenetre = numFenetre;
		this.photo = photo;
		this.perspectiveM = perspectiveM;
		//Enregistre cette vue auprès de son modèle en tant qu'observateur
		this.perspectiveM.setObservateur(this); 
		new CtrlPerspective(this, perspectiveM);
		setLayout(new BorderLayout());	
	}

	/**
	 * Lorsqu'il y a changement du fichier photo dans le modèle, il faut changer la photo dans
	 * la fenêtre perspective.
	 */
	@Override
	public void update() {				
		if ( (fichierPhoto == null) || (!fichierPhoto.equals( photo.getFichierPhoto()) ) ) 			
			try {
				fichierPhoto = photo.getFichierPhoto();
				myPicture = ImageIO.read(fichierPhoto);
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "Erreur de lecture du fichier image!", "IOException", JOptionPane.ERROR_MESSAGE);
			}
		paintComponent(getGraphics());
	}

	/**
	 * Dessine un graphics dans la fenêtre (l'image).
	 * @param g Graphics
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);		
		Graphics2D g2d = (Graphics2D) g;
		double dx1 = perspectiveM.getX1();
		double dy1 = perspectiveM.getY1();
		double dx2 = perspectiveM.getX2();
		double dy2 = perspectiveM.getY2();	
		g2d.drawImage(myPicture, (int)dx1, (int)dy1, (int)(dx2-dx1), (int)(dy2-dy1), null);
		g2d.dispose();
	}

	/*****************************
	 * SETTERS
	 *****************************/
	public void setMousePressedListener(MouseListener ml) {
		addMouseListener(ml);
	}

	public void setZoomListener(MouseWheelListener mwl) {
		addMouseWheelListener(mwl);
	}

	public void setTranslateListener(MouseMotionListener mml) {
		addMouseMotionListener(mml);
	}

	public void setMouseReleasedListener(MouseListener mrl) {
		addMouseListener(mrl);
	}

}
