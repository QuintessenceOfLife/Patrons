package vue;

import java.io.Serializable;

import model.Photo;
import model.Observateur;

public class ObservateurVignette implements Observateur, Serializable {
	
	private static final long serialVersionUID = -5146770680951693576L;
	
	private Photo image; //modèle
	
	public ObservateurVignette(Photo image) {
		this.image = image;
		image.setObservateur(this);
	}

	@Override
	public void update() {		
		System.out.println("----------dans ObservateurVignette.update()----------------");
		System.out.println(image.getFichierPhoto().toString());
		System.out.println("-----------------------------------------------------------");
	}

}
