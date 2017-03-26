package model;

import java.io.File;
import java.io.Serializable;

public class Vignette implements Observable, Serializable {

	private static final long serialVersionUID = -5530688886023806350L;
	Observateur obs;
	File fichierImage;
	
	public void setObservateur(Observateur obs) {
		this.obs = obs;
	}
	
	public File getFichierImage() {
		return fichierImage;
	}
	
	public void setFichierImage(File fichierImage) {
		this.fichierImage = fichierImage;
		notifier();
	}
		
	@Override
	public void notifier() {
		obs.update();
	}

}
