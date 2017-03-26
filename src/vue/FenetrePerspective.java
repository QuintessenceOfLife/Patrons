package vue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import model.Observateur;
import model.Perspective;

@SuppressWarnings("serial")
public class FenetrePerspective extends JInternalFrame implements Observateur {
	
	// Attributs
	JPanel perspective;
	Perspective perspectiveM; //Le modèle de cette vue
	
	public FenetrePerspective(String label, int width, int height, int locationX, int locationY, Perspective perspectiveM){
		super(label, true, true, true, true);
		
		// Specifications de la perspective
		perspective = new JPanel();

		// Ajout
		setContentPane(perspective);
		setClosable(false);
	    setSize(width, height);
	    setLocation(locationX, locationY);
	   	setVisible(true);
	   	
	   	this.perspectiveM = perspectiveM;
	   	this.perspectiveM.setObservateur(this); //Enregistre cette vue auprès de son modèle en tant qu'observateur
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
