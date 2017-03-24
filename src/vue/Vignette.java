package vue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class Vignette extends JInternalFrame{
	
	// Attributs
	JPanel vignette;
	
	public Vignette(String label){
		super(label, true, true, true, true);
		
		// Specifications de la perspective
		vignette = new JPanel();

		// Ajout
		setContentPane(vignette);
		setClosable(false);
	    setSize(400, 300);
	   	setVisible(true);
	}
}
