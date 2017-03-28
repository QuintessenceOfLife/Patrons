package vue;

import java.io.Serializable;

import model.Image;
import model.Observateur;

public class ObservateurVignette implements Observateur, Serializable {
	
	private static final long serialVersionUID = -5146770680951693576L;
	
	private Image image; //modèle
	
	public ObservateurVignette(Image image) {
		this.image = image;
		image.setObservateur(this);
	}

	@Override
	public void update() {		
		System.out.println("----------dans ObservateurVignette.update()----------------");
		System.out.println(image.getFichierImage().toString());
		System.out.println("-----------------------------------------------------------");
	}

}
