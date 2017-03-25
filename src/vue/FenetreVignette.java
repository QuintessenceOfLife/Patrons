package vue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import model.Observateur;

public class FenetreVignette extends JInternalFrame implements Observateur {
	
	// Attributs
	JPanel vignette;
	
	public FenetreVignette(String label, int width, int height, int locationX, int locationY){
		super(label, true, true, true, true);
		
		// Specifications de la perspective
		vignette = new JPanel();

		// Ajout
		setContentPane(vignette);
		setClosable(false);
	    setSize(width, height);
	    setLocation(locationX, locationY);
	   	setVisible(true);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
