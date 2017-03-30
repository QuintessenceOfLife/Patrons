package controller;

import java.io.File;

public class Ouvrir extends Commande {
	
	private File file;
	
	public Ouvrir(File file) {
		this.file = file;
		gestionnaire.executerCommande(this);
	}
	
	@Override
	public boolean faire() {
		photo.setFichierPhoto(file);
			
		// TODO: Set proper coordinates
		perspective1.setCoordinates(0, 0, 400, 400);
		perspective2.setCoordinates(0, 0, 400, 400);
		return false;
	}

	@Override
	public void defaire() {
		// TODO Auto-generated method stub
		
	}
}
