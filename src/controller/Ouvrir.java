package controller;

import java.io.File;

import javax.swing.ImageIcon;

public class Ouvrir extends Commande {
	
	private File file;
	
	public Ouvrir(File file) {
		this.file = file;
	}
	
	@Override
	public void faire() {
		photo.setFichierPhoto(file);
			
		ImageIcon image = new ImageIcon(file.getAbsolutePath());
		
		//dans cette ordre pour contourner le problème de always draw on top du tabbedPane
		perspective2.setCoordinates(0, 0, image.getIconWidth(), image.getIconHeight());
		perspective1.setCoordinates(0, 0, image.getIconWidth(), image.getIconHeight());		
	}

	@Override
	public void defaire() {	
		//Ne pas appeler cette méthode!
        throw new NoSuchMethodError();
	}

}