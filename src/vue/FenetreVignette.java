package vue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import model.Image;
import model.Observateur;

@SuppressWarnings("serial")
public class FenetreVignette extends JInternalFrame implements Observateur {
	
	// Attributs
	JPanel vignette;	
	private static Image image; //le modèle de cette vue
	
	public FenetreVignette(String label, int width, int height, int locationX, int locationY, Image image){
		super(label, true, true, true, true);
		
		FenetreVignette.image = image;
		image.setObservateur(this); //Enregistre cette vue auprès de son modèle en tant qu'observateur
		
		// Specifications de la vignette
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
