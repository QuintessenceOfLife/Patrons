package model;

import java.io.File;
import java.io.Serializable;

public class Photo implements Observable, Serializable {
	
	private static Photo instance = new Photo();
	private File fichierPhoto;
	private Observateur observateur;
	
	private Photo() {}
	
	public static Photo getInstance() {
		return instance; 
	}

	public File getFichierImage() {
		return fichierPhoto;
	}

	public void setFichierImage(File fichierImage) {
		this.fichierPhoto = fichierImage;
		notifier();
	}
	
	public void setObservateur(Observateur observateur) {
		this.observateur = observateur;		
	}
	
	@Override
	public void notifier() {
		observateur.update();		
	}
	
}
