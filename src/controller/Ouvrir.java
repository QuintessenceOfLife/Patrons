package controller;

import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Ouvrir extends Commande {
	
	private File file;
	
	public Ouvrir(File file) {
		this.file = file;
		gestionnaire.executerCommande(this);
	}
	
	@Override
	public boolean faire() {
		photo.setFichierPhoto(file);
			
			ImageIcon image = new ImageIcon(file.getAbsolutePath());
			
			perspective1.setCoordinates(0, 0, image.getIconWidth(), image.getIconHeight());
			perspective2.setCoordinates(0, 0, image.getIconWidth(), image.getIconHeight());
		}
		return false;
	}

	@Override
	public void defaire() {
		// TODO Auto-generated method stub
		
	}
}
