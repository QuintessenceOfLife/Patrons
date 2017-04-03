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
			perspective1.setCoordinates( 
					((double) objects[1]),
					((double) objects[2]),
					((double) objects[3]), 
					((double) objects[4]));			
			perspective2.setCoordinates( 
					((double) objects[5]), 
					((double) objects[6]), 
					((double) objects[7]), 
					((double) objects[8]));						
		} catch (ClassNotFoundException | IOException e) {		
			e.printStackTrace();
		}				
	}

	/**
	 * Il est interdit d'appeler cette méthode!
	 * @throws NoSuchMethodError
	 */
	@Override
	public void defaire() {
		//Ne pas appeler cette méthode!
        throw new NoSuchMethodError();
	}

}
