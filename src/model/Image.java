package model;

import java.io.File;

public class Image implements Observable {
	
	private static Image instance = new Image();
	private File fichierImage;
	private Observateur observateur;
	
	private Image() {}
	
	public static Image getInstance() {
		return instance; 
	}

	public File getFichierImage() {
		return fichierImage;
	}

	public void setFichierImage(File fichierImage) {
		this.fichierImage = fichierImage;
	}
	
	public void setObservateur(Observateur observateur) {
		this.observateur = observateur;		
	}
	
	@Override
	public void notifier() {
		observateur.update();		
	}
	
}
