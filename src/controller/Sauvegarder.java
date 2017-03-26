package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Sauvegarder extends Commande implements ISauvegarder {

	private File sauvegarde;
	private Object[] data;
	
	/**
	 * Constructeur
	 * @param data tableau contenant les objets vignette, perspective1 et perspective2 à sauvegarder.
	 * @param sauvegarde le fichier cible de la sauvegarde.
	 */
	public Sauvegarder(Object[] data, File sauvegarde) {
		this.data = data;
		this.sauvegarde = sauvegarde;
		gestionnaire.executerCommande(this);
	}

	/**
	 * Effectuer la sauvegarde.
	 * @return
	 */
	@Override
	public boolean faire() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(sauvegarde));) {			
			oos.writeObject(data);			
		} catch (IOException e) {
			e.printStackTrace();
		} 		
		return false;
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
