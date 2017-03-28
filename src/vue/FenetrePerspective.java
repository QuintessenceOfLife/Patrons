package vue;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Observateur;
import model.Perspective;

@SuppressWarnings("serial")
public class FenetrePerspective extends JInternalFrame implements Observateur {
	
	// Attributs
	JPanel perspective;
	private static Perspective perspectiveM; //le modèle de cette vue
	
	public FenetrePerspective(String label, int width, int height, int locationX, int locationY, Perspective perspectiveM) {
		super(label, true, true, true, true);
		
		FenetrePerspective.perspectiveM = perspectiveM;   	
	   	perspectiveM.setObservateur(this); //Enregistre cette vue auprès de son modèle en tant qu'observateur
		
	   	// Specifications de la perspective
		perspective = new JPanel();

		// Ajout
		setContentPane(perspective);
		setClosable(false);
	    setSize(width, height);
	    setLocation(locationX, locationY);
	   	setVisible(true);		   	
	}

	@Override
	public void update() {
		
	// TODO
//		JLabel image = new JLabel("", new ImageIcon(Perspective.getFichierImage().getAbsolutePath()), JLabel.CENTER);
//		perspective.add(image);
//		revalidate();
//		repaint();
	}
}
