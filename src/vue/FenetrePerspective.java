package vue;

import java.awt.BorderLayout;
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
import javax.swing.JPanel;

import controller.CtrlPerspective;
import model.Photo;
import model.Observateur;
import model.Perspective;

@SuppressWarnings("serial")
public class FenetrePerspective extends JPanel implements Observateur {

	// Attributs
	private Perspective perspectiveM; // le modèle de cette vue
	private Photo photo;
	private int numFenetre;
	private BufferedImage myPicture;
	private int x1, y1, x2, y2;

	public int getNumFenetre() {
		return numFenetre;
	}

	public FenetrePerspective(int numFenetre, Perspective perspectiveM, Photo photo) {
		this.numFenetre = numFenetre;
		this.photo = photo;
		this.perspectiveM = perspectiveM;
		this.perspectiveM.setObservateur(this); // Enregistre cette vue auprès
												// de son modèle en tant
												// qu'observateur
		new CtrlPerspective(this, perspectiveM);
		setLayout(new BorderLayout());
	}

	@Override
	public void update() {		
		paintComponent(getGraphics());
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);		
		Graphics2D g2d = (Graphics2D) g;
		try {
			myPicture = ImageIO.read(photo.getFichierImage());
		} catch (IOException e) {
			e.printStackTrace();
			// TODO show the error message in a dialog-box			
			return;
		}
		g2d.clearRect(x1, y1, x2, y2);
		x1 = perspectiveM.getX1();
		y1 = perspectiveM.getY1();
		x2 = perspectiveM.getX2();
		y2 = perspectiveM.getY2();		
		g2d.drawImage(myPicture, x1, y1, x2-x1, y2-y1, this);
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

}
