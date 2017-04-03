package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Recuperer extends Commande {

	private File sauvegarde;
	
	/**
	 * Constructeur	
	 * @param sauvegarde fichier contenant les données à récupérer.
	 */
	public Recuperer(File sauvegarde) {
		this.sauvegarde = sauvegarde;
	}
		
	/**
	 * Récupérer l'image et les deux perspectives à partir de la sauvegarde.
	 * @return
	 */
	@Override
	public void faire() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sauvegarde));) {			
			Object[] objects = (Object[]) ois.readObject();				
			photo.setFichierPhoto( ((File) objects[0]) );
			//dans cette ordre pour contourner le problème de always draw on top du tabbedPane
			perspective2.setCoordinates( 
					((double) objects[5]), 
					((double) objects[6]), 
					((double) objects[7]), 
					((double) objects[8]));
			perspective1.setCoordinates( 
					((double) objects[1]),
					((double) objects[2]),
					((double) objects[3]), 
					((double) objects[4]));												
		} catch (ClassNotFoundException | IOException e) {		
			e.printStackTrace();
		}				
	}

}
