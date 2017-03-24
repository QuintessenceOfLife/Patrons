package vue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class Vignette extends JInternalFrame{
	
	// Attributs
	JPanel vignette;
	
	public Vignette(String label, int width, int height, int locationX, int locationY){
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
}
