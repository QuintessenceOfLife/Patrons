package vue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class FenetrePerspective extends JInternalFrame {
	
	// Attributs
	JPanel perspective;
	
	public FenetrePerspective(String label){
		super(label, true, true, true, true);
		
		// Specifications de la perspective
		perspective = new JPanel();

		// Ajout
		setContentPane(perspective);
		setClosable(false);
	    setSize(400, 300);
	   	setVisible(true);
	}
}
