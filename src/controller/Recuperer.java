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
		gestionnaire.executerCommande(this);
	}
		
	/**
	 * Récupérer l'image et les deux perspectives à partir de la sauvegarde.
	 * @return
	 */
	@Override
	public boolean faire() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sauvegarde));) {			
			Object[] objects = (Object[]) ois.readObject();				
			photo.setFichierPhoto( ((File) objects[0]) );
			perspective1.setCoordinates( 
					((int) objects[1]),
					((int) objects[2]),
					((int) objects[3]), 
					((int) objects[4]));			
			perspective2.setCoordinates( 
					((int) objects[5]), 
					((int) objects[6]), 
					((int) objects[7]), 
					((int) objects[8]));						
		} catch (ClassNotFoundException | IOException e) {		
			e.printStackTrace();
		}				
		return false; //toujours
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
