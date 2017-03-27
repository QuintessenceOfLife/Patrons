import java.io.File;

import controller.Recuperer;
import controller.Sauvegarder;
import model.Image;
import model.Perspective;
import vue.ObservateurPerspective;
import vue.ObservateurVignette;

public class Test {
	
	public static void main(String[] args) {	
		
		//create the model
		Image image = Image.getInstance();
		Perspective perspective1 = Perspective.getPerspective1();
		Perspective perspective2 = Perspective.getPerspective2();
		
		//create the view
//		ObservateurVignette obsVignette = new ObservateurVignette(image);
//		ObservateurPerspective obsPerspective1 = new ObservateurPerspective(perspective1);
//		ObservateurPerspective obsPerspective2 = new ObservateurPerspective(perspective2);
		new ObservateurVignette(image);
		new ObservateurPerspective(perspective1);
		new ObservateurPerspective(perspective2);
		
		//initialize the model
//		File fichierImage = new File("wolf.jpg");		
//		image.setFichierImage(fichierImage);		
//		perspective1.setCoordinates(150, 250, 350, 450);		
//		perspective2.setCoordinates(0, 0, 1200, 800);	
		
		File sauvegarde = new File("sauvegarde");
					
//		new Sauvegarder(sauvegarde);

		new Recuperer(sauvegarde);
		
	}

}
