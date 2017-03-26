import java.io.File;

import controller.Recuperer;
import controller.Sauvegarder;
import model.Data;
import model.Perspective;
import model.Vignette;
import vue.ObservateurPerspective;

public class Test {
	
	public static void main(String[] args) {
	
//		Vignette vignette = new Vignette(() -> System.out.println("Dans le update() de l'observateur de la vignette"));
//		Perspective perspective1 = new Perspective(() -> System.out.println("Dans le update() de l'observateur de la perspective1"));
//		Perspective perspective2 = new Perspective(() -> System.out.println("Dans le update() de l'observateur de la perspective2"));
//		GenericObserver obs = new GenericObserver();
//		Vignette vignette = new Vignette(obs);
//		Perspective perspective1 = new Perspective(obs);
//		Perspective perspective2 = new Perspective(obs);		
//		File fichierImage = new File("wolf.jpg");
//		vignette.setFichierImage(fichierImage);
//		perspective1.init(fichierImage, 1200, 800);
//		perspective2.init(fichierImage, 1200, 800);		
		Vignette vignette = null;
		Perspective perspective1 = null;
		Perspective perspective2 = null;
		
//		Data data = new Data(vignette, perspective1, perspective2);

		
		File sauvegarde = new File("sauvegarde");
		
//		Sauvegarder sauvegarder = new Sauvegarder(data, sauvegarde);
		
		Recuperer recuperer = new Recuperer(vignette, perspective1, perspective2, sauvegarde);
		vignette.notify();
		perspective1.notify();
		perspective2.notify();		
		
	}
	
}
