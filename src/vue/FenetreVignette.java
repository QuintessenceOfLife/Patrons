package vue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import model.Observateur;
import model.Perspective;

@SuppressWarnings("serial")
public class FenetreVignette extends JInternalFrame implements Observateur {
	
	// Attributs
	JPanel vignette;	
	private static Perspective vignetteM; //le modèle de cette vue
	
	public FenetreVignette(String label, int width, int height, int locationX, int locationY, Perspective vignetteM){
		super(label, true, true, true, true);
		
		FenetreVignette.vignetteM = vignetteM;
		vignetteM.setObservateur(this); //Enregistre cette vue auprès de son modèle en tant qu'observateur
		
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
