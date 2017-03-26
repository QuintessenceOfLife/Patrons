package vue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import model.Observateur;
import model.Vignette;

@SuppressWarnings("serial")
public class FenetreVignette extends JInternalFrame implements Observateur {
	
	// Attributs
	JPanel vignette;
	Vignette vignetteM; //le modèle de cette vue
	
	public FenetreVignette(String label, int width, int height, int locationX, int locationY, Vignette vignetteM){
		super(label, true, true, true, true);
		
		// Specifications de la vignette
		vignette = new JPanel();
				
		// Ajout
		setContentPane(vignette);
		setClosable(false);
	    setSize(width, height);
	    setLocation(locationX, locationY);
	   	setVisible(true);
	   		   	
	   	this.vignetteM = vignetteM;
	   	this.vignetteM.setObservateur(this); //Enregistre cette vue auprès de son modèle en tant qu'observateur
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
