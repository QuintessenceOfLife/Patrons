package vue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import model.Observateur;

public class FenetrePerspective extends JInternalFrame implements Observateur {
	
	// Attributs
	JPanel perspective;
	
	public FenetrePerspective(String label, int width, int height, int locationX, int locationY){
		super(label, true, true, true, true);
		
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
		// TODO Auto-generated method stub
		
	}
}
