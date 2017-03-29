package controller;

import java.io.File;

import javax.swing.JFileChooser;
import model.Perspective;
import vue.FiltreMenuOuvrir;

public class Ouvrir extends Commande {

	public Ouvrir() {
		gestionnaire.executerCommande(this);
	}
	
	@Override
	public boolean faire() {
		JFileChooser fileChooser = new JFileChooser();
		
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(new FiltreMenuOuvrir());
		
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			image.setFichierImage(file);
			
			// TODO: Set coordinates
//			perspective1.setCoordinates(x1, y1, x2, y2);
//			perspective2.setCoordinates(x1, y1, x2, y2);
		}
		return false;
	}

	@Override
	public void defaire() {
		// TODO Auto-generated method stub
		
	}
}
