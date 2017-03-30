package controller;

import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Ouvrir extends Commande {

	public Ouvrir() {
		gestionnaire.executerCommande(this);
	}
	
	@Override
	public boolean faire() {
		JFileChooser fileChooser = new JFileChooser();
		
		FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(imageFilter);
		
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
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
