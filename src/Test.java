import java.io.File;

import controller.Recuperer;
import controller.Sauvegarder;
import model.Data;
import model.Perspective;
import model.Vignette;
import vue.ObservateurPerspective;
import vue.ObservateurVignette;

public class Test {
	
	public static void main(String[] args) {	
		
		//create the model
		Vignette vignette = new Vignette();
		Perspective perspective1 = new Perspective();
		Perspective perspective2 = new Perspective();
		
		//mock the view
		vignette.setObservateur(new ObservateurVignette(vignette));		
		perspective1.setObservateur(new ObservateurPerspective(perspective1));		
		perspective2.setObservateur(new ObservateurPerspective(perspective2));
		
		//initialize the model
//		File fichierImage = new File("wolf.jpg");		
//		vignette.setFichierImage(fichierImage);		
//		perspective1.init(fichierImage, 1200, 800);		
//		perspective2.init(fichierImage, 1200, 800);		
//			
//		Data data = new Data(vignette, perspective1, perspective2);
		
		File sauvegarde = new File("sauvegarde");
					
//		new Sauvegarder(data, sauvegarde);
		
		new Recuperer(vignette, perspective1, perspective2, sauvegarde);
//		vignette.notifier();
//		perspective1.notifier();
//		perspective2.notifier();		
		
	}

}
