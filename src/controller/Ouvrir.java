package controller;

import java.io.File;

import javax.swing.JFileChooser;

import model.Perspective;
import vue.FiltreMenuOuvrir;

public class Ouvrir extends Commande {

	private Perspective p;
	
	public Ouvrir(Perspective p) {
		this.p = p;
	}
	
	@Override
	public boolean faire() {
		// TODO Auto-generated method stub
		
		// User select the image file
		JFileChooser jfc = new JFileChooser();
		jfc.setAcceptAllFileFilterUsed(false);
		jfc.addChoosableFileFilter(new FiltreMenuOuvrir());
		
		int result = jfc.showOpenDialog(null);
		
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			String filename = file.getAbsolutePath();
			
			// Update the perspectives
			System.out.println("Setting image file to: " + filename);
			p.setFichierImage(file);
		}
		return false;
	}

	@Override
	public void defaire() {
		// TODO Auto-generated method stub
		
	}

}
