package model;

import java.io.File;

public class Vignette implements Observable {

	Observateur obs;
	File fichierImage;
	
	public File getFichierImage() {
		return fichierImage;
	}
	
	public void setFichierImage(File fichierImage) {
		this.fichierImage = fichierImage;
		notifier();
	}
	

	/**
	 * Constructeur
	 * @param obs l'observateur de cette vignette
	 */
	public Vignette(Observateur obs) {
		this.obs = obs;
	}
	
	@Override
	public void notifier() {
		obs.update();
	}

}
