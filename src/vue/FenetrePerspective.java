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

@SuppressWarnings("serial")
public class FenetrePerspective extends JPanel implements Observateur {

	// Attributs
	private Perspective perspectiveM; //le modèle de cette vue
	private Photo photo;
	private int numFenetre;
	private BufferedImage myPicture;
	private File fichierPhoto;

	public int getNumFenetre() {
		return numFenetre;
	}

	public FenetrePerspective(int numFenetre, Perspective perspectiveM, Photo photo) {
		this.numFenetre = numFenetre;
		this.photo = photo;
		this.perspectiveM = perspectiveM;
		//Enregistre cette vue auprès de son modèle en tant qu'observateur
		this.perspectiveM.setObservateur(this); 
		new CtrlPerspective(this, perspectiveM);
		setLayout(new BorderLayout());	
	}

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
