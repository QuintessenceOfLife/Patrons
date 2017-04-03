package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
	private double sx1, sy1, sx2, sy2;
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
		if (sy2 ==0) {
			sx1 = perspectiveM.getX1();
			sy1 = perspectiveM.getY1();
			sx2 = perspectiveM.getX2();
			sy2 = perspectiveM.getY2();
			g2d.drawImage(myPicture, (int)sx1, (int)sy1, (int)(sx2-sx1), (int)(sy2-sy1), null);
		} else {
			double dx1 = perspectiveM.getX1();
			double dy1 = perspectiveM.getY1();
			double dx2 = perspectiveM.getX2();
			double dy2 = perspectiveM.getY2();		
			g2d.drawImage(myPicture, (int)dx1, (int)dy1, (int)dx2, (int)dy2, (int)sx1, (int)sy1, (int)sx2, (int)sy2, null);
		}
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
