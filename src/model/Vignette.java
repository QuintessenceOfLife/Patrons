package model;

import java.io.File;

public class Vignette implements Observable {

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
